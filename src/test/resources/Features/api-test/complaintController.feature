@Regression
Feature: Verify complaint-controller endpoints return correct status code

Scenario Outline: Verify complaint-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/complaints                         |401        |

