Feature: LoginFeature
To test Login functionality of CHPL application

Scenario: Access login form

Given User is on CHPL home page
When User clicks on Administrator Login button
Then login form shows in dropdown 

Scenario: Login with correct username and password

Given User enters valid username and password 
When  User clicks login button
Then login should be successful