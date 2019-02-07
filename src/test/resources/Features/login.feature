Feature: User login

Scenario: User logs in as ACB Admin
    Given I'm logged in as an ACB
    Then I should be logged in to CHPL as "ACB Admin"
