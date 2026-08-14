package com.example.automation.tests;

import com.example.automation.base.BaseTest;
import com.example.automation.data.MockProducts;
import com.example.automation.model.CartLine;
import com.example.automation.pages.OrderConfirmationPage;
import com.example.automation.pages.ProductCatalogPage;
import com.example.automation.utils.CartCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class ConfirmOrderTest extends BaseTest {
    @Test(enabled = false, description = "TC-09 - MOCK/TODO: Confirmar pedido cuando exista frontend real.")
    public void tc09ShouldConfirmOrder() {
        OrderConfirmationPage confirmationPage = new ProductCatalogPage(driver)
                .open()
                .searchProduct(MockProducts.LAPTOP.name())
                .enterQuantity("1")
                .addProductWithButton()
                .confirmOrder();

        BigDecimal expectedTotal = CartCalculator.expectedTotal(List.of(new CartLine(MockProducts.LAPTOP, 1)));

        Assert.assertFalse(confirmationPage.orderId().isBlank());
        Assert.assertEquals(confirmationPage.status(), "CONFIRMED");
        Assert.assertEquals(confirmationPage.total(), expectedTotal);
    }

    @Test(enabled = false, description = "TC-09 - MOCK/TODO: Evitar doble confirmacion cuando exista frontend real.")
    public void tc09ShouldPreventDoubleConfirmation() {
        OrderConfirmationPage confirmationPage = new ProductCatalogPage(driver)
                .open()
                .searchProduct(MockProducts.LAPTOP.name())
                .enterQuantity("1")
                .addProductWithButton()
                .confirmOrder();

        Assert.assertEquals(confirmationPage.duplicateConfirmationMessage(), "El pedido ya fue confirmado");
    }
}
