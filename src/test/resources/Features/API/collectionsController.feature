@Regression
Feature: Verify collections-controller endpoints return correct status code

Scenario Outline: Verify collections-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/collections/certified_products     |200        |
      |/collections/decertified-developers |200        |

