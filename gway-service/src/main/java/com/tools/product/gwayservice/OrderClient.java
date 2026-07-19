package com.tools.product.gwayservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order-client", url = "http://localhost:8082")
public interface OrderClient {

    @PostMapping("/orders")
    OrderResponse createOrder(@RequestBody SimpleOrderReq request);
}

// Simple wrapper matching the structure expected by the order service
class SimpleOrderReq {
    private String productId;
    private int quantity;

    public SimpleOrderReq(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    // Getters and Setters
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
}