package com.bdd.framework.driver;

import com.bdd.framework.browser.BrowserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DriverFactory {
    private DriverFactory() {
        throw new IllegalStateException("DriverFactory is utility class and should not be instantiated!");
    }

    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);

    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        boolean seleniumGrid = Boolean.parseBoolean(
                System.getProperty("maven.use.selenium.grid"));

        if (driver == null) {
            if (seleniumGrid) {
                String eMessage = "Selenium grid is not supported at this moment.";
                LOGGER.error(eMessage);
                throw new IllegalStateException(eMessage);

            } else {
                driver = LocalDriver.setup();
                LOGGER.info("Started driver: " + DriverConfiguration.BROWSER);
            }
        }

        return driver;
    }

    public static void resetDriver() throws IOException {
        if (isDriverInitialised()) {
            driver.quit();
            driver = null;
            processCleanup();
        }
    }

    public static boolean isDriverInitialised() {
        return driver != null;
    }

    public static void close() {
        if (isDriverInitialised()) {
            LOGGER.info("Shutting down driver: " + DriverConfiguration.BROWSER);
            driver.quit();
        }
    }

    public static void processCleanup() throws IOException {
        BrowserType browser = BrowserType.valueOf(DriverConfiguration.BROWSER);

        if (browser == BrowserType.INTERNET_EXPLORER) {
            killProcess("taskkill /F /IM IEDriverServer.exe");

        } else if (browser == BrowserType.CHROME) {
            killProcess("taskkill /F /IM chromedriver.exe");

        } else if (browser == BrowserType.FIREFOX) {
            killProcess("taskkill /F /IM geckodriver.exe");
        }
    }

    private static void killProcess(String command) throws IOException {
        Runtime.getRuntime().exec(command);
    }
}
