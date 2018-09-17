@Regression
Feature: Verify endpoints return correct response
  OCD-2398- Verify the "basic information" product endpoint reports correct addl s/w code in CHPL ID

  Scenario Outline: Certified products basic information endpoint returns correct CHPL ID
    Then the certified_product basic and details endpoints for "<DB_ID>" have the same CHPL ID: "<CHPL_ID>"
    Examples:
      | DB_ID | CHPL_ID                           |
      |  8252 | 15.04.04.2945.Ligh.21.00.1.161229 |
