@Regression
Feature: Change Requests
  This test checks whether change requests functionality work as expected

Scenario: User logs in as ROLE_ADMIN and performs change request actions
    Given I'm logged in as "ROLE_ADMIN"
    When I'm on User Management page
    And I impersonate Role Developer
    Then I see "My Dashboard" as the title for developer dashboard
    And I edit the developer information
    And I edit the developer website field to "http://createchangerequest.com"
    And I save the developer edit information
    When I click the request status with "Pending ONC-ACB Action" in the tracking section
    Then I see "Submitted website: http://createchangerequest.com" in the details section
    When I "Edit Change Request"
    Then I see the form title as "Editing - Change Request"
    And I edit the Submitted website field to "http://editchangerequest.com" 
    And I save the edited change request
    And I click the request status with "Pending ONC-ACB Action" in the tracking section
    When I check the status log
    Then I see the form title as "Status Log - Change Request"
    When I go back to the change request
    Then I see the "Tracking" section
    And I click the request status with "Pending ONC-ACB Action" in the tracking section
    When I "Withdraw Change Request"
    Then I see the form title as "Withdraw - Change Request"
    And I see the change status message as "You're withdrawing this change request"
    And I enter reason for change as "TEST"
    And I click withdraw change request
    Then I see "The submission has been completed successfully. It will be reviewed by an ONC-ACB or ONC. Once the submission has been approved, it will be displayed on the CHPL" message

