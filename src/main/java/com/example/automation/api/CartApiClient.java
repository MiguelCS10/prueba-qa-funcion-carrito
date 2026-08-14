package com.example.automation.api;

import com.example.automation.core.config.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public final class CartApiClient {
    /*
     * MOCK/TODO/PLACEHOLDER:
     * This client is prepared for REST Assured, but tests must not call it
     * until a real API environment exists.
     */
    public RequestSpecification request() {
        return RestAssured.given()
                .baseUri(Config.apiBaseUrl())
                .contentType("application/json")
                .accept("application/json");
    }

    public Response addItem(CartItemRequest request) {
        return request()
                .body(request)
                .post(ApiEndpoints.ADD_CART_ITEM);
    }

    public Response updateItem(int productId, CartItemRequest request) {
        return request()
                .pathParam("productId", productId)
                .body(request)
                .patch(ApiEndpoints.UPDATE_CART_ITEM);
    }

    public Response deleteItem(int productId) {
        return request()
                .pathParam("productId", productId)
                .delete(ApiEndpoints.DELETE_CART_ITEM);
    }

    public Response getCart() {
        return request().get(ApiEndpoints.GET_CART);
    }
}
