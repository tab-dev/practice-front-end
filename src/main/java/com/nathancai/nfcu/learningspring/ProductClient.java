package com.nathancai.nfcu.learningspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


public class ProductClient {
    private static final String RESOURCE_PATH="/rest/products";

    private Logger LOG= LoggerFactory.getLogger(ProductClient.class);
    private String REQUEST_URI;
    private RestTemplate restTemplate;

    public ProductClient(RestTemplate restTemplate, String host, int port) {
        this.restTemplate=restTemplate;
        this.REQUEST_URI=host+":"+port+RESOURCE_PATH;
    }

    public Optional<Product> getForObject(long id) {
        Product product = restTemplate.getForObject(REQUEST_URI+"/(id)",
                Product.class,
                Long.toString(id));

        return Optional.ofNullable(product);
    }
}
