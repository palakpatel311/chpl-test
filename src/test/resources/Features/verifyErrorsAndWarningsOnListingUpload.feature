@Regression
Feature: Verify expected errors and warnings display on inspect screen after litsing upload
         Sometimes upload files have invalid inputs that should not be accepted and saved after listing confirm. Invalid values are removed where applicable, errors and warnings are shown to users for data removal. 
         OCD-2558-Verify listing upload with duplicate macra measure value shows warning on inspect and confirm succeeds
         OCD-2593-Verify warnings for duplicate values in criteria detail fields in upload template     
  Scenario Outline: Verify warnings for duplicate input values in applicable fields on upload-inspect for 2015 listings
    Given I'm logged in as an ACB
    And I am on Upload Certified Products page
    When I upload a "2015" listing with CHPL ID "15.05.05.1447.SLI1.v1.00.1.180707"
    Then I see upload successful message
    When I go to Confirm Pending Products Page
    And I open inspect form to inspect listing details
    Then I see "<warning>" for duplicate value in "<field>"
  Examples:
    |warning|field|
    |Certification 170.315 (a)(1) contains duplicate Additional Software: Non CP Source: 'InterSystems Cache', Version 'v2', Grouping 'b'. The duplicates have been removed.|Additional Software|
    |Certification 170.315 (a)(1) contains duplicate G1 Macra Measure: 'GAP-EP'. The duplicates have been removed.|G1 Macra Measure|
    |Certification 170.315 (a)(1) contains duplicate G2 Macra Measure: 'GAP-EP'. The duplicates have been removed.|G2 Macra Measure|
    |Certification 170.315 (a)(1) contains duplicate Test Functionality: Number '(a)(1)(ii)'. The duplicates have been removed.|Functionality Tested|
    |Certification 170.315 (a)(1) contains duplicate Test Procedure: Name 'ONC Test Method', Version '1'. The duplicates have been removed.|Test Procedure|
    |Certification 170.315 (b)(1) contains duplicate Test Data: Name 'ONC Test Method', Version '1'. The duplicates have been removed.|Test Data|    
    |Certification 170.315 (b)(1) contains duplicate Test Standard: Number '170.207(i)'. The duplicates have been removed.|Test Standard|
    |Certification 170.315 (b)(1) contains duplicate Test Tool: Name 'HL7 CDA Cancer Registry Reporting Validation Tool', Version '182'. The duplicates have been removed.|Test Tool|
    |Listing contains duplicate Accessibility Standard: '170.204(a)(1)'. The duplicates have been removed.|Accessibility Standard|
    |Listing contains duplicate QMS Standard: 'Home Grown, Criteria: All criteria tested'. The duplicates have been removed.|QMS Standard|
    |Listing contains duplicate Targeted User: 'Mental Health'. The duplicates have been removed.|Targeted User|
    |Listing contains duplicate Testing Lab: 'SLI Compliance'. The duplicates have been removed.|Testing Lab|
    
  Scenario Outline: Verify warnings for duplicate input values in applicable fields on upload-inspect for 2014 listings
    Given I'm logged in as an ACB
    And I am on Upload Certified Products page
    When I upload a "2014" listing with CHPL ID "14.05.05.1447.SL14.v1.00.1.180707"
    Then I see upload successful message
    When I go to Confirm Pending Products Page
    And I open inspect form to inspect listing details
    Then I see "<warning>" for duplicate value in "<field>"
  Examples:
    |warning|field|
    |Certification 170.314 (a)(1) contains duplicate Additional Software: CP Source 'CHP-022218'. The duplicates have been removed.|Additional Software|
    |Certification 170.314 (a)(1) contains duplicate Test Data: Version '1'. The duplicates have been removed.|Test Data|
    |Certification 170.314 (a)(1) contains duplicate Test Procedure: Version '1'. The duplicates have been removed.|Test Procedure|
    |Certification 170.314 (a)(1) contains duplicate Test Standard: Number 'Edge Protocols'. The duplicates have been removed.|Test Standard|
    |Certification 170.314 (a)(4) contains duplicate Test Functionality: Number '(a)(4)(iii)'. The duplicates have been removed.|Test Functionality|
    |Certification 170.314 (b)(1) contains duplicate Test Tool: Name 'Transport Testing Tool', Version '181'. The duplicates have been removed.|Test Tool|
    |Listing contains duplicate QMS Standard: 'ISO 9001. The duplicates have been removed.|QMS Standard|
    |Listing contains duplicate Testing Lab: 'SLI Compliance'. The duplicates have been removed.|Testing Lab|
    
  Scenario Outline: Verify listing upload fails for files that have too long (>20 chars.) Test Task IDs and Participant IDs    
    Given I'm logged in as an ACB
    And I am on Upload Certified Products page
    When I upload a 2015 listing with long ID in "<Field>" 
    Then I see upload failure with appropriate error message "<FailureError>" to indicate failure due to long ID
  Examples:
    |Field|FailureError|
    |Test Task ID|You have exceeded the max length, 20 characters, for the Task Identifier with ID TestTaskIdisinvalidbecauseit'stoolong010101010101.|
    |Participant ID|You have exceeded the max length, 20 characters, for the Participant Identifier ID ParticipantIdisinvalidbecauseit'stoolong01010101010101.|
    