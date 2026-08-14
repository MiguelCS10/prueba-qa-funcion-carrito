package com.example.automation.tests;

import com.example.automation.data.MockProducts;
import com.example.automation.model.CartLine;
import com.example.automation.utils.CartCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class CartTotalTest {
    @Test(description = "TC-08 - MOCK: Calcula total esperado despues de agregar/modificar sin frontend real.")
    public void tc08ShouldCalculateExpectedTotalAfterAddAndUpdate() {
        BigDecimal expectedTotal = CartCalculator.expectedTotal(List.of(
                new CartLine(MockProducts.LAPTOP, 1),
                new CartLine(MockProducts.HEADPHONES, 2)
        ));

        Assert.assertEquals(expectedTotal, new BigDecimal("1361.00"));
    }

    @Test(description = "TC-08 - MOCK: Calcula total esperado con multiples productos sin frontend real.")
    public void tc08ShouldCalculateExpectedTotalWithMultipleProducts() {
        BigDecimal expectedTotal = CartCalculator.expectedTotal(List.of(
                new CartLine(MockProducts.LAPTOP, 2),
                new CartLine(MockProducts.HEADPHONES, 1),
                new CartLine(MockProducts.MOUSE, 4)
        ));

        Assert.assertEquals(expectedTotal, new BigDecimal("2581.50"));
    }
}
