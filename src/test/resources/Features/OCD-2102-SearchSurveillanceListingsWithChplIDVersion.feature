@Regression
Feature: OCD-2102 - Allow surveillance search for listings with CHPL ID version

Scenario Outline: Verify surveillance search for a listing with CHPL ID version loads search results
	Given I am on CHPL admin page	
	And I fill in username
	And I fill in Password
	And I click Log in button
	And I navigate to Manage Surveillnace Activity section
	When I search for "<CHPL_ID>" in Manage Surveillance Activity section
	Then I see the surveillance results for "<CHPL_ID>"
Examples:
	|CHPL_ID|
	|15.04.04.2484.Updo.16.00.0.170720|
	|15.04.04.2913.Gree.11.01.1.171101|
