@Regression
Feature: Verify scheduler-controller endpoints return correct status code

Scenario Outline: Verify scheduler-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/schedules/jobs                     |401        |
      |/schedules/triggers                 |401        |

