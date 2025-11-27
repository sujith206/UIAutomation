package com.Ui.webAutomation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    // Initialize driver for the current thread
    public static void initDriver() {
        if (driverPool.get() == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            // allow headless via system property: -Dheadless=true
            String headless = System.getProperty("headless", "false");
            if (headless.equalsIgnoreCase("true")) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }
            // common options
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            WebDriver driver = new ChromeDriver(options);
            driverPool.set(driver);
        }
    }

    public static WebDriver getDriver() {
        return driverPool.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverPool.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {
            }
            driverPool.remove();
        }
    }
}

