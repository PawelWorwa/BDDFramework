package pl.framework.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pl.framework.driver.DriverFactory;
import pl.framework.exceptions.ExceptionHandler;
import pl.framework.pages.GooglePage;

public class GoogleSteps {
	@After
	public void handleErrors(Scenario scenario) {
		ExceptionHandler.takeScreenshotOnError(scenario);
	}
	
	@When("^I search for word \"([^\"]*)\"$")
	public void wyszukam_w_wyszukiwarce_haslo(String searchCriteria) {
		WebDriver driver = DriverFactory.getDriver();
		GooglePage page = new GooglePage(driver);
		page.searchForResults(searchCriteria);
	}

	@When("^I've provided wrong search criteria$")
	public void wyszukam_w_wyszukiwarce_haslo() {
		WebDriver driver = DriverFactory.getDriver();
		GooglePage page = new GooglePage(driver);
		page.searchForErrorResults();
	}

	@Then("^Positive output will be displayed$")
	public void widoczne_beda_wyniki() {
		boolean isValid = true;
		Assert.assertEquals(isValid, true);
	}

	@Then("^Negative output will be displayed$")
	public void widoczne_beda_wyniki_negatywne() {
		Assert.fail();
	}
}
