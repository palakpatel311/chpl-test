@Regression
@complaints
Feature: Verify complaints can be added
         OCD-2912-Create a basic complaint, edit a complaint, delete a complaint
         OCD-2913-Associate a complaint with a listing
         OCD-2914-Associate a complaint with criteria
         OCD-2915-Associate a complaint with surveillance
         OCD-3116-Validate compliant status based on closed date

Scenario Outline: Add a complaint
    Given I'm logged in as "ROLE_ACB"
    And I am on complaints page
    When I click Add New Complaint button
    Then "Add Complaint" form should open to add new complaint
    When I enter complaint data in fields: "<ONC-ACB>" "<Received Date>" "<Closed Date>" "<ONC-ACB Complaint ID>" "<ONC Complaint ID>" "<Complainant Type>" "<Summary>"
    And I click save button
    Then a new complaint with given "<ONC-ACB Complaint ID>" should be added to CHPL 
Examples:
    |ONC-ACB|Received Date|Closed Date|ONC-ACB Complaint ID|ONC Complaint ID|Complainant Type|Summary|
    |Drummond Group|07/12/2019|07/12/2019|ONCACB001|ONC001|Developer|Test Summary|
    
Scenario: Edit a complaint
    Given I'm logged in as "ROLE_ACB"
    And I am on complaints page
    And I click Add New Complaint button
    And I enter complaint data in fields: "SLI Compliance" "07/12/2019" "07/12/2019" "ONCACB003" "ONC001" "Developer" "TBD"
    And I click save button
    When I click Edit complaint for ONC-ACB Complaint ID "ONCACB003"
    Then "Edit Complaint" form should open
    When I edit data in ONC Complaint ID field to "TsT0NC-1525"
    And I click save button
    Then the edits should save and show "TsT0NC-1525" in complaints view table
    
Scenario: Delete a complaint
    Given I'm logged in as "ROLE_ACB"
    And I am on complaints page
    And I click Add New Complaint button
    And I enter complaint data in fields: "SLI Compliance" "07/12/2019" "07/12/2019" "ONCACB004" "ONC001" "Developer" "TBD"
    And I click save button
    And I click delete button to delete complaint with ONC-ACB Complaint ID "ONCACB004"
    When I confirm delete
    Then the complaint with ONC-ACB Complaint ID "ONCACB004" should not display in complaints view table
    
Scenario: Associate a listing to a complaint
    Given I'm logged in as "ROLE_ACB"
    And I am on complaints page
    And I click Add New Complaint button
    And I enter complaint data in fields: "SLI Compliance" "07/12/2019" "07/12/2019" "ONCACB002" "ONC001" "Developer" "TBD"
    When I associate listing "15.05.05.2760.ISAD.01.00.0.180412" to the complaint
    And I click save button
    And I click Edit complaint for ONC-ACB Complaint ID "ONCACB002"
    Then the listing "15.05.05.2760.ISAD.01.00.0.180412" should be associated to the complaint
    And I click delete button to delete complaint with ONC-ACB Complaint ID "ONCACB002"
    And I confirm delete
    
Scenario: Associate a surveillance to a complaint
    Given I'm logged in as "ROLE_ACB"
    And I am on complaints page
    And I click Add New Complaint button
    And I enter complaint data in fields: "SLI Compliance" "07/12/2019" "07/12/2019" "ONCACB006" "ONC001" "Developer" "TBD"
    And I associate listing "15.05.05.2760.ISAD.01.00.0.180412" to the complaint
    When I associate surveillance "SURV01 - 15.05.05.2760.ISAD.01.00.0.180412" to the complaint
    And I click save button
    And I click Edit complaint for ONC-ACB Complaint ID "ONCACB006"
    Then the surveillance "15.05.05.2760.ISAD.01.00.0.180412 - SURV01" should be associated to the complaint
    
Scenario: Associate a criteria to a complaint
    Given I'm logged in as "ROLE_ACB"
    And I am on complaints page
    And I click Add New Complaint button
    And I enter complaint data in fields: "SLI Compliance" "07/12/2019" "07/12/2019" "ONCACB005" "ONC001" "Developer" "TBD"
    When I associate criteria "170.315 (a)(1)" to the complaint
    And I click save button
    And I click Edit complaint for ONC-ACB Complaint ID "ONCACB005"
    Then the criteria "170.315 (a)(1)" should be associated to the complaint
    
Scenario: Validate compliant status based on closed date
    Given I'm logged in as "ROLE_ACB"
    And I am on complaints page
    When I click Add New Complaint button
    Then "Add Complaint" form should open to add new complaint
    When I enter complaint data in fields: "Drummond Group" "07/12/2019" "" "ONCACB009" "ONC001" "Developer" "TBD"
    And I click save button
    Then the complaint with given ONC-ACB Complaint ID "ONCACB009" and Status "Open" is displayed in complaints view table
    When I click Edit complaint for ONC-ACB Complaint ID "ONCACB009"
    Then "Edit Complaint" form should open
    When I edit data in Closed Date field to "07/13/2019"
    And I click save button
    Then the complaint with given ONC-ACB Complaint ID "ONCACB009" and Status "Closed" is displayed in complaints view table
