package com.example.automation.regression;

import com.example.automation.base.BaseTest;
import com.example.automation.data.MockProducts;
import com.example.automation.model.CartLine;
import com.example.automation.pages.CartPage;
import com.example.automation.pages.OrderConfirmationPage;
import com.example.automation.pages.ProductCatalogPage;
import com.example.automation.utils.CartCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class E2ECheckoutFlowTest extends BaseTest {
    @Test(enabled = false, description = "E2E - MOCK/TODO: Flujo completo cuando existan frontend, API y Oracle reales.")
    public void shouldCompleteCheckoutFlow() {
        CartPage cartPage = new ProductCatalogPage(driver)
                .open()
                .searchProduct(MockProducts.LAPTOP.name())
                .enterQuantity("1")
                .addProductWithButton()
                .updateQuantity(MockProducts.LAPTOP.id(), "2");

        BigDecimal expectedTotal = CartCalculator.expectedTotal(List.of(new CartLine(MockProducts.LAPTOP, 2)));

        Assert.assertEquals(cartPage.displayedTotal(), expectedTotal);

        OrderConfirmationPage confirmationPage = cartPage.confirmOrder();

        Assert.assertFalse(confirmationPage.orderId().isBlank());
        Assert.assertEquals(confirmationPage.status(), "CONFIRMED");
        Assert.assertEquals(confirmationPage.total(), expectedTotal);
    }
}
