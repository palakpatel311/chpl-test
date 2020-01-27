@Regression
@criteriaDetails
Feature: Verify data in criteria details
  OCD-1951 - Clean up test tool options. Tests below verify update where some of the Test Tools have been consoliated,
  Test tool field displays correct values as per the update.
  OCD-2445- Update missing values in database for 2014 c1 Test tool and 2015 a7 Privacy and Security field
  OCD-746, OCD-1424, OCD-2532- Restrict Functionality Tested values by edition, criteria and display correct description
  OCD-2637- Verify backend update for Test Functionality on select listings
  OCD-2562- Add two new Test Tools
  OCD-3235- Add new Test Tool -Inferno
  OCD-3226-Update Test Functionality

  Scenario Outline: Verify Test Tool field displays correct values in applicable criteria details
    Given I am on listing details page of listing with ID "<CHPL_ID>"
    When I open details for criteria "<CRITERIA>"
    Then Test Tool should display "<Test_Tool_Name>" and "<Test_Tool_Version>" for criteria "<CRITERIA>"
    Examples:
      | CHPL_ID                           | CRITERIA       | Test_Tool_Name                                               | Test_Tool_Version |
      | 15.07.07.1221.FI01.08.01.1.171117 | 170.315 (h)(1) | Tool: Direct Certificate Discovery Tool                      | N/A               | 
      | 15.07.07.1221.PO05.08.01.1.171117 | 170.315 (h)(1) | Tool: Direct Certificate Discovery Tool                      | N/A               | 
      | 15.04.04.2891.Alls.17.00.1.170405 | 170.315 (h)(1) | Tool: Direct Certificate Discovery Tool                      | 3.1.2             |
      | 14.04.04.3000.CTOn.10.01.1.170126 | 170.314 (b)(1) | Tool: Direct Certificate Discovery Tool                      | 2.1               |
      | 15.04.04.2931.MEDI.HC.00.1.171220 | 170.315 (f)(6) | CDC's NHSN CDA Validator                                     | 1.0               |
      | 14.07.07.2051.NEA1.02.01.1.161026 | 170.314 (c)(2) | Cypress                                                      | 2.6.0             |
      | 15.04.04.2891.Alls.17.00.1.170405 | 170.315 (e)(1) | Edge Testing Tool                                            | 1.0.3             |
      | 14.07.07.1221.POA5.09.01.1.170308 | 170.314 (b)(3) | Electronic Prescribing                                       | 1.0.2             |             
      | 15.04.04.2891.Alls.AC.00.1.160804 | 170.315 (f)(3) | HL7 v2 Electronic Laboratory Reporting (ELR) Validation Tool | 1.9.2             | 
      | 14.07.07.2024.FUI1.03.01.1.161122 | 170.314 (e)(1) | Transport Testing Tool                                       | 181               | 
      | 14.04.04.1145.Boom.43.01.1.170126 | 170.314 (c)(1) | Cypress                                                      | 2.4.1             |
      | 14.04.04.1183.Heal.97.01.0.180329 | 170.314 (c)(1) | Cypress                                                      | 2.6.1             |
      | 14.04.04.1183.Thri.PR.01.1.180329 | 170.314 (c)(1) | Cypress                                                      | 2.2               |
      | 14.04.04.1221.Powe.CQ.01.0.180309 | 170.314 (c)(1) | Cypress                                                      | 2.4.0             |
      | 14.07.07.2051.NEA2.02.01.1.161026 | 170.314 (c)(1) | Cypress                                                      | 2.6.0             |
      | 14.02.02.2955.A035.02.02.0.180406 | 170.314 (c)(1) | Cypress                                                      | 3.2.2             |
      | 14.02.02.2968.A027.03.01.1.170306 | 170.314 (c)(1) | Cypress                                                      | 2.4.1             |
      | 14.07.07.2978.ME02.01.01.1.171205 | 170.314 (c)(1) | Cypress                                                      | 2.4.1             |
      | 14.07.07.2934.CHA2.01.01.1.161109 | 170.314 (c)(1) | Cypress                                                      | 2.4.1             |
      | 14.07.07.1459.AXA1.03.02.1.170912 | 170.314 (c)(1) | Cypress                                                      | 2.4.1             |
      | 14.07.04.1221.Heal.7I.01.1.180625 | 170.314 (c)(1) | Cypress                                                      | 2.2.0             |
      | 15.04.04.3043.Rhap.64.00.0.180918 | 170.315 (f)(6) | CDC's NHSN CDA Validator                                     | 1.0               |
      | 15.02.02.3007.A056.01.00.0.180214	| 170.315 (b)(7) | Inferno                                                      | 1.0               |
      
