# BDD Simple Selenium Framework
## Basic information
It's a simple test framework created for Selenium with BDD library: Cucumber. It uses **page object** approach separating steps from their physical implementation.

Framework can be used both: to run tests locally or with Selenium Grid (which I'll add eventually).

## Maven dependencies
Project is using java **1.8** by default. It can be changed (along with versions for other dependencies) by assigning required values for parameters inside **pom.xml** file within **properties** section.

## Run parameters
Test run can be controlled by passing parameters from command line.  

Parameters required for test execution:
* threads: (Optional) Number of threads(forks) on which test will be run in parallel. Default value is '**0**' (treated as 1);
* browser: (Optional) Browser on which tests will be executed. Default value is '**CHROME**'. Possible values:
   * CHROME;
   * FIREFOX;
   * INTERNET_EXPLORER.
* useGrid: (Optional) Should Selenium Grid be used for test execution. Default value is '**false**'. (**Important**: Currently test can't be executed using Selenium Grid - this functionality is not included.)

## Used plugins
Despite using "common" plugins, framework benefits mostly from three of them:
* Cucumber Reporting (https://github.com/damianszczepanik/cucumber-reporting);
* Automatic Selenium WebDriver binaries management in runtime for Java (https://github.com/bonigarcia/webdrivermanager);
* Plugin for assisting with running Cucumber-JVM features in parallel (https://github.com/temyers/cucumber-jvm-parallel-plugin).

## Error handling
If during test execution an error occurs (whatever the reason), framework will take screenshots from current browser and include it within Cucumber Report.

## A few words at the end...
This "framework" is not a complete solution. It's more like inspiration or place to start. 

I hope You will find it useful.