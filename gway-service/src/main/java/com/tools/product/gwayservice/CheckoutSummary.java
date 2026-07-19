package com.tools.product.gwayservice;

// The final unified payload returned to the user
public class CheckoutSummary {
    private String orderId;
    private String productName;
    private double price;
    private String status;

    public CheckoutSummary(String orderId, String productName, double price, String status) {
        this.orderId = orderId;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    // Getters
    public String getOrderId() { return orderId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }
}
