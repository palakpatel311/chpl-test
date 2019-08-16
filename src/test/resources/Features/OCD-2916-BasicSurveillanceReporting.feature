@Regression
Feature: OCD-2916 Basic Surveillance Reporting
  This test checks whether quarterly surveillance report can be initiated, edited and deleted

Scenario Outline: User logs in as ROLE and verifies the page title and surveillance reports are available for UL LLC, Drummond Group, ICSA Labs and SLI Compliance
    Given I'm logged in as "<ROLE>"
    When I navigate to the surveillance reports page
    Then I see "CHPL Surveillance" as the page title for the surveillance report page
    And I see available reports for "<ACBs>" 
    Examples:
      |ROLE       |ACBs           |
      |ROLE_ADMIN |Drummond Group |
      |ROLE_ADMIN |ICSA Labs      |
      |ROLE_ADMIN |SLI Compliance |
      |ROLE_ADMIN |UL LLC         |
      |ROLE_ONC   |Drummond Group |
      |ROLE_ONC   |ICSA Labs      |
      |ROLE_ONC   |SLI Compliance |
      |ROLE_ONC   |UL LLC         |

Scenario Outline: User logs in as ROLE - initiates, edits and deletes a quarterly surveillance report for ACB 
    Given I'm logged in as "<ROLE>"
    When I navigate to the surveillance reports page
    And I expand "<ACB>"
    And I initate a quarterly surveillance report for "<ACB-Year-Quarter>"
    Then I see "<Initiate Confirmation Message>" on clicking initiate
    And I confirm initiaing a quarterly surveillance report
    Then I see "<Page Title>" for the quarterly surveillance report page
    And "<Subtitle>" for the quarterly surveillance report
    And I set "surveillance-activities" field to "Test surveillance-activities"
    And I set "reactive" field to "Test reactive"
    And I set "prioritized-element" field to "Test prioritized-element"
    And I set "transparency-disclosure" field to "Test transparency-disclosure"
    And I save the quarterly surveillance report
    And I expand "<ACB>"
    And I edit a quarterly surveillance report for "<ACB-Year-Quarter>"
    And I delete the quarterly surveillance report
    Then I see "<Delete Confirmation Message>" on clicking delete
    And I confirm deleting a quarterly surveillance report
    And I expand "<ACB>"
    Then I see the label of Q# button is changed to "Initiate" for "<ACB-Year-Quarter>"
    Examples:
      |ROLE       |ACB              |ACB-Year-Quarter        |Page Title       |Subtitle                                       |Initiate Confirmation Message                                                                   |Delete Confirmation Message                                        |
      |ROLE_ADMIN |Drummond Group   |Drummond Group-2019-Q4  |Quarterly Report |Drummond Group Quarterly Surveillance Reporting|Are you sure you wish to initiate quarterly surveillance reporting for quarter Q4 of year 2019? |Are you sure you wish to delete this Quarterly Surveillance Report?|
      |ROLE_ADMIN |ICSA Labs        |ICSA Labs-2019-Q4       |Quarterly Report |ICSA Labs Quarterly Surveillance Reporting     |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q4 of year 2019? |Are you sure you wish to delete this Quarterly Surveillance Report?|
      |ROLE_ADMIN |SLI Compliance   |SLI Compliance-2019-Q4  |Quarterly Report |SLI Compliance Quarterly Surveillance Reporting|Are you sure you wish to initiate quarterly surveillance reporting for quarter Q4 of year 2019? |Are you sure you wish to delete this Quarterly Surveillance Report?|
      |ROLE_ADMIN |UL LLC           |UL LLC-2019-Q4          |Quarterly Report |UL LLC Quarterly Surveillance Reporting        |Are you sure you wish to initiate quarterly surveillance reporting for quarter Q4 of year 2019? |Are you sure you wish to delete this Quarterly Surveillance Report?|

Scenario: Surveillance reports is not available to a user who is not logged in 
    When I navigate to the surveillance reports page
    Then I do not see the page title for the surveillance report page

