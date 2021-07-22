package com.nathancai.nfcu.learningspring.config;

import com.nathancai.nfcu.learningspring.ProductClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductClientConfig {
    private ProductClientConfigProperties configProperties;

    @Bean
    public ProductClient productClient(RestTemplateBuilder restTemplateBuilder) {
        return new ProductClient((restTemplateBuilder.build()), configProperties.getHost(), configProperties.getPort());
    }
}
