Feature: API Documentation updates
         OCD-2505 - Update Implementation Note for /certified_products endpoint

Scenario Outline: Verify that implementation note for /certified_products endpoint is updated with new text
    Given I am on CHPL API page
    When I click on "<controller_name>" to see operations list
    And I click on Certified Products endpoint link to view details
    Then implementation note should show updated text "<text>"
    Examples:
    |controller_name|text|
    |certified-product-controller|The required 'versionId' parameter filters the certified products to those assigned to that version|
    