Feature: Example feature file
  Set 'threads' parameters to '3' to run all tests in parallel

  Scenario Outline: Example BDD test scenario
    Given I've run "https://google.pl" page in browser
     When I search for word "<SEARCH_WORD>"
     Then Positive output will be displayed

    Examples:
    | SEARCH_WORD |
    | Selenium    |
    | BDD         |
    | Github      |