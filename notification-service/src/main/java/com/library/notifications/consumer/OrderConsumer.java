package com.library.notifications.consumer;

import com.library.notifications.dto.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {
    @KafkaListener(
            topics = "orders.created"
    )
    public void consume(OrderCreatedEvent orderCreatedEvent) {
        System.out.println("Order received: " + orderCreatedEvent.toString());
    }
}
