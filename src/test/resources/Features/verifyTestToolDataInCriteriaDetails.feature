@Regression
Feature: Verify Test Tool data shows correct in criteria details
  OCD-1951 - Clean up test tool options. Tests below verify update where some of the Test Tools have been consoliated,
  Test tool field displays correct values as per the update.

  Scenario Outline: Verify Test Tool field displays correct values in applicable criteria details
    Given I am on listing details page of listing with ID "<CHPL_ID>"
    When I open details for criteria "<CRITERIA>"
    Then Test Tool should display "<Test_Tool>" for criteria "<CRITERIA>"
    Examples:
      | CHPL_ID                           | CRITERIA       | Test_Tool                                                    |
      | 15.07.07.1221.FI01.08.01.1.171117 | 170.315 (h)(1) | Tool: Direct Certificate Discovery Tool                      |
      | 15.07.07.1221.PO05.08.01.1.171117 | 170.315 (h)(1) | Tool: Direct Certificate Discovery Tool                      |
      | 15.04.04.2891.Alls.17.00.1.170405 | 170.315 (h)(1) | Tool: Direct Certificate Discovery Tool                      |
      | 14.04.04.3000.CTOn.10.01.1.170126 | 170.314 (b)(1) | Tool: Direct Certificate Discovery Tool                      |
      | 15.04.04.2931.MEDI.HC.00.1.171220 | 170.315 (f)(6) | CDC's NHSN CDA Validator                                     |
      | 14.07.07.2051.NEA1.02.01.1.161026 | 170.314 (c)(2) | Cypress                                                      |
      | 15.04.04.2891.Alls.17.00.1.170405 | 170.315 (e)(1) | Edge Testing Tool                                            |
      | 14.07.07.1221.POA5.09.01.1.170308 | 170.314 (b)(3) | Electronic Prescribing                                       |
      | 15.04.04.2891.Alls.AC.00.1.160804 | 170.315 (f)(3) | HL7 v2 Electronic Laboratory Reporting (ELR) Validation Tool |
      | 14.07.07.2024.FUI1.03.01.1.161122 | 170.314 (e)(1) | Transport Testing Tool                                       |
