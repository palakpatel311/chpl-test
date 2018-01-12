Feature: Test Procedure and Test Data field update in 2015 template V12
  New columns 'Test Procedure' and 'Test Data'
  Allowable values are:
  ONC Test Method (default value - if this field is blank or not present, we should default it to display this value)
  NCQA eCQM Test Method (valid for criteria c2, c3, c4 only)
  HIMSS-IIP Test Method (valid for criteria f1 only)

  Scenario: Verify allowable values display as expected for Test Procedure field for criteria 170.315 (c)(2)
    Given I am on Details page of Listing "8878"
    When I look at criteria details for criteria c2
    Then Test Procedure field should display 'Name: ONC Test Method' text

  Scenario: Verify allowable values display as expected for Test Procedure field for criteria 170.315 (c)(3)
    Given I am on Details page of Listing "8878"
    When I look at criteria details for criteria c3
    Then Test Procedure field should display 'Name: ONC Test Method' text

  Scenario: Verify allowable values display as expected for Test Procedure field for criteria 170.315 (f)(1)
    Given I am on Details page of Listing "8878"
    When I look at criteria details for criteria f1
    Then Test Procedure field should display 'Name: ONC Test Method' text
