@Regression
Feature: OCD-2574 - Verify correct CHPL Product number is displayed on listing page

Scenario: Verify the correct CHPL Product number is displayed on the listing details page
Given I am on listing details page of listing with ID "9672"
Then the correct CHPL Product number "15.04.04.2788.MEDH.FI.02.0.181008" is displayed 

