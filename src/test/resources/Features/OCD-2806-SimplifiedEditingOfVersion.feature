@Regression
Feature: OCD-2806 Simplified Editing of Version
  This test checks whether edit and merge version functionality work as expected

Scenario Outline: User logs in as ROLE and sees edit version link exists on new developer page
    Given I'm logged in as "<ROLE>"
    When I navigate to the version edit page for version "5085" of product "1742" of developer "1816"
    Then I see edit link for version "5085"
    Examples:
      |ROLE       |
      |ROLE_ACB   |
      |ROLE_ADMIN |
      |ROLE_ONC   |

Scenario Outline: User logs in as ROLE and sees merge version link exists on new developer page
    Given I'm logged in as "<ROLE>"
    When I navigate to the version edit page for version "5085" of product "1742" of developer "1816"
    Then I see merge link for version "5085"
    Examples:
      |ROLE       |
      |ROLE_ADMIN |
      |ROLE_ONC   | 

Scenario Outline: User logs in as ROLE and edits a version
    Given I'm logged in as "<ROLE>"
    When I navigate to the version edit page for version "<version id>" of product "<product id>" of developer "<developer id>"
    And I edit for version "<version id>"
    Then I see the version is recorded and updated on View Version page of "<version id>"
    Examples:
      |ROLE       |version id|product id|developer id|
      |ROLE_ACB   |6118      |1742      |1816        |
      |ROLE_ADMIN |2018      |1742      |1816        |
      |ROLE_ONC   |6118      |1742      |1816        |

Scenario: Verify message is displayed in versions to merge section
    Given I'm logged in as "ROLE_ONC"
    When I navigate to the version edit page for version "54" of product "236" of developer "142"
    And I click merge version link for version "54"
    Then I see "At least one other Version must be selected to merge" in versions to merge section

Scenario: Verify error message is displayed when the version field is left blank
    Given I'm logged in as "ROLE_ONC"
    When I navigate to the version edit page for version "54" of product "236" of developer "142"
    And I click merge version link for version "54"
    And I leave the version field blank 
    Then I see error message "Field is required" for version "54"