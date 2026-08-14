package com.example.automation.api;

import com.example.automation.core.config.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public final class OrderApiClient {
    /*
     * MOCK/TODO/PLACEHOLDER:
     * Prepared for the future real API. Do not execute against the Internet.
     */
    public RequestSpecification request() {
        return RestAssured.given()
                .baseUri(Config.apiBaseUrl())
                .contentType("application/json")
                .accept("application/json");
    }

    public Response createOrder(OrderRequest request) {
        return request()
                .body(request)
                .post(ApiEndpoints.CREATE_ORDER);
    }

    public Response getOrder(int orderId) {
        return request()
                .pathParam("orderId", orderId)
                .get(ApiEndpoints.GET_ORDER);
    }
}
