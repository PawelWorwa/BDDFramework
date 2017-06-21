package pl.framework.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import pl.framework.driver.DriverFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features"
		,glue={"pl.framework.steps"}
		,strict = true
		,plugin = { "pretty",
		        "html:target/site/cucumber-pretty",
		        "json:target/cucumber.json" }
		) 
public class RunnerTest {
	@AfterClass
	public static void cleanup() {
		DriverFactory.processCleanup();
		DriverFactory.close();
	}
}