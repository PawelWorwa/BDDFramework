package pl.framework.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import pl.framework.config.BrowserType;
import pl.framework.config.BrowserVersion;
import pl.framework.config.DriverConfiguration;

public class GridDriver {
	private WebDriver driver;

	public WebDriver setDriver() {
		BrowserType browser = DriverConfiguration.browser;

		switch (browser) {
		case Firefox:
			setFFDriver();
			break;

		default:
			setFFDriver();
			break;
		}
		
		return driver;
	}

	private void setFFDriver() {
		float version = DriverConfiguration.version.toFloat();
		BrowserType browser = DriverConfiguration.browser;
		boolean isMarionette = (version >= 47.0f) ? true : false;
		
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName(browser.toString());
		capability.setCapability("marionette", isMarionette);

		if (DriverConfiguration.version != BrowserVersion.ANY) {
			//capability.setVersion(Float.toString(version));
		}
		
		addCapability(capability);
	}

	private void addCapability(DesiredCapabilities capability) {
		String hubUrl = DriverConfiguration.hubUrl;
		
		try {
			driver = new RemoteWebDriver(new URL(hubUrl), capability);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}