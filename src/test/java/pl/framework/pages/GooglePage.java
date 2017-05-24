package pl.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage {
	private final WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }
    
    static final private By byErrorField = By.name("qe");
    static final private By bySearchField = By.name("q");
    static final private By byText = By.xpath("//a[contains(text(), 'Soflab Technology Profesjonalne Testy')]");
    
	public GooglePage searchForResults(String searchCriteria) {
		driver.findElement(bySearchField).click();
		driver.findElement(bySearchField).sendKeys(searchCriteria);
		return new GooglePage(driver);
	}
	
	public GooglePage searchForErrorResults() {
		driver.findElement(byErrorField).click();
		return new GooglePage(driver);
	}
	
	public boolean isTextExisting() {
		return driver.findElement(byText).isDisplayed();
	}
}
