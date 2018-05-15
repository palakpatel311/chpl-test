@Regression
Feature: OCD-2002 - Verify fix for SED Testing End Date not showing up on the UI

Scenario: Verify SED End Date of Testing field displays value on UI
    Given I am on CHPL admin page	
	And I fill in username
	And I fill in Password
	And I click Log in button
	And I navigate to Manage Developers and Products page listing details section of listing with ID "8511"    
	Then SED End Date of Testing field should display the date "Jul 31, 2016"