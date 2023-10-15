package br.com.kleberaluizio.appmarketplace.controller;

import br.com.kleberaluizio.appmarketplace.model.ListOfItems;
import br.com.kleberaluizio.appmarketplace.service.IListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ListOfItemsController {

    @Autowired
    private IListService service;

    @PostMapping("/List-of-items")
    public ResponseEntity createList(@RequestBody ListOfItems list){
        ListOfItems newList = service.createNewList(list);

        if(newList == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newList);
    }

    @GetMapping("/List-of-items/{id}")
    public  ResponseEntity getList(@PathVariable("id") Integer id){
        ListOfItems list = service.findById(id);

        if(list == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("List of items with id [%s] was not found", id));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    @GetMapping("/list-of-items")
    public ResponseEntity<List<ListOfItems>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findAll());
    }

    @PutMapping("/List-of-items/{id}")
    public ResponseEntity updateList(@PathVariable("id") Integer id){
        ListOfItems list = service.closeList(id);

        if(list == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }


    @DeleteMapping("/List-of-items/{id}")
    public  ResponseEntity deleteList(@PathVariable("id") Integer id){

        ListOfItems list = service.findById(id);

        if(list == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("List of items with id [%s] was not found", id));
        }

        service.deleteList(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
