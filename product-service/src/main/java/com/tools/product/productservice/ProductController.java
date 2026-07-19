package com.tools.product.productservice;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public  void initData(){
        productRepository.save(new Product("P100", "Mechanical Keyboard", 89.99));
        productRepository.save(new Product("P200", "Ergonomic Mouse", 49.99));
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable String productId) {
        // Return mock data for testing
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found!"));
    }
}

