package pl.framework.driver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pl.framework.config.BrowserType;
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
	
	public static void close() {
		if(driver  != null) {
			System.out.println("Shutting down driver...");
			driver.quit();
		}
	}
	
	public static void processCleanup() {
		BrowserType browser = DriverConfiguration.browser;
		switch (browser) {
			case Firefox:				
				break;
				
			case InternetExplorer:
				try {
					Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
					
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
				break;
				
			default:
				break;
		}
	}
}
