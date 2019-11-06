@Regression
Feature: OCD-3161 Navigation to Shortcuts Pages is successful and displays correct page title

Scenario: Verify navigation to API Documentation page is successful and displays correct page title
    Given I am on API Documetation page
    Then I see "API Information for 2015 Edition Products" as the page title for the Api Documentation page

Scenario: Verify navigation to Banned Developers page is successful and displays correct page title
    Given I am on Banned Developers page
    Then I see "Developers Under Certification Ban" as the page title for the Banned Developers page

Scenario: Verify navigation to Charts page is successful and displays correct page title
    Given I am on CHPL charts page
    Then I see "Charts" as the page title for the CHPL Charts page

Scenario: Verify navigation to Decertified Products page is successful and displays correct page title
    Given I am on Decertified Products page
    Then I see "Decertified Products" as the page title for the Decertified Products page

Scenario: Verify navigation to Inactive Certificates page is successful and displays correct page title
    Given I am on Inactive Certificates page
    Then I see "Inactive Certificates" as the page title for the Inactive Certificates page

Scenario: Verify navigation to Corrective Action Status page is successful and displays correct page title
    Given I am on Corrective Action Status page
    Then I see "Products: Corrective Action Status" as the page title for the Corrective Action Status page

Scenario: Verify navigation to SED Info for 2015 Products page is successful and displays correct page title
    Given I am on SED Info for 2015 Products page
    Then I see "SED Information for 2015 Edition Products" as the page title for SED Info for 2015 Products page


 