@Regression
Feature: Verify change-request-controller endpoints return correct status code

Scenario Outline: Verify change-request-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/change-requests                    |401        |

