package com.library.orders;

import com.library.orders.services.OrderProducer;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {
    private final OrderProducer orderProducer;

    @PostMapping("/orders")
    public ResponseEntity<String> createOrder(@Valid @RequestBody OrderRequest request) {
        orderProducer.sendOrder(request);
        return ResponseEntity.accepted().body("Order request received");
    }
}
