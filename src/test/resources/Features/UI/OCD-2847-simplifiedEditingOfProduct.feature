@Regression
Feature: OCD-2806 Simplified Editing of Product
  This test checks whether edit, split and merge product functionality work as expected

Scenario Outline: User logs in as ROLE and sees product edit link exists on new developer page
    Given I'm logged in as "<ROLE>"
    When I navigate to the product edit page for product "1742" of developer "1816"
    Then I see product edit link for product "1742"
    Examples:
      |ROLE       |
      |ROLE_ACB   |
      |ROLE_ADMIN |
      |ROLE_ONC   |

Scenario Outline: User logs in as ROLE and sees product split link exists on new developer page
    Given I'm logged in as "<ROLE>"
    When I navigate to the product edit page for product "1742" of developer "1816"
    Then I see product split link for product "1742"
    Examples:
      |ROLE       |
      |ROLE_ACB   |
      |ROLE_ADMIN |
      |ROLE_ONC   | 

Scenario Outline: User logs in as ROLE and sees product merge link exists on new developer page
    Given I'm logged in as "<ROLE>"
    When I navigate to the product edit page for product "1742" of developer "1816"
    Then I see product merge link for product "1742"
    Examples:
      |ROLE       |
      |ROLE_ADMIN |
      |ROLE_ONC   | 

Scenario Outline: User logs in as ROLE and edits a product
    Given I'm logged in as "<ROLE>"
    When I navigate to the product edit page for product "<product id>" of developer "<developer id>"
    And I edit for product "<product id>"
    Then I see the edited product information is recorded and updated on View Product page for product "<product id>" 
    Examples:
      |ROLE       |product id|developer id|
      |ROLE_ACB   |1742      |1816        |
      |ROLE_ADMIN |593       |378         |
      |ROLE_ONC   |73        |35          |

Scenario: Verify error message is displayed when the product name field is left blank
    Given I'm logged in as "ROLE_ONC"
    When I navigate to the product edit page for product "1742" of developer "1816"
    And I click the edit link for product "1742"
    And I set the product name field to ""
    Then I see error message "Field is required" for product "1742"

