@Regression
Feature: OCD-2806 Simplified Editing of Version
  This test checks whether edit and merge version functionality work as expected

Scenario Outline: User logs in as ROLE and sees edit version link exists on new developer page
    Given I'm logged in as "<ROLE>"
    When I navigate to the version edit page for version "478" of product "1742" of developer "1816"
    Then I see edit link for version "478"
    Examples:
      |ROLE       |
      |ROLE_ACB   |
      |ROLE_ADMIN |
      |ROLE_ONC   |

Scenario Outline: User logs in as ROLE and sees merge version link exists on new developer page
    Given I'm logged in as "<ROLE>"
    When I navigate to the version edit page for version "6041" of product "1742" of developer "1816"
    Then I see merge link for version "6041"
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
      |ROLE_ACB   |6041      |1742      |1816        |
      |ROLE_ADMIN |7177      |1742      |1816        |
      |ROLE_ONC   |6042      |1742      |1816        |

Scenario: Verify message is displayed in versions to merge section
    Given I'm logged in as "ROLE_ONC"
    When I navigate to the version edit page for version "54" of product "236" of developer "142"
    And I click the merge version link for version "54"
    Then I see "At least one other Version must be selected to merge" in versions to merge section

Scenario: Verify error message is displayed when the version field is left blank
    Given I'm logged in as "ROLE_ONC"
    When I navigate to the version edit page for version "54" of product "236" of developer "142"
    And I click the merge version link for version "54"
    And I set the version field to ""
    Then I see error message "Field is required" for version "54"

Scenario Outline: User logs in as ROLE and sees version split link exists on new developer page
    Given I'm logged in as "<ROLE>"
    When I navigate to the version edit page for version "<version id>" of product "<product id>" of developer "<developer id>"
    Then I see split link for version "<version id>"
    Examples:
      |ROLE       |version id|product id|developer id|
      |ROLE_ADMIN |49        |1482      |934         |
      |ROLE_ACB   |49        |1482      |934         |
      |ROLE_ONC   |49        |1482      |934         |

Scenario: Verify message is displayed in listings moving to new version
    Given I'm logged in as "ROLE_ADMIN"
    When I navigate to the version edit page for version "49" of product "1482" of developer "934"
    And I click the split version link for version "49"
    Then I see "At least one Listing must be selected to move" in listings moving to new version section
    
