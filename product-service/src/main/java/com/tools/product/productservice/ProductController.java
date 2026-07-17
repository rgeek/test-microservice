package com.tools.product.productservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable String productId) {
        // Return mock data for testing
        return new Product(productId, "Mechanical Keyboard", 89.99);
    }
}

class Product {
    private String productId;
    private String name;
    private double price;

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