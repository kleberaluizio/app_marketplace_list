package br.com.kleberaluizio.appmarketplace.controller;

import br.com.kleberaluizio.appmarketplace.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl service; 
}
