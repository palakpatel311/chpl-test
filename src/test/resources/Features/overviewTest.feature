@selenium
Feature: To test Overview page
  This test checks overview page under CHPl resources and verifies that it displays

  Scenario: Overview page loads and shows correct title

    When User clicks on Overview page link in navigation menu
    Then Overview page loads successfully and verify title

  Scenario: Verify ONC-ACB and ONC-ATL information loads from database

    When User looks at ONC-ACB and ONC-ATL information table
    Then the table shows data from databse
