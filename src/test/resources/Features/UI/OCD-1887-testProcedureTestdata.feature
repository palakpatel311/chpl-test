@Regression
Feature: OCD-1887 - Test Procedure and Test Data field update in 2015 template V12
  New columns 'Test Procedure' and 'Test Data'
  Allowable values are:
  ONC Test Method (default value - if this field is blank or not present, we should default it to display this value)
  NCQA eCQM Test Method (valid for criteria c2, c3, c4 only)
  HIMSS-IIP Test Method (valid for criteria f1 only)

  Scenario Outline: Verify allowable values display as expected for Test Procedure field for given criteria
    Given I am on listing details page of listing with ID "<DB_ID>"
    When I open details for criteria "<CRITERIA>"
    Then Test Procedure should display "<tpText>" for criteria "<CRITERIA>"
    Examples:
      | DB_ID | CRITERIA       | tpText                |
      |  8878 | 170.315 (c)(2) | Name: ONC Test Method |
      |  8878 | 170.315 (c)(3) | Name: ONC Test Method |
      |  8878 | 170.315 (f)(1) | Name: ONC Test Method |
