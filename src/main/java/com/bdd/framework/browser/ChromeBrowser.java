package com.bdd.framework.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {
    private ChromeBrowser() {
        throw new IllegalStateException("ChromeBrowser is utility class and should not be instantiated!");
    }

    public static ChromeDriver createDriver() {
        WebDriverManager.getInstance(ChromeDriver.class).setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("disable-notifications");

        return new ChromeDriver(options);
    }
}