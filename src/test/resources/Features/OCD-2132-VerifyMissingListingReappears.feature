Feature: OCD-2134 - Load listing details to verify missing listing reappears

@Acceptance
Scenario Outline: Verify that missing listing reappears and listing details load successfully
	Given I am on listing details page of listing with database ID "<DB_ID>"
	Then the listing name shows as "Dentrix Enterprise"	
	When I look at SED details	
	Then the Mandatory Disclosures URL should be: "http://www.dentrixenterprise.com/solutions/public-health/meaningful-use"
Examples:	
	|DB_ID|
	|5893|
	|5896|
	
Scenario Outline: Verify that missing listing reappears and is only listing shown in search results
	Given I am on CHPL search page
	When I search for a missing listing with CHPL ID "<CHPL_ID>"
	And I select all status on Certification Status filter		
	Then the only listing with CHPL ID "<CHPL_ID>" appears in search results
Examples:
	|CHPL_ID|
	|CHP-021691|
	|CHP-021692|