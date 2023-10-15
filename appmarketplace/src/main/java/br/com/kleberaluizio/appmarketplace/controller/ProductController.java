package br.com.kleberaluizio.appmarketplace.controller;

import br.com.kleberaluizio.appmarketplace.model.Product;
import br.com.kleberaluizio.appmarketplace.service.IProductService;
import br.com.kleberaluizio.appmarketplace.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private IProductService service;

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = service.createNewProduct(product);

        if(newProduct == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newProduct);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProduct(@PathVariable("id") Integer id) {
        Product p = service.findById(id);
        if (p == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("Product with id [%s] was not found", id));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(p);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listAll());
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> getProductsByKeyword(@RequestParam(name = "k") String keyword) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.searchForKeyWord(keyword));
    }
}