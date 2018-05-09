@Regression
Feature: OCD-2049 - Verify 'Eye' on listing details page works and displays Product History 

Scenario Outline: Verify 'Eye' opens on click and displays Product History
	Given I am on listing details page of listing with database ID "<DB_ID>"
	When I click the 'Eye'
	Then the 'Eye' pop-up opens to show Product History "<Text>"
Examples:
	|DB_ID|Text|
	|437|Certification Status became "Active"|
	|3727|Certification Status became "Active"|
	|4024|Certification Status became "Active"|
	|5138|Certification Status became "Active"|
	|5243|Certification Status became "Active"|
	
Scenario Outline: Verify 'Eye' opens on click and displays appropriate message when there is no history to display
Given I am on listing details page of listing with database ID "<DB_ID>"
	When I click the 'Eye'
	Then the 'Eye' pop-up opens to show appropriate text "<Text>"
Examples:
	|DB_ID|Text|
	|33|No changes have been made to this Certified Product|
	|41|No changes have been made to this Certified Product|
	|49|No changes have been made to this Certified Product|
	|45|No changes have been made to this Certified Product|
	|158|No changes have been made to this Certified Product|
	
