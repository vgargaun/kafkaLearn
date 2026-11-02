package com.library.notifications.dto;

public record OrderCreatedEvent(Long orderId,
                                String product,
                                int quantity
) {
}
