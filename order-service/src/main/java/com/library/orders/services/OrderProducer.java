package com.library.orders.services;

import com.library.orders.OrderRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class OrderProducer {
    private final KafkaTemplate<String, OrderRequest> kafkaTemplate;
    public OrderProducer(KafkaTemplate<String, OrderRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(OrderRequest orderProducer) {
        CompletableFuture<SendResult<String, OrderRequest>> send = kafkaTemplate.send("orders.created", orderProducer);

    }
}
