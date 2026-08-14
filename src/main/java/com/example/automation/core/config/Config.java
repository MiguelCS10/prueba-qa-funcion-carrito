package com.example.automation.core.config;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public final class Config {
    private static final String CONFIG_FILE = "config.properties";
    private static final Properties PROPERTIES = loadProperties();

    private Config() {
    }

    public static String browser() {
        return get("browser", "chrome").trim().toLowerCase();
    }

    public static boolean headless() {
        return Boolean.parseBoolean(get("headless", "true"));
    }

    public static String baseUrl() {
        return get("baseUrl", "http://localhost:8080");
    }

    public static String apiBaseUrl() {
        return get("apiBaseUrl", "http://localhost:8080");
    }

    public static Duration explicitWaitTimeout() {
        return Duration.ofSeconds(Long.parseLong(get("explicitWaitSeconds", "10")));
    }

    private static String get(String key, String defaultValue) {
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }
        return PROPERTIES.getProperty(key, defaultValue);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(CONFIG_FILE)) {
            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load " + CONFIG_FILE, exception);
        }
        return properties;
    }
}
