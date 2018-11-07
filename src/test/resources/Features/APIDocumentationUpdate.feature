Feature: API Documentation updates
         OCD-2505 - Update Implementation Note for /certified_products endpoint

Scenario Outline: Verify API documentation updates to endpoint details
    Given I am on CHPL API page
    When I click on "<controller_name>" to see operations list
    And I click on "<API_endpoint>" using "<endpoint_link>" link to view details 
    Then endpoint details should show updated text "<text>"
    Examples:
    |controller_name|API_endpoint|endpoint_link|text|
    |certified-product-controller|certified_products|getCertifiedProductsByVersionUsingGET|The required 'versionId' parameter filters the certified products to those assigned to that version|
    |authentication-controller|auth/authenticate|authenticateJSONUsingPOST|Specifically, the Authorization header must have a value of 'Bearer token-that-gets-returned'.|
    