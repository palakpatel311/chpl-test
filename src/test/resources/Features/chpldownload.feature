Feature: Download chpl data files
To test download files functionality of CHPL application

Scenario: Load download page

Given User is on CHPL home
When User clicks on CHPL Resources button
Then Download the CHPL page loads successfully and page title shows correct

Scenario:  User is not logged in, 7 files available
Given user is not logged in
When user clicks on download file box
Then user sees 7 download files

<<<<<<< HEAD
Scenario: Each download file has associated definition file  
=======
Scenario: For each download file respective definition file is displayed 
>>>>>>> dcf5c39dbbdf1f150438590c352a08580d7453e4
When user selects a file in download file box
Then definition file shows based on download file selection 		
		
Scenario: User logs in, 8 download files available 
Given user is logged in
When user clicks on download file box
Then user sees 8 download files		
