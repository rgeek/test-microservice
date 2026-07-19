package com.tools.product.orderservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerOrder {

    @Id
    private String orderId;
    private String productId;
    private String status;

    public CustomerOrder() {}

    public CustomerOrder(String orderId, String productId, String status) {
        this.orderId = orderId;
        this.productId = productId;
        this.status = status;
    }

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
