@Regression
Feature: API Documentation updates
         OCD-2505 - Update Implementation Note for /certified_products endpoint
         OCD-969 - Verify API endpoints documentation show updated implementation notes
         OCD-2262 - Remove API POST calls that were deprecated in favor of PUT/DELETE

Scenario: Verify API documentation updates to endpoint details
    Given I am on CHPL API page
    Then API endpoints should show updated implementation notes
