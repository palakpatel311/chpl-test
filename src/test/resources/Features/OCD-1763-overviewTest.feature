@selenium
Feature: Overview page tests
  This test checks overview page under CHPl resources and verifies that it displays

  Scenario: Overview page loads and shows correct title

    When User is on Overview page
    Then Overview page loads successfully and shows correct title

  Scenario: Verify ONC-ACB and ONC-ATL information loads from database

    When User is on Overview page 
    Then ONC-ACB and ONC-ATL information table shows data from databse
