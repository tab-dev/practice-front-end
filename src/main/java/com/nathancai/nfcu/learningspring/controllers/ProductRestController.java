package com.nathancai.nfcu.learningspring.controllers;

import com.nathancai.nfcu.learningspring.Product;
import com.nathancai.nfcu.learningspring.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {
    private final ProductRepository repository;

    ProductRestController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Product> all() {
        return repository.findAll();
    }

    @GetMapping("/products/{id}")
    Product one(@PathVariable String Id) {
        return repository.findById(Id)
                .orElseThrow(() -> new ProductNotFoundException(Id));
    }
}
