package com.tools.product.productservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private String productId;
    private String name;
    private double price;

    public Product(){

    }

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
