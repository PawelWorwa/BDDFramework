package com.bdd.framework.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser {
    private IEBrowser() {
        throw new IllegalStateException("IEBrowser is utility class and should not be instantiated!");
    }

    public static InternetExplorerDriver createDriver() {
        WebDriverManager.getInstance(InternetExplorerDriver.class).setup();
        return new InternetExplorerDriver();
    }
}
