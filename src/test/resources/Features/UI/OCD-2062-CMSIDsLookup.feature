@Regression
Feature: OCD-2062: Verify that newly generated & incorrectly removed CMS IDs still work
  Some CMS IDs were lost during an outage. They need to be re-inserted, and made available for validation.
  In addition, if a new CMS ID is generated with the same CHPL Listings, the CMS ID should be the new version.

  Scenario Outline: As an end-user, I want to be able to lookup my listings with the old CMS IDs
    Given I am on the CMS ID Reverse Lookup page
    When I look up CMS ID "<CMS_ID>" in the reverse look-up tool
    Then I should see the listings "<CHPL_ID>" that make up the CMS ID
    Examples:
      | CMS_ID          | CHPL_ID                           |
      | 0015EK9A6FGV4ZQ | 15.04.04.2916.smar.07.01.1.190328 |
      | 0015EK9A6FGV4ZQ | 15.04.04.2891.Sunr.07.02.1.171201 |

  Scenario Outline: Generating a CMS ID
    When I add "<CHPL_IDs>" Listings to the CMS Widget
    And I generate a CMS ID
    Then the generated CMS ID should be "<CMS_ID>"
    Examples:
      | CHPL_IDs  | CMS_ID          |
      | 9956;8969 | 0015EK9A6FGV4ZQ |
