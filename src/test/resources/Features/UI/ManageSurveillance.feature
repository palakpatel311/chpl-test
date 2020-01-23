Feature: OCD-3174 - Sunset 2014: Stop allowing ONC-ACBs to add/edit surveillance and/or non-conformities associated to 2014 Edition Criteria 

@Regression
Scenario: Verify that ACBs do not have access to add and edit surveillance on 2014 listing
    Given I'm logged in as "ROLE_ACB"
    And I'm on Manage surveillance page
    And I search for "CHP-024050" in Manage Surveillance Activity section
    When I open Manage surveillance page of searched listing 
    Then the option to Initiate Surveillance should not be available
    And the edit button should not show for existing surveillance activities
  
Scenario: Verify that error shows when ACBs upload surveillance activity for 2014 edition criteria
    Given I'm logged in as "ROLE_ACB"
    And I am on Upload Surveillance page
    When I upload the "SurveillanceUpload_drummond_2014.csv" surveillance activity
    Then I see upload successful message for surveillance upload
    When I go to Confirm Pending Surveillance Activities Page
    And I inspect surveillance activity details for listing with CHPL ID "14.04.04.2666.Adva.12.01.1.171024"
    Then I see error message "New surveillance cannot be created for a 2014 edition listing"
