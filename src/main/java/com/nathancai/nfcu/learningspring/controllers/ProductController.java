package com.nathancai.nfcu.learningspring.controllers;

import com.nathancai.nfcu.learningspring.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ProductController {

    private ProductClient productClient;

    @Autowired
    public ProductController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("/product")
    public String getProducts(Model model) {
        model.addAttribute("products", productClient.getProduct(Integer.valueOf(String.valueOf(model))));
        return "products";
    }
}
