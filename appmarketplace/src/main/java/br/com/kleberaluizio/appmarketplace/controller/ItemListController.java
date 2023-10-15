package br.com.kleberaluizio.appmarketplace.controller;

import br.com.kleberaluizio.appmarketplace.model.ItemList;
import br.com.kleberaluizio.appmarketplace.service.IItemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemListController {

    @Autowired
    private IItemListService service;

    @PostMapping("/item-list")
    public ResponseEntity<ItemList> createItem(@RequestBody ItemList item){

        ItemList newItem = service.insertItem(item);
        if(newItem == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newItem);
    }

    @PutMapping("/item-list/{id}")
    public ResponseEntity updateItem(@PathVariable("id") Integer id, @RequestBody ItemList item){
        ItemList newItem = service.findById(id);
        if(newItem == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("item with id [%s] was not found", id));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateItem(item));
    }

    @DeleteMapping("/item-list/{id}")
    public ResponseEntity deleteItem(@PathVariable("id") Integer id){
        ItemList item = service.findById(id);

        if(item == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("item with id [%s] was not found", id));
        }
        service.deleteItem(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
