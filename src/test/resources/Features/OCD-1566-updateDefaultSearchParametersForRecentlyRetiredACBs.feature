@Regression
Feature: OCD-1566 - Update default search parameters for recently retired ACBs
  This test checks whether CCHIT is unchecked on Search page and ACBs can be retired and unretired 

  Scenario: Verify CCHIT checkbox is unchecked on Search page
    Given I am on CHPL search page
    And I look at ACB filter options selected for default search
    Then I see that "CCHIT" checkbox is unchecked

  Scenario Outline: Verify ACBs can be retired
    Given I'm logged in as "ROLE_ADMIN"
    When I navigate to ONC ACB Management page
    And I click on "<ACB Name>"
    And I edit an ACB 
    And I mark it as retired on "08/01/2015"
    Then ONC ACB have retired status as "Yes"
    Examples:
      |ACB Name      |
      |InfoGard      |
      |ICSA Labs     |
      |Drummond Group|
      |SLI Compliance|

  Scenario Outline: Verify ACBs can be unretired
    Given I'm logged in as "ROLE_ADMIN"
    When I navigate to ONC ACB Management page
    And I click on "<ACB Name>"
    And I edit an ACB
    And I unretire an existing retired ACB
    Then ONC ACB have retired status as "No"
    Examples:
      |ACB Name      |
      |InfoGard      |
      |ICSA Labs     |
      |Drummond Group|
      |SLI Compliance|

  Scenario: Verify ACBs display an error message if any future date of retirement is selected 
    Given I'm logged in as "ROLE_ADMIN"
    When I navigate to ONC ACB Management page
    And I click on "InfoGard"
    And I edit an ACB 
    And I mark it as retired on "08/01/2020"
    Then I see "Retirement date is required and must be before "now"."

