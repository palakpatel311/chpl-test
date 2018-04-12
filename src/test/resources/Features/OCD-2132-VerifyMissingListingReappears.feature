Feature: OCD-2134 - Load listing details to verify missing listing reappears

@Acceptance
Scenario: Verify that missing listing reappears and listing details load successfully
	Given I am on listing details page of listing with database ID "5893"
	Then the listing name shows as "Dentrix Enterprise"	
	When I look at SED details
	Then there should be text "No Certification Criteria were tested for SED"
	Then the Mandatory Disclosures URL should be: "http://www.dentrixenterprise.com/solutions/public-health/meaningful-use"
		  