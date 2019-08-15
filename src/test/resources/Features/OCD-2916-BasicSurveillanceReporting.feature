@Regression
Feature: OCD-2916 Basic Surveillance Reporting
  This test checks whether edit, split and merge developer functionality work as expected

Scenario Outline: User logs in as ROLE and verifies navigation is successful to the Surveillance Report page
    Given I'm logged in as "<ROLE>"
    When I navigate to the surveillance reports page
    Then I see "CHPL Surveillance" as the page title for the surveillance report page
    Examples:
      |ROLE       |
      |ROLE_ACB   |
      |ROLE_ADMIN |
      |ROLE_ONC   |

Scenario Outline: User logs in as ROLE and verifies Surveillance reports are available for UL LLC, Drummond Group, ICSA Labs and SLI Compliance
    Given I'm logged in as "<ROLE>"
    When I navigate to the surveillance reports page
    Then I see available reports for "<ACBs>" 
    Examples:
      |ROLE         |ACBs                                             |
      |ROLE_ADMIN   |Drummond Group ICSA Labs SLI Compliance UL LLC   |

Scenario Outline: User logs in as ROLE and verifies years and quarters are listed for each ACB
    Given I'm logged in as "<ROLE>"
    When I navigate to the surveillance reports page
    And I expand "<ACB>"
    Then I see "<Year-Quarters>" listed for each ACB
    Examples:
      |ROLE       |ACB           |Year-Quarters           |
      |ROLE_ADMIN |UL LLC        |Year Q1 Q2 Q3 Q4        |
      |ROLE_ONC   |SLI Compliance|Year Q1 Q2 Q3 Q4        |
      |ROLE_ADMIN |Drummond Group|Year Q1 Q2 Q3 Q4        |
      |ROLE_ONC   |ICSA Labs     |Year Q1 Q2 Q3 Q4        |

Scenario Outline: User logs in as ROLE and initiates a quarterly surveillance report for ACB and verifies the the confirmation message
    Given I'm logged in as "<ROLE>"
    When I navigate to the surveillance reports page
    And I expand "<ACB>"
    And I initate a quarterly surveillance report for "<ACB-Year-Quarter>"
    Then I see "<Confirmation Message>" on clicking initiate
    Examples:
      |ROLE       |ACB              |ACB-Year-Quarter        |Confirmation Message                                                                           |
      |ROLE_ADMIN |Drummond Group   |Drummond Group-2020-Q1  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q1 of year 2020?|
      |ROLE_ADMIN |Drummond Group   |Drummond Group-2019-Q1  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q1 of year 2019?|
      |ROLE_ADMIN |Drummond Group   |Drummond Group-2020-Q2  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q2 of year 2020?|
      |ROLE_ADMIN |Drummond Group   |Drummond Group-2019-Q2  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q2 of year 2019?|
      |ROLE_ADMIN |Drummond Group   |Drummond Group-2020-Q3  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q3 of year 2020?|
      |ROLE_ADMIN |Drummond Group   |Drummond Group-2019-Q3  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q3 of year 2019?|
      |ROLE_ADMIN |Drummond Group   |Drummond Group-2020-Q4  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q4 of year 2020?|
      |ROLE_ADMIN |Drummond Group   |Drummond Group-2019-Q4  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q4 of year 2019?|
      |ROLE_ACB   |ICSA Labs        |ICSA Labs-2020-Q1       |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q1 of year 2020?|
      |ROLE_ACB   |ICSA Labs        |ICSA Labs-2019-Q1       |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q1 of year 2019?|
      |ROLE_ACB   |ICSA Labs        |ICSA Labs-2020-Q2       |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q2 of year 2020?|
      |ROLE_ACB   |ICSA Labs        |ICSA Labs-2019-Q2       |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q2 of year 2019?|
      |ROLE_ACB   |ICSA Labs        |ICSA Labs-2020-Q3       |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q3 of year 2020?|
      |ROLE_ACB   |ICSA Labs        |ICSA Labs-2019-Q3       |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q3 of year 2019?|
      |ROLE_ACB   |ICSA Labs        |ICSA Labs-2020-Q4       |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q4 of year 2020?|
      |ROLE_ACB   |ICSA Labs        |ICSA Labs-2019-Q4       |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q4 of year 2019?|
      |ROLE_ADMIN |SLI Compliance   |SLI Compliance-2020-Q1  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q1 of year 2020?|
      |ROLE_ADMIN |SLI Compliance   |SLI Compliance-2019-Q1  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q1 of year 2019?|
      |ROLE_ADMIN |SLI Compliance   |SLI Compliance-2020-Q2  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q2 of year 2020?|
      |ROLE_ADMIN |SLI Compliance   |SLI Compliance-2019-Q2  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q2 of year 2019?|
      |ROLE_ADMIN |SLI Compliance   |SLI Compliance-2020-Q3  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q3 of year 2020?|
      |ROLE_ADMIN |SLI Compliance   |SLI Compliance-2019-Q3  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q3 of year 2019?|
      |ROLE_ADMIN |SLI Compliance   |SLI Compliance-2020-Q4  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q4 of year 2020?|
      |ROLE_ADMIN |SLI Compliance   |SLI Compliance-2019-Q4  |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q4 of year 2019?|
      |ROLE_ACB   |UL LLC           |UL LLC-2020-Q1          |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q1 of year 2020?|
      |ROLE_ACB   |UL LLC           |UL LLC-2019-Q1          |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q1 of year 2019?|
      |ROLE_ACB   |UL LLC           |UL LLC-2020-Q2          |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q2 of year 2020?|
      |ROLE_ACB   |UL LLC           |UL LLC-2019-Q2          |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q2 of year 2019?|
      |ROLE_ACB   |UL LLC           |UL LLC-2020-Q3          |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q3 of year 2020?|
      |ROLE_ACB   |UL LLC           |UL LLC-2019-Q3          |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q3 of year 2019?|
      |ROLE_ACB   |UL LLC           |UL LLC-2020-Q4          |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q4 of year 2020?|
      |ROLE_ACB   |UL LLC           |UL LLC-2019-Q4          |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q4 of year 2019?|

