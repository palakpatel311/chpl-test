@Regression
Feature: Verify link and text updates on various pages on CHPL
		OCD-2341 - Verify CMS FAQ link update on Inactive Certificates and Decertified Products pages
		OCD-2872 - Update wording on Charts Shortcut page 
		
Scenario Outline: Verify CMS FAQ link is updated on collections pages
		Given I am on collections page: "<PageName>" on "DEV"
		Then the CMS FAQ link should point to updated link: "<Link>"
Examples:
	|  PageName	|  Link |
	|  products	|https://www.cms.gov/Regulations-and-Guidance/Legislation/EHRIncentivePrograms/FAQ.html|
	|  inactive	|https://www.cms.gov/Regulations-and-Guidance/Legislation/EHRIncentivePrograms/FAQ.html|
	
Scenario: Verify text update on Charts page
        Given I am on CHPL charts page
        Then I see text "This is a beta release for charts, which are dynamic and populated by the data currently in the CHPL. We will be working on iterating this feature over the coming months. Please use the Health IT Feedback Form for questions or comments." on charts page
        