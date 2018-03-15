@Regression
Feature: OCD-1776 - SED Display in product details
  This test is to verify text changes and other display updates to SED section

  Scenario: Verify SED details
    Given I am on listing details page of listing with database ID "8338"
    Then I should see these accordions exist on the details page: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info
    And I should see the accordions in the following order: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info    

  Scenario: Verify usability report title update
    Given I am on listing details page of listing with database ID "8338"
    When I look at SED details
    Then usability report text should read as "Full Usability Report"
    And intended user description header should show as "Description of Intended Users"
    And download button title should read as "Download SED Details"    

  Scenario: Verify SED description shows associated criteria title with criteria number
    Given I am on listing details page of listing with database ID "8338"
    When I look at SED details
    Then the criteria number should also include the criteria title

  Scenario: Verify appropriate message shows when selected product does not have SED data to display
    Given I am on listing details page of listing with database ID "7079"
    When I look at SED details
    Then there should be text "No Certification Criteria were tested for SED"
