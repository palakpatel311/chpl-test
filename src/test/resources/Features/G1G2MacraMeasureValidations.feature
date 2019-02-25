@Regression
Feature: OCD-1970 - Addition / modification of available G1/G2 values
         OCD-2672 - Confirm listing with G1G2 Macra Measures in unattested criteria, save phantom data.
         OCD-2633 - Update text display for G1/G2 input values

Scenario Outline: Mapping legacy values for G1/G2
    Given I am on listing details page of listing with ID "<DB_ID>"
    When I open details for criteria "<CRITERIA>"
    Then Measure Successfully Tested for "<gOption>" should display "<Measure_Name>" for "<CRITERIA>" 
    When I look at Successfully Tested G1G2 Measures
    Then the Required Test shows as "<Required_Test>" for "<Measure_Name>" and associated criteria "<CRITERIA>"
    Examples:
    |DB_ID|CRITERIA|gOption|Measure_Name|Required_Test|
    |8481|170.315 (a)(1)|G2|Computerized Provider Order Entry - Medications: Eligible Professional|Required Test 10: Stage 2 Objective 3 Measure 1|
    |8481|170.315 (a)(1)|G2|Computerized Provider Order Entry - Medications: Eligible Professional|Required Test 10: Stage 3 Objective 4 Measure 1|
    |8481|170.315 (a)(2)|G2|Computerized Provider Order - Laboratory: Eligible Professional|Required Test 11: Stage 2 Objective 3 Measure 2|
    |8481|170.315 (a)(3)|G2|Computerized Provider Order Entry - Diagnostic Imaging: Eligible Professional|Required Test 12: Stage 2 Objective 3 Measure 3|
    |8481|170.315 (a)(3)|G2|Computerized Provider Order Entry - Diagnostic Imaging: Eligible Professional|Required Test 12: Stage 3 Objective 4 Measure 3|   
    |8481|170.315 (a)(13)|G2|Patient-Specific Education: Eligible Professional|Required Test 3: Stage 2 Objective 6|
    |8481|170.315 (a)(13)|G2|Patient-Specific Education: Eligible Professional|Required Test 3: Stage 3 Objective 5 Measure 2|
    |8481|170.315 (a)(13)|G2|Patient-Specific Education: Eligible Clinician|Required Test 3: Promoting Interoperability Objective 3 Measure 2|       
    |8481|170.315 (b)(1)|G2|Support Electronic Referral Loops by Sending Health Information (formerly Patient Care Record Exchange): Eligible Clinician|Required Test 7: Promoting Interoperability Objective 5 Measure 1|
    |8481|170.315 (b)(1)|G2|Request/Accept Patient Care Record: Eligible Professional|Required Test 8: Stage 3 Objective 7 Measure 2|
    |8481|170.315 (b)(2)|G2|Medication/Clinical Information Reconciliation: Eligible Professional|Required Test 9: Stage 2 Objective 7|
    |8481|170.315 (b)(3)|G2|Electronic Prescribing: Eligible Professional|Required Test 1: Stage 2 Objective 4|
    |8511|170.315 (b)(1)|G2|Patient Care Record Exchange: Eligible Clinician|Required Test 7: Promoting Interoperability Transition Objective 6 Measure 1|    
    |8511|170.315 (b)(2)|G2|Medication/Clinical Information Reconciliation: Eligible Clinician|Required Test 9: Promoting Interoperability Objective 5 Measure 3|    
    |8511|170.315 (b)(2)|G2|Medication/Clinical Information Reconciliation: Eligible Clinician|Required Test 9: Promoting Interoperability Transition Objective 7 Measure 1|    
    |8511|170.315 (b)(3)|G2|Electronic Prescribing: Eligible Clinician|Required Test 1: Promoting Interoperability Objective 2 Measure 1|
    |8511|170.315 (b)(3)|G2|Electronic Prescribing: Eligible Clinician|Required Test 1: Promoting Interoperability Transition Objective 2 Measure 1|    
    |8511|170.315 (g)(8)|G2|View, Download, or Transmit (VDT): Eligible Professional|Required Test 4: Stage 2 Objective 8 Measure 2|      
    |8511|170.315 (g)(9)|G2|Patient Electronic Access: Eligible Professional|Required Test 2: Stage 2 Objective 8 Measure 1|    
    |8511|170.315 (g)(9)|G2|View, Download, or Transmit (VDT): Eligible Professional|Required Test 4: Stage 2 Objective 8 Measure 2|    
    |9287|170.315 (e)(1)|G1|Patient Electronic Access: Eligible Hospital/Critical Access Hospital|Required Test 2: Stage 2 Objective 8 Measure 1|        
    |9608|170.315 (g)(8)|G2|Provide Patients Electronic Access to Their Health Information (formerly Patient Electronic Access): Eligible Clinician|Required Test 2: Promoting Interoperability Objective 3 Measure 1|    
    |9608|170.315 (g)(8)|G2|View, Download, or Transmit (VDT): Eligible Professional|Required Test 4: Stage 3 Objective 6 Measure 1|           
    |9608|170.315 (e)(1)|G2|Provide Patients Electronic Access to Their Health Information (formerly Patient Electronic Access): Eligible Clinician|Required Test 2: Promoting Interoperability Objective 3 Measure 1|    
    |8859|170.315 (e)(3)|G2|Patient-Generated Health Data: Eligible Clinician|Required Test 6: Promoting Interoperability Objective 4 Measure 3|
    |8859|170.315 (e)(3)|G2|Patient-Generated Health Data: Eligible Professional|Required Test 6: Stage 3 Objective 6 Measure 3|
    |8878|170.315 (g)(8)|G2|View, Download, or Transmit (VDT): Eligible Professional|Required Test 4: Stage 2 Objective 8 Measure 2|
    |9482|170.315 (g)(8)|G2|Provide Patients Electronic Access to Their Health Information (formerly Patient Electronic Access): Eligible Hospital/Critical Access Hospital|Required Test 2: Stage 3 Objective 5 Measure 1|
    |9482|170.315 (g)(9)|G2|Provide Patients Electronic Access to Their Health Information (formerly Patient Electronic Access): Eligible Hospital/Critical Access Hospital|Required Test 2: Stage 3 Objective 5 Measure 1|
    
Scenario Outline: Upload sample listing for 2015 edition
    Given I'm logged in as "ROLE_ACB"
    And I am on Upload Certified Products page
    When I upload a "2015" listing with CHPL ID "15.05.05.1447.SLI1.v1.00.1.180707"
    Then I see upload successful message
    When I go to Confirm Pending Products Page
    And I open inspect form to inspect listing details
    And I confirm "2015" listing with CHPL ID "15.05.05.1447.SLI1.v1.00.1.180707"
    Then I see that listing was uploaded successfully to CHPL and listing details load as expected for uploaded "2015" listing  
    When I am on Product management page of uploaded listing
    And I open details for criteria "170.315 (a)(2)"
    Then Measure Successfully Tested for "<gOption>" should display "<Measure_Name>" for "<CRITERIA>"
    Examples:
    |gOption|Measure_Name|CRITERIA|
    |G1|Computerized Provider Order - Laboratory: Eligible Professional|170.315 (a)(2)|
    |G2|Computerized Provider Order - Laboratory: Eligible Professional|170.315 (a)(2)|
    