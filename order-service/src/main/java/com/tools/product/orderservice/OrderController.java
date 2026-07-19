package com.tools.product.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public CustomerOrder placeOrder(@RequestBody OrderRequest request) {
        // Generate a random real order ID
        String dynamicOrderId = "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        CustomerOrder newOrder=orderRepository.save(new CustomerOrder(dynamicOrderId,request.getProductId(),"CONFIRMED"));
        return newOrder;
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