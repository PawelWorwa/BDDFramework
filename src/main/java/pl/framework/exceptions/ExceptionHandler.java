package pl.framework.exceptions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pl.framework.driver.DriverFactory;

public class ExceptionHandler {
	public static boolean isReported = false;

	public static void takeScreenshotOnError(Scenario scenario) {
		WebDriver driver = DriverFactory.getDriver();
		if (scenario.isFailed() && isReported == false) {
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
			isReported = true;
		}
	}

}