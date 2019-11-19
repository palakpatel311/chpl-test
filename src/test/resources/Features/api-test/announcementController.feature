@Regression
Feature: Verify announcement-controller endpoints return correct status code

Scenario Outline: Verify announcement-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/announcements                      |200        |