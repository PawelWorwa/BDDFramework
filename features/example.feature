Feature: Egzample test case included inside Feature file.

Scenario: Example BDD test scenario - negative path
	Given I've run "https://google.pl" page in browser
	 When I've provided wrong search criteria
	 Then Negative output will be displayed


Scenario: Example BDD test scenario
	Given I've run "https://google.pl" page in browser
	 When I search for word "EasyAutomation.pl"
	 Then Positive output will be displayed