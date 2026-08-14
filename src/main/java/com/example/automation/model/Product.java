package com.example.automation.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class Product {
    private final int id;
    private final String name;
    private final BigDecimal unitPrice;
    private final String imageUrl;

    public Product(int id, String name, BigDecimal unitPrice, String imageUrl) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "name");
        this.unitPrice = Objects.requireNonNull(unitPrice, "unitPrice");
        this.imageUrl = Objects.requireNonNull(imageUrl, "imageUrl");
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public BigDecimal unitPrice() {
        return unitPrice;
    }

    public String imageUrl() {
        return imageUrl;
    }
}
