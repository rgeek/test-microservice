package com.tools.product.gwayservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderClient orderClient;

    @GetMapping("/summary/{productId}")
    public CheckoutSummary getCheckoutSummary(@PathVariable String productId) {

        // 1. Fetch product details synchronously (No Mono!)
        ProductResponse product = productClient.getProductById(productId);

        // 2. Submit the order request synchronously
        OrderResponse order = orderClient.createOrder(new SimpleOrderReq(productId, 1));

        // 3. Assemble and return the plain Java payload
        return new CheckoutSummary(
                order.getOrderId(),
                product.getName(),
                product.getPrice(),
                order.getStatus()
        );
    }
}

/* MONO library
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private WebClient productWebClient;

    @Autowired
    private WebClient orderWebClient;

    @GetMapping("/summary/{productId}")
    public Mono<CheckoutSummary> getCheckoutSummary(@PathVariable String productId) {

        // 1. Fire asynchronous call to Product Service
        Mono<ProductResponse> productMono = productWebClient.get()
                .uri("/products/" + productId)
                .retrieve()
                .bodyToMono(ProductResponse.class);

        // 2. Mock payload for Order Request setup
        class SimpleOrderReq {
            public String productId;
            public int quantity = 1;
            public SimpleOrderReq(String pId) { this.productId = pId; }
        }

        // 3. Fire asynchronous POST call to Order Service
        Mono<OrderResponse> orderMono = orderWebClient.post()
                .uri("/orders")
                .bodyValue(new SimpleOrderReq(productId))
                .retrieve()
                .bodyToMono(OrderResponse.class);

        // 4. Combine both results asynchronously when they arrive
        return Mono.zip(productMono, orderMono)
                .map(tuple -> {
                    ProductResponse prod = tuple.getT1();
                    OrderResponse ord = tuple.getT2();

                    // Aggregate data into our final payload response
                    return new CheckoutSummary(
                            ord.getOrderId(),
                            prod.getName(),
                            prod.getPrice(),
                            ord.getStatus()
                    );
                });
    }
}*/