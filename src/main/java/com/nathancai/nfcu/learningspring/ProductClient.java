package com.nathancai.nfcu.learningspring;

import com.nathancai.nfcu.learningspring.exceptions.ProductException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Configurable
public class ProductClient {
    private static final String RESOURCE_PATH = "/rest/products";
    private static final Logger logger = LoggerFactory.getLogger(ProductClient.class);

    private String REQUEST_URI;
    private RestTemplate restTemplate;

    public ProductClient(RestTemplate restTemplate, String host, int port) {
        this.restTemplate = restTemplate;
        this.REQUEST_URI = host + ":" + port + RESOURCE_PATH;
    }

    public Optional<Object> getProduct(long id) {
        Product product = restTemplate.getForObject(REQUEST_URI + "/{id}",
                Product.class,
                Long.toString(id));

        try {
            ResponseEntity responseEntity = restTemplate.exchange(REQUEST_URI, HttpMethod.GET, null, ProductClient.class);
            responseEntity.getBody();

            if (responseEntity == null || !responseEntity.hasBody()) {
                throw new ProductException("Did not get response");
            }

            if (responseEntity.getStatusCode().isError()) {
                throw new ProductException("HTTP error: " + responseEntity.getStatusCodeValue() + " "
                + responseEntity.getStatusCode().getReasonPhrase());
            }

            return Optional.ofNullable(responseEntity.getBody());
        } catch (Exception e) {
            throw new ProductException("Something went wrong when trying to pull product data", e);
        }
    }
}
