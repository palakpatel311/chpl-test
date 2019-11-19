@Regression
Feature: Verify certified-product-controller endpoints return correct status code

Scenario Outline: Verify certified-product-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/certified_products/pending/metadata|401        |
      |/certified_products/sed_details     |200        |

