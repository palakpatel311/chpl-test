@Regression
Feature: OCD-2006 - Upload fake listings regularly to test upload/confirm workflow is functional

Scenario Outline: Upload sample listings for 2014 and 2015 editions
	Given I am on CHPL admin page	
	And I fill in username
	And I fill in Password
	And I click Log in button 
	And I am on Upload Certified Products page
	When I upload a "<Edition>" listing
	Then I see upload successful message
	When I go to Confirm Pending Products Page
	And I confirm "<Edition>" listing with CHPL ID "<testChplId>"
	Then I see that listing was uploaded successfully to CHPL and listing details load as expected for uploaded 20 "<ed>" listing
Examples:
    |Edition|testChplId|ed|
    |2014|14.05.05.1447.SL14.v1.00.1.180707|14|
    |2015|15.05.05.1447.SLI1.v1.00.1.180707|15|	
	
	