Feature: This feature is to test newly generated/unverifiable CMS IDs are inserted into database and available to look up using CMS ID Reverse Lookup

 Scenario Outline: As an end-user, I want to be able to lookup my listings with the old CMS IDs
	Given I am an end-user on CMS ID Reverse Lookup page
	When I look up CMS ID "<CMS_ID>" in the reverse look-up tool
	Then I should see the listings "<CHPL_ID>" that make up the CMS ID 
	Examples:
      |CMS_ID			|CHPL_ID|
      |0015H8GK6K0ZZB2|14.07.07.2452.VEI1.01.01.0.161111|
      |0015H8GK6K0ZZB2|15.04.04.2891.Sunr.07.01.1.171201|
      			
Scenario Outline: If a user loads their cms widget with any of these sets of listings, and generates a CMS ID then it should return the newer CMS ID
	Given I am an end user on CHPL home page
	When I Generate CMS ID using CMS ID widget for same listings "<CHPL_ID1>" and "<CHPL_ID2>" as in result of reverse lookup
	Then the generated CMS ID should be "<CMS_ID>"
	Examples:
	|CHPL_ID1|CHPL_ID2|CMS_ID|
	|14.07.07.2452.VEI1.01.01.0.161111|15.04.04.2891.Sunr.07.01.1.171201|0015H8GK6K0ZZB2|
            