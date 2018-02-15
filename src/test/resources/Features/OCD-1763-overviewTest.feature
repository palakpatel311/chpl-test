@selenium
Feature: Overview page tests
  This test checks overview page under CHPL resources and verifies that it displays

  Scenario: Overview page loads and shows correct title
    Given User is on Overview page
    Then Overview page title should be "CHPL Overview"

  Scenario Outline: Verify ONC-ACB and ONC-ATL information loads from database
    Given User is on Overview page
    Then ONC-ACB and ONC-ATL information table shows "<Body>" and "<Name>"
    Examples:
      | Body    | Name           |
      | ONC-ACB | Drummond Group |
      | ONC-ACB | ICSA Labs      |
      | ONC-ACB | InfoGard       |
      | ONC-ATL | Drummond Group |
      | ONC-ATL | ICSA Labs      |
      | ONC-ATL | InfoGard       |
      | ONC-ATL | SLI Global     |
