package com.tools.product.orderservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public OrderResponse placeOrder(@RequestBody OrderRequest request) {
        // Simple mock placement response
        return new OrderResponse("ORD-99972", request.getProductId(), "PENDING");
    }
}

class OrderRequest {
    private String productId;
    private int quantity;

    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
}

class OrderResponse {
    private String orderId;
    private String productId;
    private String status;

    public OrderResponse(String orderId, String productId, String status) {
        this.orderId = orderId;
        this.productId = productId;
        this.status = status;
    }

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public String getProductId() { return productId; }
    public String getStatus() { return status; }
}