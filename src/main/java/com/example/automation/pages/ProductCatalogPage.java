package com.example.automation.pages;

import com.example.automation.core.config.Config;
import com.example.automation.core.wait.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public final class ProductCatalogPage {
    private final WebDriver driver;

    /*
     * MOCK/TODO/PLACEHOLDER selectors.
     * Replace with stable IDs or data-testid attributes when the real DOM exists.
     */
    private final By productSearchInput = By.cssSelector("[data-testid='TODO-product-search-input']");
    private final By quantityInput = By.cssSelector("[data-testid='TODO-quantity-input']");
    private final By addButton = By.cssSelector("[data-testid='TODO-add-to-cart-button']");
    private final By validationMessage = By.cssSelector("[data-testid='TODO-quantity-validation-message']");
    private final By selectedProductName = By.cssSelector("[data-testid='TODO-product-name']");
    private final By selectedProductPrice = By.cssSelector("[data-testid='TODO-product-price']");
    private final By selectedProductImage = By.cssSelector("[data-testid='TODO-product-image']");

    public ProductCatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductCatalogPage open() {
        driver.get(Config.baseUrl() + "/TODO-catalog");
        return this;
    }

    public ProductCatalogPage searchProduct(String productName) {
        WebElement input = Waits.visible(driver, productSearchInput);
        input.clear();
        input.sendKeys(productName);
        return this;
    }

    public ProductCatalogPage enterQuantity(String quantity) {
        WebElement input = Waits.visible(driver, quantityInput);
        input.clear();
        input.sendKeys(quantity);
        return this;
    }

    public CartPage addProductWithEnter() {
        Waits.visible(driver, quantityInput).sendKeys(Keys.ENTER);
        return new CartPage(driver);
    }

    public CartPage addProductWithButton() {
        Waits.clickable(driver, addButton).click();
        return new CartPage(driver);
    }

    public String validationMessage() {
        return Waits.visible(driver, validationMessage).getText();
    }

    public String selectedProductName() {
        return Waits.visible(driver, selectedProductName).getText();
    }

    public BigDecimal selectedProductPrice() {
        String rawPrice = Waits.visible(driver, selectedProductPrice).getText().replace("$", "").replace(",", "").trim();
        return new BigDecimal(rawPrice);
    }

    public String selectedProductImageSource() {
        return Waits.visible(driver, selectedProductImage).getAttribute("src");
    }
}
