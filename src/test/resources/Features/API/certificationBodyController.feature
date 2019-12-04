@Regression
Feature: Verify certification-body-controller endpoints return correct status code

Scenario Outline: Verify certification-body-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/acbs                               |200        |

