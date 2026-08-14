package com.example.automation.pages;

import com.example.automation.core.wait.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public final class OrderConfirmationPage {
    private final WebDriver driver;

    /*
     * MOCK/TODO/PLACEHOLDER selectors.
     * Replace with stable IDs or data-testid attributes when the real DOM exists.
     */
    private final By orderId = By.cssSelector("[data-testid='TODO-order-id']");
    private final By orderStatus = By.cssSelector("[data-testid='TODO-order-status']");
    private final By orderTotal = By.cssSelector("[data-testid='TODO-order-total']");
    private final By duplicateConfirmationMessage = By.cssSelector("[data-testid='TODO-duplicate-order-message']");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String orderId() {
        return Waits.visible(driver, orderId).getText();
    }

    public String status() {
        return Waits.visible(driver, orderStatus).getText();
    }

    public BigDecimal total() {
        String rawTotal = Waits.visible(driver, orderTotal).getText().replace("$", "").replace(",", "").trim();
        return new BigDecimal(rawTotal);
    }

    public String duplicateConfirmationMessage() {
        return Waits.visible(driver, duplicateConfirmationMessage).getText();
    }
}