Scenario Outline: Verify Privacy and security Framework field displays correct values in applicable criteria details
    Given I am on listing details page of listing with ID "<CHPL_ID>"
    When I open details for criteria "<CRITERIA>"
    Then Privacy and security Framework should display "<PrivacySecurity>" for criteria "<CRITERIA>"
    Examples:
      | CHPL_ID| CRITERIA       | PrivacySecurity |
      | 9225   | 170.315 (a)(7) |  Approach 1     |
      | 9371   | 170.315 (a)(7) |  Approach 1     |
      | 9080   | 170.315 (a)(7) |  Approach 1     |
      | 9328   | 170.315 (a)(7) |  Approach 1     |
      | 9183   | 170.315 (a)(7) |  Approach 1     |
      | 9401   | 170.315 (a)(7) |  Approach 1     |
      | 8117   | 170.315 (a)(7) |  Approach 2     |
      | 8117   | 170.315 (a)(7) |  Approach 2     |
      | 7971   | 170.315 (a)(7) |  Approach 2     |
      | 8501   | 170.315 (a)(7) |  Approach 2     |
      | 8338   | 170.315 (a)(7) |  Approach 2     |
      | 9367   | 170.315 (a)(7) |  Approach 1     |
      
Scenario Outline: Verify Functionality Tested field displays correct edition and criteria specific values in applicable criteria details 
    Given I am on listing details page of listing with ID "<CHPL_ID>"
    When I open details for criteria "<CRITERIA>"
    Then Functionality Tested should display "<Functionality_Tested>" for criteria "<CRITERIA>"
    Examples:
    | CHPL_ID| CRITERIA       | Functionality_Tested |
    | 9608   | 170.315 (a)(4) | Alternative: 170.315(a)(4)(ii)(B)(1) To a specific set of identified users|  
    | 9608   | 170.315 (a)(7) | Ambulatory: 170.315(a)(7)(i) Over multiple encounters|
    | 9608   | 170.315 (a)(8) | Ambulatory: 170.315(a)(8)(i) Over multiple encounters|
    | 8490   | 170.314 (a)(6) | Ambulatory setting: 170.314(a)(6)(i) Over multiple encounters|
    | 8490   | 170.314 (a)(7) | Ambulatory setting: 170.314(a)(7)(i) Over multiple encounters|
    | 9318   | 170.315 (b)(5) | Ambulatory: 170.315(b)(5)(i)(E) The reason for referral|
    | 9318   | 170.315 (b)(5) | Alternative: 170.315(b)(5)(ii)(A)(5)(i) Be notified of the errors produced|
    | 9318   | 170.315 (g)(6) | Optional: Common Clincial Data Set 170.102(19)(ii) For certification|
    | 9318   | 170.315 (g)(8) | Optional: Common Clincial Data Set 170.102(19)(ii) For certification|
    | 9187   | 170.315 (b)(5) | Alternative: 170.315(b)(5)(ii)(A)(5)(i) Be notified of the errors produced|
    | 8851   | 170.315 (b)(5) | Ambulatory: 170.315(b)(5)(i)(E) The reason for referral|
    | 9318   | 170.315 (g)(9) | Optional: CCDS: 170.102(13)(ii)(C) The patient’s BMI percentile|
    | 9318   | 170.315 (g)(9) | Optional: Common Clincial Data Set 170.102(19)(ii) For certification|
    | 9187   | 170.315 (g)(6) | Optional: Common Clincial Data Set 170.102(19)(ii) For certification|
    | 9187   | 170.315 (g)(8) | Optional: CCDS: 170.102(13)(ii)(C) The patient’s BMI percentile|
    | 9187   | 170.315 (b)(3) | Optional: 170.315(b)(3)(i)(C) For each transaction listed in paragraph (b)(3)(i)(A) of this|
    | 9225   | 170.315 (a)(13)| None |
    | 9098   | 170.315 (a)(13)| None |
    | 9339   | 170.315 (b)(2) | None |
    | 9340   | 170.315 (b)(2) | None |
    | 8976   | 170.315 (a)(13)| None |
    | 9543   | 170.315 (b)(2) | None |
    | 9745   | 170.315 (b)(2) | None |
    | 9569   | 170.315 (b)(2) | None |
    | 9570   | 170.315 (b)(2) | None |
    | 9555   | 170.315 (a)(13)| None |
    | 9739   | 170.315 (a)(13)| None |
    
    Scenario: Upload sample listing for 2015 edition
    Given I'm logged in as "ROLE_ACB"
    And I am on Upload Listings page
    When I upload a "2015" listing with CHPL ID "15.05.05.1447.SLI1.v1.00.1.180707"
    Then I see upload successful message
    When I go to Confirm Pending Products Page
    And I open inspect form to inspect listing details
    And I confirm "2015" listing with CHPL ID "15.05.05.1447.SLI1.v1.00.1.180707"
    And I see that listing was uploaded successfully to CHPL and listing details load as expected for uploaded "2015" listing
    When I open details for criteria "170.315 (f)(7)"
    Then Test Tool should display "Tool: NHCS IG Release 1.2 Validator" and "2" for criteria "170.315 (f)(7)"
    And Test Tool should display "Tool: NHCS IG Release 1 Validator" and "2" for criteria "170.315 (f)(7)"
               