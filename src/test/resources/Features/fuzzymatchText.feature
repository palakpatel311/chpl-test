Feature: Clean current data using provided mapping for UCD Process, QMS Standard and Accessibility Satndard
  Tests in this feature will be used to verify updated text for these fields based on fuzzy matching technique using provided mapping of values.

  Scenario: Verify text update for QMS Standard after bulk update
    Given I am on listing details page "8556"
    When I look at criteria details for criteria g4
    Then QMS Standard should display updated 'Standard: 21 CFR 820' text

  Scenario: Verify text update for Accessibility Standard  after bulk update
    Given I am on listing details page "8556"
    When I look at criteria details for criteria g5
    Then Accessibility Standard should display updated 'Other - WCAG Level' text

  Scenario: Verify text update for UCD Process text after bulk update
    Given I am on listing details page "9058"
    When I look at SED details
    Then UCD process should display updated 'ISO 9241-210' text
