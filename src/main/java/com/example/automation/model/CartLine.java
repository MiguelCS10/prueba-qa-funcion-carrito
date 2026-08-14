package com.example.automation.model;

import java.util.Objects;

public final class CartLine {
    private final Product product;
    private final int quantity;

    public CartLine(Product product, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity must not be negative");
        }
        this.product = Objects.requireNonNull(product, "product");
        this.quantity = quantity;
    }

    public Product product() {
        return product;
    }

    public int quantity() {
        return quantity;
    }
}
