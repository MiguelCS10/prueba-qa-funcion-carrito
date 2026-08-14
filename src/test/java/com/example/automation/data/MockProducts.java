package com.example.automation.data;

import com.example.automation.model.Product;

import java.math.BigDecimal;

public final class MockProducts {
    /*
     * MOCK/TODO/PLACEHOLDER data.
     * Replace with stable fixture data from the real test environment.
     */
    public static final Product LAPTOP = new Product(
            1001,
            "MOCK Laptop",
            new BigDecimal("1200.00"),
            "/TODO/assets/mock-laptop.png"
    );
    public static final Product HEADPHONES = new Product(
            1002,
            "MOCK Headphones",
            new BigDecimal("80.50"),
            "/TODO/assets/mock-headphones.png"
    );
    public static final Product MOUSE = new Product(
            1003,
            "MOCK Mouse",
            new BigDecimal("25.25"),
            "/TODO/assets/mock-mouse.png"
    );

    private MockProducts() {
    }
}
