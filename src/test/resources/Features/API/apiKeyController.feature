@Regression
Feature: Verify api-key-controller endpoints return correct status code

Scenario Outline: Verify api-key-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/key                                |401        |
      |/key/activity                       |401        |

