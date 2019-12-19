@RegressionAPI
Feature: Complaint-controller endpoints
  Verify CRUD operations on Complaint-controller endpoints
 
Background: Setting base URL
    Given I set base URL

  Scenario Outline: Verify status codes based on user's authorization

    Given I set Headers with API key and <Authorization>
    When I send GET request to complaints resource "rest/complaints"
    Then I verify the <Status Code>
    Examples: 
      | Authorization | Status Code |
      | Invalid       |         401 |
      | Valid         |         200 |

  Scenario: Verify adding, updating and deleting a complaint
    Given I set Headers with API key, "ROLE_ACB" authorization 
    And I set "POST" request body
    When I send POST request to resource "rest/complaints" 
    Then I verify status code "201" 
    And I extract id from response body
    Given I set Headers with API key, "ROLE_ACB" authorization
    When I send GET request to complaints resource "rest/complaints" 
    Then I extract ids of all complaints from response body
    And I validate posted id exist in ids of all complaints
    Given I set Headers with API key, "ROLE_ACB" authorization 
    And I set "PUT" request body
    When I send PUT request to resource "rest/complaints/{complaintId}" with posted complaintId
    Then I verify status code "201" 
    And I validate response body has updated ONC complaint id
    Given I set Headers with API key, "ROLE_ACB" authorization 
    When I send DELETE request to resource "rest/complaints/{complaintId}" 
    Then I verify status code "200" 
    Given I set Headers with API key, "ROLE_ACB" authorization
    When I send GET request to complaints resource "rest/complaints"  
    Then I extract ids of all complaints from response body
    And I validate posted id doesnt exist in ids of all complaints
