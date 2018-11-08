Feature: CHPL API page test
This test checks CHPL API page has correct product listing 

	Scenario: CHPL API page loads and shows correct title
		Given User is on CHPL API page
		Then CHPL API page title should be "CHPL API"

	Scenario: Verify API list in Product-Controller 
		Given User is on CHPL API page
		When User clicks on Product-Controller link
		Then list of "Product-Controller" should be displayed
		
	Scenario: Verify API list in Scheduler-Controller
		Given User is on CHPL API page
		When User clicks on Scheduler-Controller link
		Then list of Scheduler-Controller operations should be displayed
		
	Scenario: Verify API list in Collections-Controller
		Given User is on CHPL API page
		When User clicks on Collections-Controller link
		Then list of Collections-Controller operations should be displayed
		
	Scenario: Verify API list in API-Key-Controller
		Given User is on CHPL API page
		When User clicks on API-Key-Controller link
		Then list of API-Key-Controller operations should be displayed 
	
	Scenario: Verify API list in Status-Controller
		Given User is on CHPL API page
		When User clicks on Status-Controller link
		Then list of Status-Controller operations should be displayed 
	

	
	