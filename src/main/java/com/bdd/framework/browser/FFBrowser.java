package com.bdd.framework.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FFBrowser {
    private FFBrowser() {
        throw new IllegalStateException("FFBrowser is utility class and should not be instantiated!");
    }

    public static FirefoxDriver createDriver() {
        WebDriverManager.getInstance(FirefoxDriver.class).setup();
        return new FirefoxDriver();
    }
}
