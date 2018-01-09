package com.bdd.framework.driver;

import com.bdd.framework.browser.BrowserType;
import com.bdd.framework.browser.ChromeBrowser;
import com.bdd.framework.browser.FFBrowser;
import com.bdd.framework.browser.IEBrowser;
import com.bdd.framework.exceptions.UnsupportedBrowserException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocalDriver {
    private LocalDriver() {
        throw new IllegalStateException("LocalDriver is utility class and should not be instantiated!");
    }

    private static final Logger LOGGER = LogManager.getLogger(LocalDriver.class);

    public static WebDriver setup() {
        WebDriver driver = setDriver();

        driver.manage().timeouts().implicitlyWait(DriverConfiguration.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        return driver;
    }

    private static WebDriver setDriver() {
        if(DriverConfiguration.BROWSER.equals(BrowserType.CHROME.name())) {
            return ChromeBrowser.createDriver();

        } else if(DriverConfiguration.BROWSER.equals(BrowserType.INTERNET_EXPLORER.name())) {
            return IEBrowser.createDriver();

        } else if(DriverConfiguration.BROWSER.equals(BrowserType.FIREFOX.name())) {
            return FFBrowser.createDriver();

        } else {
            String eMessage = "Unsupported browser: " + DriverConfiguration.BROWSER;
            LOGGER.error(eMessage);
            throw new UnsupportedBrowserException(eMessage);
        }
    }
}
