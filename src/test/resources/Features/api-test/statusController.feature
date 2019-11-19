@Regression
Feature: Verify status-controller endpoints return correct status code

Scenario Outline: Verify status-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/system-status                      |200        |

