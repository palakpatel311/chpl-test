@Regression
Feature: OCD-3088 Update the menu navigation and title page to Complaints Reporting
  This test checks whether the complaints reporting menu navigation and complaints reporting page have Complaints Reporting as text

Scenario Outline: User logs in as ROLE and verifies the complaints reporting menu navigation and complaints reporting page have Complaints Reporting as text
    Given I'm logged in as "<ROLE>"
    When I click the Surveillance drop-down
    Then I see "<Expected Text>" as the menu navigation text for Complaints Reporting
    And I click Complaints Reporting
    Then I see "<Expected Text>" as the page title on Complaints Reporitng page
    Examples:
      |ROLE       |Expected Text       |
      |ROLE_ADMIN |Complaints Reporting|
      |ROLE_ONC   |Complaints Reporting|
      |ROLE_ACB   |Complaints Reporting|

