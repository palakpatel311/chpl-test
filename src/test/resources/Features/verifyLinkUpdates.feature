@Regression
Feature: Verify link updates on various pages on CHPL
		OCD-2341 - Verify CMS FAQ link update on Inactive Certificates and Decertified Products pages
		
Scenario Outline: Verify CMS FAQ link is updated on collections pages
		Given I am on collections page: "<PageName>" on "DEV"
		Then the CMS FAQ link should point to updated link: "<Link>"
Examples:
	|  PageName	|  Link |
	|  products	|https://www.cms.gov/Regulations-and-Guidance/Legislation/EHRIncentivePrograms/FAQ.html|
	|  inactive	|https://www.cms.gov/Regulations-and-Guidance/Legislation/EHRIncentivePrograms/FAQ.html|
