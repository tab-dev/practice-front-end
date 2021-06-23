package com.nathancai.nfcu.learningspring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ProductController {
    private static final List<Product> products = createProducts();

    private static List<Product> createProducts(){
        List<Product> products = new ArrayList<>();

        for (int i = 0; i <= 15; i++) {
            Product product = new Product(Integer.toString(i),"Ultimate Pool Noodle " + i + "-th edition","The best pool noodle there is", BigDecimal.valueOf(i), i%10);
            products.add(product);
        }
        return products;
    }

    @GetMapping("/product")
    public String getProducts() {
        return "products";
    }
}