Scenario Outline: User logs in as ROLE and initiates and deletes a quarterly surveillance report for ACB 
    Given I'm logged in as "<ROLE>"
    When I navigate to the surveillance reports page
    And I expand "<ACB>"
    And I initate a quarterly surveillance report for "<ACB-Year-Quarter>"
    And I confirm initiaing a quarterly surveillance report
    Then I see "<Page Title>" for the quarterly surveillance report page
    And "<Subtitle>" for the quarterly surveillance report 
    And I delete the quarterly surveillance report
    Then I see "<Confirmation Message>" on clicking delete
    And I confirm deleting a quarterly surveillance report
    Then I see "CHPL Surveillance" as the page title for the surveillance report page
    Examples:
      |ROLE       |ACB              |ACB-Year-Quarter        |Page Title       |Subtitle                                       |Confirmation Message                                               |
      |ROLE_ADMIN |UL LLC           |UL LLC-2019-Q1          |Quarterly Report |UL LLC Quarterly Surveillance Reporting        |Are you sure you wish to delete this Quarterly Surveillance Report?|
      |ROLE_ACB   |Drummond Group   |Drummond Group-2020-Q1  |Quarterly Report |Drummond Group Quarterly Surveillance Reporting|Are you sure you wish to delete this Quarterly Surveillance Report?|
      |ROLE_ADMIN |SLI Compliance   |SLI Compliance-2019-Q1  |Quarterly Report |SLI Compliance Quarterly Surveillance Reporting|Are you sure you wish to delete this Quarterly Surveillance Report?|
      |ROLE_ACB   |ICSA Labs        |ICSA Labs-2020-Q1       |Quarterly Report |ICSA Labs Quarterly Surveillance Reporting     |Are you sure you wish to delete this Quarterly Surveillance Report?|

Scenario Outline: User logs in as ROLE - initiates, edits and deletes a quarterly surveillance report for ACB 
    Given I'm logged in as "<ROLE>"
    When I navigate to the surveillance reports page
    And I expand "<ACB>"
    And I initate a quarterly surveillance report for "<ACB-Year-Quarter>"
    And I confirm initiaing a quarterly surveillance report
    And I see "<Page Title>" for the quarterly surveillance report page
    And I set "surveillance-activities" field to "Test surveillance-activities"
    And I set "reactive" field to "Test reactive"
    And I set "prioritized-element" field to "Test prioritized-element"
    And I set "transparency-disclosure" field to "Test transparency-disclosure"
    And I save the quarterly surveillance report
    And I expand "<ACB>"
    And I edit a quarterly surveillance report for "<ACB-Year-Quarter>"
    And I delete the quarterly surveillance report
    And I confirm deleting a quarterly surveillance report
    Then I see "CHPL Surveillance" as the page title for the surveillance report page
    Examples:
      |ROLE       |ACB              |ACB-Year-Quarter        |Page Title       |
      |ROLE_ADMIN |Drummond Group   |Drummond Group-2019-Q4  |Quarterly Report |
      |ROLE_ADMIN |ICSA Labs        |ICSA Labs-2019-Q4       |Quarterly Report |
      |ROLE_ACB   |SLI Compliance   |SLI Compliance-2019-Q4  |Quarterly Report |
      |ROLE_ACB   |UL LLC           |UL LLC-2019-Q4          |Quarterly Report |

Scenario: Surveillance reports is not available to a user who is not logged in 
    When I navigate to the surveillance reports page
    Then I do not see the page title for the surveillance report page

