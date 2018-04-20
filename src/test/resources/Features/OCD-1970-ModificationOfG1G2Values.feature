@Regression
Feature: OCD-1970 - Addition / modification of available G1/G2 values

Scenario Outline: Mapping legacy values for G2
	Given I am on listing details page of listing with database ID "<DB_ID>"
	When I open details for criteria "<CRITERIA>"
	Then Measure Successfully Tested for G2 should display "<Measure_Name>" for "<CRITERIA>" 
	And When I look at  Successfully Tested G1G2 Measures
	Then the "<Measure_Name>" shows Required Text as "<Required_Text>" and associated criteria as "<CRITERIA>"
	Examples:
    |DB_ID|CRITERIA|Measure_Name|Required_Text|
    |8481|170.315 (a)(1)|Computerized Provider Order Entry - Medications: Eligible Provider|Required Test 10: Stage 2 Objective 3 Measure 1|
    |8481|170.315 (a)(1)|Computerized Provider Order Entry - Medications: Eligible Provider|Required Test 10: Stage 3 Objective 4 Measure 1|
    |8481|170.315 (a)(2)|Computerized Provider Order - Laboratory: Eligible Provider|Required Test 11: Stage 2 Objective 3 Measure 2|
    |8481|170.315 (a)(2)|Computerized Provider Order - Laboratory: Eligible Provider|Required Test 11: Stage 3 Objective 4 Measure 2|
    |8481|170.315 (a)(3)|Computerized Provider Order Entry - Diagnostic Imaging: Eligible Provider|Required Test 12: Stage 2 Objective 3 Measure 3|
    |8481|170.315 (a)(3)|Computerized Provider Order Entry - Diagnostic Imaging: Eligible Provider|Required Test 12: Stage 3 Objective 4 Measure 3|   
    |9225|170.315 (a)(10)|Electronic Prescribing: Eligible Clinician|Required Test 1: ACI Transition Objective 2 Measure 1|
    |9225|170.315 (a)(10)|Electronic Prescribing: Eligible Clinician|Required Test 1: ACI Objective 2 Measure 1|  
    |8481|170.315 (a)(13)|Patient-Specific Education: Eligible Provider|Required Test 3: Stage 2 Objective 6|
    |8481|170.315 (a)(13)|Patient-Specific Education: Eligible Provider|Required Test 3: Stage 3 Objective 5 Measure 2|
    |8511|170.315 (b)(1)|Patient Care Record Exchange:  Eligible Clinician|Required Test 7:  ACI Objective 5 Measure 1|
    |8511|170.315 (b)(1)|Patient Care Record Exchange:  Eligible Clinician|Required Test 7: ACI Transition Objective 6 Measure 1|
    |8511|170.315 (b)(2)|Medication/Clinical Information Reconciliation: Eligible Clinician|Required Test 9:  ACI Transition Objective 7 Measure 1|      
    |8511|170.315 (b)(2)|Medication/Clinical Information Reconciliation: Eligible Clinician|Required Test 9: ACI Objective 5 Measure 3|
    |8511|170.315 (b)(3)|Electronic Prescribing: Eligible Clinician|Required Test 1:  ACI Objective 2 Measure 1|
    |8511|170.315 (b)(3)|Electronic Prescribing: Eligible Clinician|Required Test 1: ACI Transition Objective 2 Measure 1|
    |8511|170.315 (b)(3)|Electronic Prescribing: Eligible Clinician Group|Required Test 9: ACI Objective 5 Measure 3|
    |8511|170.315 (g)(8)|View, Download, or Transmit (VDT):  Eligible Clinician Individual (TIN/NPI)|Required Test 4: ACI Objective 4 Measure 1|     
	|8511|170.315 (g)(8)|View, Download, or Transmit (VDT):  Eligible Clinician Group|Required Test 4: ACI Transition Objective 3 Measure 2|
	|8511|170.315 (g)(8)|View, Download, or Transmit (VDT):  Eligible Provider Individual|Required Test 4: Stage 2 Objective 8 Measure 2|
	|8511|170.315 (g)(9)|View, Download, or Transmit (VDT):  Eligible Provider|Required Test 4: Stage 3 Objective 6 Measure 1|
	|8511|170.315 (g)(9)|View, Download, or Transmit (VDT):  Eligible Provider|Required Test 4: Stage 2 Objective 8 Measure 2|
	|8511|170.315 (g)(9)|View, Download, or Transmit (VDT):  Eligible Provider|Required Test 2: Stage 3 Objective 5 Measure 1|	
	
Scenario Outline: Mapping legacy values for G1
	Given I am on listing details page of listing with database ID "<DB_ID>"
	When I open details for criteria "<CRITERIA>"
	Then Measure Successfully Tested for G1 should display "<Measure_Name>" for "<CRITERIA>"
	And When I look at  Successfully Tested G1G2 Measures
	Then the "<Measure_Name>" shows Required Text as "<Required_Text>" and associated criteria as "<CRITERIA>"
	Examples:
	|DB_ID|CRITERIA|Measure_Name|Required_Text|
	|9287|170.315 (e)(1)|Patient Electronic Access:  Eligible Provider|Required Test 2: Stage 2 Objective 8 Measure 1|
	|9287|170.315 (e)(1)|Patient Electronic Access:  Eligible Provider|Required Test 2: Stage 3 Objective 5 Measure 1|
	|9287|170.315 (e)(2)|Secure Electronic Messaging: Eligible Hospital/Critical Access Hospital|Required Test 5: Stage 2 Objective 9|
	|9287|170.315 (e)(2)|Secure Electronic Messaging: Eligible Hospital/Critical Access Hospital|Required Test 5: Stage 3 Objective 6 Measure 2|
	
	
    
    