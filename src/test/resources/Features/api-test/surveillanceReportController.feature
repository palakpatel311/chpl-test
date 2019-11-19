@Regression
Feature: Verify surveillance-report-controller endpoints return correct status code

Scenario Outline: Verify surveillance-report-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/surveillance-report/annual         |401        |
      |/surveillance-report/quarterly      |401        |

