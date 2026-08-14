package com.example.automation.api;

import io.restassured.builder.ResponseBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class OrderApiContractTest {
    @Test(description = "TC-09 - MOCK: Valida respuesta conceptual de confirmacion sin llamar endpoint real.")
    public void tc09ShouldValidateCreateOrderResponseWithMockResponse() {
        Response response = new ResponseBuilder()
                .setStatusCode(201)
                .setContentType(ContentType.JSON)
                .setBody("""
                        {
                          "orderId": 7001,
                          "cartId": 5001,
                          "userId": 9001,
                          "status": "CONFIRMED"
                        }
                        """)
                .build();

        response.then()
                .statusCode(201)
                .body("orderId", equalTo(7001))
                .body("cartId", equalTo(5001))
                .body("userId", equalTo(9001))
                .body("status", equalTo("CONFIRMED"));
    }
}
