Feature: SED Display in product details
This test is to verify text changes and other display updates to SED section 

Scenario:
Given I am on a listing's details pages
When I look at the accordions
Then I should see them in the following order: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info

Given I am looking at a listing's SED details
When I look at the SED INtended User Description
Then the header should be named 'Description of Intended Users'

Given I am looking at a listing's SED details
When I look at the 'SED Testing Completion Date'
Then the header should be named 'Date SED Testing was Completed'

Given I am looking at a listing's SED details
When I look at the download button
Then the button should be named 'Download SED Details'

Given I am looking at a listing's SED details
When I look at the associated criteria
Then the criteria number should also include the criteria title
