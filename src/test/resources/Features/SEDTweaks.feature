Feature: SED Display in product details
This test is to verify text changes and other display updates to SED section 

Scenario: Verify SED details
Given I am on a listing's details pages
Then I should see the accordions in the following order: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info

Scenario: Verify SED Intended User Description header
When I click open SED accordion
Then intended user description header should show as Description of Intended Users

Scenario: Verify SED Testing Completion Date header and value
Then the header name should read as 'Date SED Testing was Completed'

Scenario: Verify SED download option and button title
Then the download button title should read as 'Download SED Details'

Scenario: Verify usability report title update
Then usability report text should read as 'Full Usability Report'

Scenario: Verify SED description shows associated criteria title with criteria number
Then the criteria number should also include the criteria title

Scenario: Verify appropriate message shows when selected product does not have SED data to display
Then there should be text 'No Certification Criteria were tested for SED'