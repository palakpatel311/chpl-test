@Regression
Feature: Verify expected errors and warnings display on inspect screen after litsing upload
         Sometimes upload files have invalid inputs that should not be accepted and saved after listing confirm. Invalid values are removed where applicable, errors and warnings are shown to users for data removal. 
         OCD-2558-OCD-2558-Verify listing upload with duplicate macra measure value shows warning on inspect and confirm succeeds       
  Scenario: Verify warning for duplicate G1 macra measure value on upload-inspect
    Given I'm logged in as an ACB
    And I am on Upload Certified Products page
    When I upload a "2015" listing with CHPL ID "15.05.05.1447.SLI1.v1.00.1.180707"
    Then I see upload successful message
    When I go to Confirm Pending Products Page
    And I open inspect form to inspect listing details
    Then I see warnings for duplicate macra measures in G1 and G2
    When I confirm "2015" listing with CHPL ID "15.05.05.1447.SLI1.v1.00.1.180707"
    Then I see that listing was uploaded successfully to CHPL and listing details load as expected for uploaded "2015" listing    
