@Regression
Feature: Verify surveillance-controller endpoints return correct status code

Scenario Outline: Verify surveillance-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/surveillance/pending               |401        |

