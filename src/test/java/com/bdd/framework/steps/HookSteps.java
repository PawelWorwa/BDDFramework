package com.bdd.framework.steps;

import com.bdd.framework.driver.DriverFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class HookSteps {
    private static final Logger LOGGER = LogManager.getLogger(HookSteps.class);

    @Before
    public void resetDriver() throws IOException {
        DriverFactory.resetDriver();
    }

    @Before
    public void logScenarioName(Scenario scenario) {
        LOGGER.info("Scenario name: " + scenario.getName());
        LOGGER.info("Cucumber tags: " + scenario.getSourceTagNames());
    }

    @After
    public void handleErrors(Scenario scenario) {
        if (scenario.isFailed() && DriverFactory.isDriverInitialised()) {
            LOGGER.error("Scenario failed: " + scenario.getName());
            scenario.embed(((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
        }

       DriverFactory.close();
    }
}
