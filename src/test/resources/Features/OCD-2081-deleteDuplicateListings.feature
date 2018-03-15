@Regression
Feature: OCD-2081 - To verify duplicate listings are deleted
 		Tests to verify 3 duplicate drummond listings are deleted

Scenario Outline: Verify deleted listings do not show in search results
Given I am on CHPL search page 
When I search for a listing with CHPL ID "<CHPL_ID>"
Then the search page shows 'No results found' message
Examples:
	|CHPL_ID|
	|15.04.04.2931.MEDI.IR.00.1.171220|
	|15.04.04.2931.MEDI.MP.00.1.171220|
	|14.04.04.1221.Cern.05.05.0.180214|

Scenario Outline: Verify listing details do not load for deleted listings
Given I am on listing details page of listing with database ID "<DB_ID>"
Then the page shows "This listing does not exist" message
Examples:
	|DB_ID|
	|9102|
	|9241|
	|9252|