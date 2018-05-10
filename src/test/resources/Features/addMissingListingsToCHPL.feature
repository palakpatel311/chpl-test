Feature: Add missing listings to the CHPL
	OCD-2244 - Two Listings from InfoGard had been uploaded to the Legacy CHPL after we got the last download from Deloitte,
	and so those Listings were not uploaded to the new CHPL. Tests below are to test listings were added to the new CHPL.
	OCD-2132 - Load listing details to verify missing listing reappears - Tests below are to verify bugfix in database view that caused a listing to 
	disappear from the CHPL. 
Scenario Outline: Searching for missing listing on the CHPL Search shows listing in search results
	Given I am on CHPL search page
	When I search for a missing listing with CHPL ID "<CHPL_ID>"
	And I select all status on Certification Status filter		
	Then the only listing with CHPL ID "<CHPL_ID>" appears in search results
Examples:
	|CHPL_ID|
	|CHP-029232|
	|CHP-029233|
	|CHP-021691|
	|CHP-021692|

Scenario Outline: Listing details load successfully for added listings
	Given I am on listing details page of listing with CHPL ID "<CHPL_ID>"
	Then the listing name shows as "<Listing_Name>"		
Examples:	
	|CHPL_ID|Listing_Name|
	|CHP-029232|ImageInbox®|
	|CHP-029233|ImageInbox®|
	|CHP-021691|Dentrix Enterprise|
	|CHP-021692|Dentrix Enterprise|
