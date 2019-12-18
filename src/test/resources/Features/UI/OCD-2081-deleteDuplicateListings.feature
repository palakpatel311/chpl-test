@Regression
Feature: Verify incorrectly uploaded listings have been removed
         OCD-2081, OCD-2572
         Some listings were incorrectly uploaded and needed to be removed. These scenarios confirm that those Listings have been removed.

  Scenario Outline: Verify deleted listings do not show in search results
    Given I am on CHPL search page
    When I search for a missing listing with CHPL ID "<CHPL_ID>"
    Then the search page shows 'No results found' message
    Examples:
      | CHPL_ID                           |
      | 15.04.04.2931.MEDI.IR.00.1.171220 |
      | 15.04.04.2931.MEDI.MP.00.1.171220 |
      | 14.04.04.1221.Cern.05.05.0.180214 |
      | 15.04.04.1821.Alth.31.00.1.180930 | 

  Scenario Outline: Verify listing details do not load for deleted listings
    Given I am on listing details page of listing with ID "<DB_ID>"
    Then the page shows "This listing does not exist" message
    Examples:
      | DB_ID |
      |  9102 |
      |  9241 |
      |  9252 |
      |  9677 |
