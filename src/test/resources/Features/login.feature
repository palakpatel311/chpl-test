Feature: User login

Scenario: User logs in as ACB Admin
	Given I am on CHPL admin page	
	And I fill in username
	And I fill in Password
	And I click Log in button 
	Then I should be logged in to CHPL as ACB Admin	
	