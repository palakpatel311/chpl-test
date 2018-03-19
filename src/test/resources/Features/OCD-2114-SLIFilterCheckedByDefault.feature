Feature: OCD-2114 - Test update to ACB filters on Search page to have SLI Compliance ACB checked by deafult in search filters

Scenario: Verify SLI Compliance filter option under ACB filters is checked by default
Given I am on CHPL search page
When I look at ACB filter options
Then I see that SLI checkbox is checked

Scenario: Verify SLI Compliance listings show in search results for search with default options
Given I am on CHPL search page
When I search for a listing with CHPL ID "CHP-006600"
Then I should see listing "CHP-006600" in CHPL search results
