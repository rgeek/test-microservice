package com.tools.product.gwayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class GwayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GwayServiceApplication.class, args);
    }

    // Configured bean pointing to the Product Service
    @Bean
    public WebClient productWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    // Configured bean pointing to the Order Service
    @Bean
    public WebClient orderWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8082")
                .build();
    }
}