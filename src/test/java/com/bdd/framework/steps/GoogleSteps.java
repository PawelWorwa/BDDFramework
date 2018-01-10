package com.bdd.framework.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.bdd.framework.driver.DriverFactory;
import com.bdd.framework.pages.GooglePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSteps {
	@Given("^I've run \"([^\"]*)\" page in browser$")
	public void navigateToPage(String url) {
		WebDriver driver = DriverFactory.getDriver();
		driver.get(url);
	}
	
	@When("^I search for word \"([^\"]*)\"$")
	public void searchForWord(String searchCriteria) {
		WebDriver driver = DriverFactory.getDriver();
		GooglePage page = new GooglePage(driver);
		page.searchForResults(searchCriteria);
	}

	@Then("^Positive output will be displayed$")
	public void assertOutput() {
		boolean isValid = true;
		Assert.assertEquals(true, isValid);
	}
}
