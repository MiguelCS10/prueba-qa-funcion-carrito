package com.example.automation.tests;

import com.example.automation.base.BaseTest;
import com.example.automation.data.InvalidQuantities;
import com.example.automation.data.MockProducts;
import com.example.automation.pages.CartPage;
import com.example.automation.pages.ProductCatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductTest extends BaseTest {
    @Test(enabled = false, description = "TC-05 - MOCK/TODO: Disminuir/eliminar mediante input cuando exista frontend real.")
    public void tc05ShouldDecreaseOrRemoveProductWithInput() {
        CartPage cartPage = new ProductCatalogPage(driver)
                .open()
                .searchProduct(MockProducts.LAPTOP.name())
                .enterQuantity("2")
                .addProductWithButton();

        cartPage.updateQuantityWithEnter(MockProducts.LAPTOP.id(), "1");

        Assert.assertEquals(cartPage.firstProductQuantity(), 1);
    }

    @Test(enabled = false, description = "TC-06 - MOCK/TODO: Disminuir/eliminar mediante boton cuando exista frontend real.")
    public void tc06ShouldDecreaseOrRemoveProductWithButton() {
        CartPage cartPage = new ProductCatalogPage(driver)
                .open()
                .searchProduct(MockProducts.LAPTOP.name())
                .enterQuantity("2")
                .addProductWithButton();

        cartPage.decreaseProduct(MockProducts.LAPTOP.id());

        Assert.assertEquals(cartPage.firstProductName(), MockProducts.LAPTOP.name());
        Assert.assertEquals(cartPage.firstProductQuantity(), 1);
    }

    @Test(
            enabled = false,
            dataProvider = "invalidQuantities",
            dataProviderClass = InvalidQuantities.class,
            description = "TC-05 - MOCK/TODO: Validar cantidades invalidas al modificar por input cuando exista frontend real."
    )
    public void tc05ShouldRejectInvalidQuantitiesWhenUpdating(String invalidQuantity, String expectedMessage) {
        CartPage cartPage = new ProductCatalogPage(driver)
                .open()
                .searchProduct(MockProducts.LAPTOP.name())
                .enterQuantity("2")
                .addProductWithButton();

        cartPage.updateQuantity(MockProducts.LAPTOP.id(), invalidQuantity);

        Assert.assertEquals(cartPage.validationMessage(), expectedMessage);
    }
}
