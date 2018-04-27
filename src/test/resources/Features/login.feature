Feature: User login

Scenario: User logs in as ACB Admin
	Given I am on CHPL admin page	
	When I fill in username
	And I fill in Password
	When I click Log in button 
	Then I should be logged in to CHPL as ACB Admin	
	