# Deprecated - needs to be updated
# BDD Selenium Simple Framework
## Basic information
It's a simple framework created Selenium including BDD library: Cucumber. It uses **page object** approach separating steps from their physical implementation.

Framework can be used both locally or with Selenium Grid.

## Maven Configuration
Project is configured so it used java 1.8 by default. It can be changed (along with versions for other dependencies) by assigning desired values for parameters inside **pom.xml** file within **properties** section:

```
<properties>
   <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
   <maven.compiler.source>1.8</maven.compiler.source>
   <maven.compiler.target>1.8</maven.compiler.target>

   <junit.version>4.12</junit.version>
   <cucumber.version>1.2.5</cucumber.version>
   <selenium.version>3.4.0</selenium.version>
</properties>
```

## Project Configuration
Personally I don't like java properties files - it'e easy to make mistake providing wrong value. Having that in mind, all configuration is based either on Enums (type selections) or raw values (like paths or timeout). All configuration is made inside **DriverConfiguration** class, and it goes as follows:

Browser that should be used for tests run. It takes values from **BrowserType** Enum. 
> public static final BrowserType    browser = BrowserType.Firefox;

Browser version that should be used for tests run. It takes values from **BrowserVersion** Enum.
Parameters is used only for Selenium Grid execution. For local usage it can be omitted (by **ANY** value).
> public static final BrowserVersion version = BrowserVersion.ANY;

Maximum wait time for objects.
> public static final int            timeout = 5; // Seconds

Parameter for Selenium Grid usage. By taking **false** value, it means local usage.
> public static final boolean		   isGrid  = false;

Parameter for Selenium Grid usage - Hub url path. 
> public static final String         hubUrl  = "http://127.0.0.1:4444/wd/hub";


## Test runner
Test's can be executed either using maven test goal or manually, by running **RunnerTest** class. Framework has default cucumber configuration which can be changed depending on will.
Default configuration is sas below:
```
@CucumberOptions(
		features = "features"
		,glue={"pl.framework.steps"}
		,strict = true
		,plugin = { "pretty",
		        "html:target/site/cucumber-pretty",
		        "json:target/cucumber.json" }
		) 
```		

## Cucumber Features
By default, all feature files are included inside **features** folder.

## External drivers
By default, all drivers are included within project inside **drivers** folder. It allows to omit full drivers paths and limiting them just to name.

## Error handling
If during test execution an error occurs (whatever the reason), framework will take screenshot from current browser and include it within Cucumber Report.

## A few words at the end...
This framework is not a complete solution as it's comes with *build in* support for firefox browser only. For using other browser *One* must add desired drivers, browser enums and create required driver setup methods within **GridDriver** and **LocalDriver** classes.

I hope You will find this framework useful.