@Regression
Feature: OCD-2797 - Verify surveillance upload/confirm workflow is functional

  Scenario: Upload and confirm surveillance activity
    Given I'm logged in as "ROLE_ACB"
    And I am on Upload Products & Surveillance page
    When I upload a surveillance activity for listing with CHPL ID "15.05.05.2760.ISCD.01.00.1.181101"
    Then I see upload successful message for surveillance upload
    When I go to Confirm Pending Surveillance Activities Page
    And I inspect surveillance activity details for listing with CHPL ID "15.05.05.2760.ISCD.01.00.1.181101"
    And I confirm surveillance activity for listing with CHPL ID "15.05.05.2760.ISCD.01.00.1.181101"
    Then I see that surveillance was uploaded successfully to CHPL and listing details show surveillance activity
    