@Regression
Feature: Verify link updates on various pages on CHPL
		OCD-2341 - Verify CMS FAQ link update on Inactive Certificates and Decertified Products pages
		
Scenario Outline: Verify CMS FAQ link is updated on collections pages
		Given I am on "<PageTitle>" collections page: "<PageName>"
		Then the CMS FAQ link should point to updated link: "<Link>"
Examples:
	|  PageTitle		       				|  PageName	| 		Link	|	
	|  Decertified Products					|  products	|https://www.cms.gov/Regulations-and-Guidance/Legislation/EHRIncentivePrograms/FAQ.html|
	|  Inactive Certificates				|  inactive	|https://www.cms.gov/Regulations-and-Guidance/Legislation/EHRIncentivePrograms/FAQ.html|		
	