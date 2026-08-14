package com.example.automation.api;

import io.restassured.builder.ResponseBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class CartApiContractTest {
    @Test(description = "TC-03 - MOCK: Valida respuesta conceptual de adicion sin llamar endpoint real.")
    public void tc03ShouldValidateAddItemResponseWithMockResponse() {
        Response response = new ResponseBuilder()
                .setStatusCode(201)
                .setContentType(ContentType.JSON)
                .setBody("""
                        {
                          "productId": 1001,
                          "quantity": 2,
                          "items": [
                            { "productId": 1001, "quantity": 2 },
                            { "productId": 1002, "quantity": 1 }
                          ]
                        }
                        """)
                .build();

        response.then()
                .statusCode(201)
                .body("productId", equalTo(1001))
                .body("quantity", equalTo(2))
                .body("items.find { it.productId == 1001 }.quantity", equalTo(2))
                .body("items.find { it.productId == 1002 }.quantity", equalTo(1));
    }

    @Test(description = "TC-07 - MOCK: Valida respuesta conceptual de disminucion sin llamar endpoint real.")
    public void tc07ShouldValidateDecreaseItemResponseWithMockResponse() {
        Response response = new ResponseBuilder()
                .setStatusCode(200)
                .setContentType(ContentType.JSON)
                .setBody("""
                        {
                          "productId": 1001,
                          "quantity": 1,
                          "items": [
                            { "productId": 1001, "quantity": 1 },
                            { "productId": 1002, "quantity": 1 }
                          ]
                        }
                        """)
                .build();

        response.then()
                .statusCode(200)
                .body("productId", equalTo(1001))
                .body("quantity", equalTo(1))
                .body("items.find { it.productId == 1002 }.quantity", equalTo(1));
    }

    @Test(description = "TC-07 - MOCK: Valida respuesta conceptual de eliminacion sin llamar endpoint real.")
    public void tc07ShouldValidateDeleteItemResponseWithMockResponse() {
        Response response = new ResponseBuilder()
                .setStatusCode(200)
                .setContentType(ContentType.JSON)
                .setBody("""
                        {
                          "removedProductId": 1001,
                          "items": [
                            { "productId": 1002, "quantity": 1 }
                          ]
                        }
                        """)
                .build();

        response.then()
                .statusCode(200)
                .body("removedProductId", equalTo(1001))
                .body("items.size()", equalTo(1))
                .body("items[0].productId", equalTo(1002));
    }
}
