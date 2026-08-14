package com.example.automation.tests;

import com.example.automation.base.BaseTest;
import com.example.automation.data.MockProducts;
import com.example.automation.model.CartLine;
import com.example.automation.pages.CartPage;
import com.example.automation.pages.ProductCatalogPage;
import com.example.automation.utils.CartCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class CartTotalUiTest extends BaseTest {
    @Test(enabled = false, description = "TC-08 - TODO: Comparar total calculado contra total mostrado por frontend real.")
    public void tc08ShouldCompareExpectedTotalAgainstDisplayedTotal() {
        CartPage cartPage = new ProductCatalogPage(driver)
                .open()
                .searchProduct(MockProducts.LAPTOP.name())
                .enterQuantity("2")
                .addProductWithButton();

        BigDecimal expectedTotal = CartCalculator.expectedTotal(List.of(new CartLine(MockProducts.LAPTOP, 2)));

        Assert.assertEquals(cartPage.displayedTotal(), expectedTotal);
    }
}
