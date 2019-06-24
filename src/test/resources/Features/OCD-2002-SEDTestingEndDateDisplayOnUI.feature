@Regression
Feature: OCD-2002 - Verify fix for SED Testing End Date not showing up on the UI

Scenario: Verify SED End Date of Testing field displays value on UI on Manage Developers and Products page
    Given I'm logged in as "ROLE_ACB"
	When I am on listing details page of listing with ID "8511"
    And I click on edit certified product link	
	Then SED End Date of Testing field should display the date "Aug 24, 2016" in listing details section
	
Scenario: Verify SED End Date of Testing field displays value on UI on listing deatils page
    Given I am on listing details page of listing with ID "8511"
    When I look at SED details
    Then SED Testing End Date shows as "Aug 24, 2016" in SED details section