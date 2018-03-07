@Regression
Feature: SED Display in product details
  This test is to verify text changes and other display updates to SED section

  Scenario: Verify SED details
    Given I am on the Details page of Listing "8338"
    Then I should see these accordions exist on the details page: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info
    And I should see the accordions in the following order: Criteria, CQMs, SED, G1/G2, Surveillance, Additional Info

  Scenario: Verify usability report title update
    Given I am on the Details page of Listing "8338"
    When I open SED details accordion
    Then usability report text should read as 'Full Usability Report'

  Scenario: Verify SED Intended User Description header
    Given I am on the Details page of Listing "8338"
    When I open SED details accordion
    Then intended user description header should show as 'Description of Intended Users'

  Scenario: Verify SED download option and button title
    Given I am on the Details page of Listing "8338"
    When I open SED details accordion
    Then the download button title should read as 'Download SED Details'

  Scenario: Verify SED description shows associated criteria title with criteria number
    Given I am on the Details page of Listing "8338"
    When I open SED details accordion
    Then the criteria number should also include the criteria title

  Scenario: Verify appropriate message shows when selected product does not have SED data to display
    Given I am on the Details page of Listing "7079"
    When I open SED details accordion
    Then there should be text 'No Certification Criteria were tested for SED'
