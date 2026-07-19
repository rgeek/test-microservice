package com.tools.product.gwayservice;

// Data structure matching what Order Service returns
public class OrderResponse {
    private String orderId;
    private String productId;
    private String status;

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
