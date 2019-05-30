@Regression
Feature: OCD-2834 Simplified Editing of Listing - Basic data
  This test checks whether edit certified product link is available for logged in users

Scenario Outline: User logs in as ROLE and sees edit certified product link exists on listing details page
    Given I'm logged in as "<ROLE>"
    When I am on listing details page of listing with ID "<listing id>"
    Then I see edit link to edit certified product
    Examples:
      |ROLE       |listing id|
      |ROLE_ACB   |4229      |
      |ROLE_ADMIN |1799      |
      |ROLE_ONC   |5737      |

Scenario Outline: User logs in as ROLE and edits a listing
    Given I'm logged in as "<ROLE>"
    When I am on listing details page of listing with ID "<listing id>"
    And I click on edit certified product link
    And I set the ACB certification field
    Then I see ONC ACB Certification ID is updated on Listing Details Page
    Examples:
      |ROLE       |listing id|
      |ROLE_ACB   |4229      |
      |ROLE_ADMIN |1799      |
      |ROLE_ONC   |5737      |

Scenario: User logs in as ROLE and edits a listing
    Given I'm logged in as "ROLE_ONC"
    When I am on listing details page of listing with ID "5737"
    And I click on edit certified product link
    And I set the Mandatory Disclosures URL filed to "www.example.com"
    Then I see "Improper format" error message for Mandatory Disclosures URL filed 

Scenario: User logs in as ROLE and edits a listing
    Given I'm logged in as "ROLE_ONC"
    When I am on listing details page of listing with ID "3384"
    And I click on edit certified product link
    And I set the Report File Location filed
    Then I see "not a valid URL." error message for Report File Location

