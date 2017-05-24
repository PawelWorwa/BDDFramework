package pl.framework.driver;

import org.openqa.selenium.WebDriver;

import pl.framework.config.DriverConfiguration;

public class DriverFactory {
	private static WebDriver driver = null;

	public static WebDriver getDriver() {
		if (driver == null) {
			if (DriverConfiguration.isGrid) {
				GridDriver grid = new GridDriver();
				driver = grid.setDriver();
				
			} else {
				LocalDriver plain = new LocalDriver();
				driver = plain.setDriver();
			}
		}
		return driver;
	}

	public static void resetDriver() {
		driver.quit();
		driver = null;
	}
}
