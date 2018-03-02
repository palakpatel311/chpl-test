Feature: OCD-1937 - Update Listings to have "cleaned" data fields
  Tests in this feature will be used to verify updated text for these fields based on fuzzy matching technique using provided mapping of values.

  Scenario: Verify text update for QMS Standard after bulk update
    Given I am on the Details page of Listing "8556"
    When I open details for criteria "170.315 (g)(4)"
    Then QMS Standard should display "21 CFR Part 820"

  Scenario: Verify text update for Accessibility Standard  after bulk update
    Given I am on the Details page of Listing "8556"
    When I open details for criteria "170.315 (g)(5)"
    Then Accessibility Standard should display "WCAG Level"

  Scenario: Verify text update for UCD Process text after bulk update
    Given I am on the Details page of Listing "9058"
    When I look at SED details
    Then UCD process should display "ISO 9241-210"

  Scenario: Verify text update for UCD Process text after bulk update
    Given I am on the Details page of Listing "8871"
    When I look at SED details
    Then UCD process should display "NISTIR 7741"
