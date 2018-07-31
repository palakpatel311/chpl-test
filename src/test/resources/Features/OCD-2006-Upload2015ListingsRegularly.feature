@Regression
Feature: OCD-2006 - Upload fake 2015 listing regularly to test upload/confirm workflow is functional

Scenario: Upload sample listing for 2015 edition
	Given I am on CHPL admin page	
	And I fill in username
	And I fill in Password
	And I click Log in button 
	And I am on Upload Certified Products page
	When I upload a "2015" listing
	Then I see upload successful message
	When I go to Confirm Pending Products Page
	And I confirm "2015" listing with CHPL ID "15.05.05.1447.SLI1.v1.00.1.180707"
	Then I see that listing was uploaded successfully to CHPL and listing details load as expected for uploaded "2015" listing
