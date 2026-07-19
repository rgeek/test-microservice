package com.tools.product.gwayservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-client", url = "http://localhost:8081")
public interface ProductClient {

    @GetMapping("/products/{productId}")
    ProductResponse  getProductById(@PathVariable("productId") String productId);
}
