package com.example.automation.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public record EmailConfirmation(
        String recipient,
        String sender,
        String orderId,
        String status,
        BigDecimal total,
        List<CartLine> items
) {
    public EmailConfirmation {
        Objects.requireNonNull(recipient, "recipient");
        Objects.requireNonNull(sender, "sender");
        Objects.requireNonNull(orderId, "orderId");
        Objects.requireNonNull(status, "status");
        Objects.requireNonNull(total, "total");
        items = List.copyOf(Objects.requireNonNull(items, "items"));
    }
}
