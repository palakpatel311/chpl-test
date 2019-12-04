@Regression
Feature: Verify chpl-file-controller endpoints return correct status code

Scenario Outline: Verify chpl-file-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/files/api_documentation            |200        |
      |/files/api_documentation/details    |200        |

