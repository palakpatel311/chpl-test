@listingUpload
@Regression
Feature: OCD-2006 - Verify upload/confirm workflow is functional

  Scenario: Upload sample listing for 2015 edition
    Given I'm logged in as "ROLE_ACB"
    And I am on Upload Listings page
    When I upload a "2015" listing with CHPL ID "15.05.05.1447.SLI1.v1.00.1.180707"
    Then I see upload successful message
    When I go to Confirm Pending Products Page
    And I open inspect form to inspect listing details
    And I confirm "2015" listing with CHPL ID "15.05.05.1447.SLI1.v1.00.1.180707"
    Then I see that listing was uploaded successfully to CHPL and listing details load as expected

  Scenario: Upload sample listing for 2014 edition
    Given I'm logged in as "ROLE_ACB"
    And I am on Upload Listings page
    When I upload a "2014" listing with CHPL ID "14.05.05.1447.SL14.v1.00.1.180707"
    Then I see upload successful message
    When I go to Confirm Pending Products Page
    And I open inspect form to inspect listing details
    And I confirm "2014" listing with CHPL ID "14.05.05.1447.SL14.v1.00.1.180707"
    Then I see that listing was uploaded successfully to CHPL and listing details load as expected
