package com.nathancai.nfcu.learningspring;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

public class Product {
    @Id
    private String id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private BigDecimal price;

    private Integer rating;

    public Product(String id, String name, String description, BigDecimal price, Integer rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getRating() {
        return rating;
    }
}
