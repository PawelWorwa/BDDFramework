package pl.framework.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import pl.framework.config.BrowserType;
import pl.framework.config.BrowserVersion;
import pl.framework.config.DriverConfiguration;

public class LocalDriver {
	private WebDriver driver;
	
	public WebDriver setDriver() {
		setBrowser();

		driver.manage().timeouts().implicitlyWait(DriverConfiguration.timeout, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
	}

	private void setBrowser() {
		BrowserType browser = DriverConfiguration.browser;

		switch (browser) {
		case Firefox:
			setFirefoxDriver();
			break;

		default:
			setFirefoxDriver();
			break;
		}
	}

	private void setFirefoxDriver() {
		float version = BrowserVersion.Firefox_53_0.toFloat();
		boolean isMarionette = (version >= 47.0f) ? true : false;
		if (isMarionette) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		}

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", isMarionette);
		driver = new FirefoxDriver(capabilities);
	}
}
