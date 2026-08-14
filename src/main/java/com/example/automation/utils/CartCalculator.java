package com.example.automation.utils;

import com.example.automation.model.CartLine;

import java.math.BigDecimal;
import java.util.Collection;

public final class CartCalculator {
    private CartCalculator() {
    }

    public static BigDecimal expectedTotal(Collection<CartLine> cartLines) {
        return cartLines.stream()
                .map(line -> line.product().unitPrice().multiply(BigDecimal.valueOf(line.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
