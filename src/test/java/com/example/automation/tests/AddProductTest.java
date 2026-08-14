package com.example.automation.tests;

import com.example.automation.base.BaseTest;
import com.example.automation.data.InvalidQuantities;
import com.example.automation.data.MockProducts;
import com.example.automation.pages.CartPage;
import com.example.automation.pages.ProductCatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductTest extends BaseTest {
    @Test(enabled = false, description = "TC-01 - MOCK/TODO: Agregar producto mediante Enter cuando exista frontend real.")
    public void tc01ShouldAddProductWithEnter() {
        CartPage cartPage = new ProductCatalogPage(driver)
                .open()
                .searchProduct(MockProducts.LAPTOP.name())
                .enterQuantity("2")
                .addProductWithEnter();

        Assert.assertEquals(cartPage.firstProductName(), MockProducts.LAPTOP.name());
        Assert.assertEquals(cartPage.firstProductQuantity(), 2);
    }

    @Test(enabled = false, description = "TC-02 - MOCK/TODO: Agregar producto mediante boton cuando exista frontend real.")
    public void tc02ShouldAddProductWithButton() {
        CartPage cartPage = new ProductCatalogPage(driver)
                .open()
                .searchProduct(MockProducts.HEADPHONES.name())
                .enterQuantity("1")
                .addProductWithButton();

        Assert.assertEquals(cartPage.firstProductName(), MockProducts.HEADPHONES.name());
        Assert.assertEquals(cartPage.firstProductQuantity(), 1);
    }

    @Test(
            enabled = false,
            dataProvider = "invalidQuantities",
            dataProviderClass = InvalidQuantities.class,
            description = "TC-01 - MOCK/TODO: Validar cantidades invalidas en input cuando exista frontend real."
    )
    public void tc01ShouldRejectInvalidQuantities(String invalidQuantity, String expectedMessage) {
        ProductCatalogPage catalogPage = new ProductCatalogPage(driver)
                .open()
                .searchProduct(MockProducts.LAPTOP.name())
                .enterQuantity(invalidQuantity);

        catalogPage.addProductWithButton();

        Assert.assertEquals(catalogPage.validationMessage(), expectedMessage);
    }

    @Test(enabled = false, description = "TC-04 - MOCK/TODO: Validar nombre, precio e imagen cuando exista frontend real.")
    public void tc04ShouldShowExpectedProductInformation() {
        ProductCatalogPage catalogPage = new ProductCatalogPage(driver)
                .open()
                .searchProduct(MockProducts.MOUSE.name());

        Assert.assertEquals(catalogPage.selectedProductName(), MockProducts.MOUSE.name());
        Assert.assertEquals(catalogPage.selectedProductPrice(), MockProducts.MOUSE.unitPrice());
        Assert.assertTrue(catalogPage.selectedProductImageSource().contains(MockProducts.MOUSE.imageUrl()));
    }
}
