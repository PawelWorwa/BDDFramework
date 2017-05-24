package pl.framework.steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pl.framework.driver.DriverFactory;
import pl.framework.exceptions.ExceptionHandler;

public class BrowserSteps {	
	@After
	public void handleErrors(Scenario scenario) {
		ExceptionHandler.takeScreenshotOnError(scenario);
	}
	
	@Given("^I've run \"([^\"]*)\" page in browser$")
	public void uruchomilem_w_przegladarce_strone(String url) {
		WebDriver driver = DriverFactory.getDriver();
		driver.get(url);
	}

	@Then("^I close browser$")
	public void zamkne_przegladarke()  {
		WebDriver driver = DriverFactory.getDriver();
		driver.quit();
	}
}
