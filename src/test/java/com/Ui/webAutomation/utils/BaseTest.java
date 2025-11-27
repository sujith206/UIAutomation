package com.Ui.webAutomation.utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverFactory.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}

