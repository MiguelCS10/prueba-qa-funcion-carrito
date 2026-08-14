package com.example.automation.pages;

import com.example.automation.core.wait.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public final class CartPage {
    private final WebDriver driver;

    /*
     * MOCK/TODO/PLACEHOLDER selectors.
     * Replace with stable IDs or data-testid attributes when the real DOM exists.
     */
    private final By cartRows = By.cssSelector("[data-testid='TODO-cart-row']");
    private final By productName = By.cssSelector("[data-testid='TODO-cart-product-name']");
    private final By productQuantity = By.cssSelector("[data-testid='TODO-cart-product-quantity']");
    private final By total = By.cssSelector("[data-testid='TODO-cart-total']");
    private final By confirmOrderButton = By.cssSelector("[data-testid='TODO-confirm-order-button']");
    private final By validationMessage = By.cssSelector("[data-testid='TODO-cart-validation-message']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String firstProductName() {
        return Waits.visible(driver, productName).getText();
    }

    public int firstProductQuantity() {
        return Integer.parseInt(Waits.visible(driver, productQuantity).getText());
    }

    public int rowCount() {
        return Waits.until(driver, webDriver -> webDriver.findElements(cartRows).size());
    }

    public BigDecimal displayedTotal() {
        String rawTotal = Waits.visible(driver, total).getText().replace("$", "").replace(",", "").trim();
        return new BigDecimal(rawTotal);
    }

    public CartPage updateQuantity(int productId, String quantity) {
        WebElement input = Waits.visible(driver, quantityInputFor(productId));
        input.clear();
        input.sendKeys(quantity);
        return this;
    }

    public CartPage updateQuantityWithEnter(int productId, String quantity) {
        updateQuantity(productId, quantity);
        Waits.visible(driver, quantityInputFor(productId)).sendKeys(Keys.ENTER);
        return this;
    }

    public CartPage decreaseProduct(int productId) {
        Waits.clickable(driver, decreaseButtonFor(productId)).click();
        return this;
    }

    public CartPage removeProduct(int productId) {
        Waits.clickable(driver, removeButtonFor(productId)).click();
        return this;
    }

    public OrderConfirmationPage confirmOrder() {
        Waits.clickable(driver, confirmOrderButton).click();
        return new OrderConfirmationPage(driver);
    }

    public String validationMessage() {
        return Waits.visible(driver, validationMessage).getText();
    }

    private By quantityInputFor(int productId) {
        return By.cssSelector("[data-testid='TODO-cart-quantity-input-" + productId + "']");
    }

    private By removeButtonFor(int productId) {
        return By.cssSelector("[data-testid='TODO-cart-remove-button-" + productId + "']");
    }

    private By decreaseButtonFor(int productId) {
        return By.cssSelector("[data-testid='TODO-cart-decrease-button-" + productId + "']");
    }
}
