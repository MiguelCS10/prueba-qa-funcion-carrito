package com.example.automation.api;

public final class ApiEndpoints {
    /*
     * MOCK/TODO/PLACEHOLDER endpoints.
     * Replace these paths only after the real e-commerce API contract exists.
     */
    public static final String ADD_CART_ITEM = "/api/v1/cart/items";
    public static final String UPDATE_CART_ITEM = "/api/v1/cart/items/{productId}";
    public static final String DELETE_CART_ITEM = "/api/v1/cart/items/{productId}";
    public static final String GET_CART = "/api/v1/cart";
    public static final String CREATE_ORDER = "/api/v1/orders";
    public static final String GET_ORDER = "/api/v1/orders/{orderId}";

    private ApiEndpoints() {
    }
}
