@Regression
Feature: Verify certification-id-controller endpoints return correct status code

Scenario Outline: Verify certification-id-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/certification_ids                  |401        |
      |/certification_ids/search           |200        |

