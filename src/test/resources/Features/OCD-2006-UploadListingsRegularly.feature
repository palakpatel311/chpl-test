@Regression
Feature: OCD-2006 - Upload fake listings regularly to test upload/confirm workflow is functional

Scenario: Upload sample 2014 listing
	Given I am on CHPL admin page	
	And I fill in username
	And I fill in Password
	And I click Log in button 
	And I am on Upload Certified Products page
	When I upload a 2014 listing
	Then I see upload successful message

Scenario: Upload sample 2015 listing
	Given I am on CHPL admin page	
	And I fill in username
	And I fill in Password
	And I click Log in button 
	And I am on Upload Certified Products page
	When I upload a 2015 listing
	Then I see upload successful message
	