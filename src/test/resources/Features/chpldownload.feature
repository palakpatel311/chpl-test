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


Scenario: Each download file has associated definition file  
When user selects a file in download file box
Then definition file shows based on download file selection 		
		
Scenario: User logs in, 8 download files available 
Given user is logged in
When user clicks on download file box
Then user sees 8 download files		
