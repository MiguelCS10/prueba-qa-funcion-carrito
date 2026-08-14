package com.example.automation.core.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private WebDriver driver;

    public WebDriver startDriver() {
        if (driver == null) {
            driver = DriverFactory.createDriver();
        }
        return driver;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver has not been started.");
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
