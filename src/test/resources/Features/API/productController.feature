@Regression
Feature: Verify product-controller endpoints return correct status code

Scenario Outline: Verify product-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/products                           |200        |

