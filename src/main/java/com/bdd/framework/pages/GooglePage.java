package com.bdd.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage {
	private final WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    static final private By bySearchField = By.name("q");
    
	public GooglePage searchForResults(String searchCriteria) {
		driver.findElement(bySearchField).click();
		driver.findElement(bySearchField).sendKeys(searchCriteria);
		return new GooglePage(driver);
	}
}
