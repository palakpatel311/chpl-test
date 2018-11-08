@Regression
Feature: OCD-2534 Replace ONC_CHPL@hhs.gov email address with Health IT Feedback Form Website
This test checks whether ONC_CHPL@hhs.gov email addresss is replaced with Health IT Feedback From Website
				
Scenario: Verify in CHPL Charts Page
	Given I am on CHPL Charts page
	Then Verify the text of Health IT Feedback Form

Scenario: Verify in Contact us link
	Given I am on CHPL search page
	When I click CHPL Resources Top Navigation Link
	Then I see Contact us link points to Health IT Feedback Form