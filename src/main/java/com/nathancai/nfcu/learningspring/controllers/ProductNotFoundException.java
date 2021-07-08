package com.nathancai.nfcu.learningspring.controllers;

public class ProductNotFoundException extends RuntimeException{
    ProductNotFoundException(String Id) {
        super("Could not find id " + Id);
    }
}
