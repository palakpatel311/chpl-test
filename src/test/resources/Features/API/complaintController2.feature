@RegressionAPI
Feature: Complaint-controller endpoints
  Verify CRUD operations on Complaint-controller endpoints

Scenario Outline: Verify status codes based on user's authorization
Given I set base URL 
When I set Headers with API key and <Authorization>
And I send GET request to complaints resource "rest/complaints"
Then I verify the <Status Code>
    Examples: 
      | Authorization | Status Code |
      | Invalid       |         401 |
      | Valid         |         200 |
