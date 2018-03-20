@Regression
Feature: OCD-2062 - Verify that newly generated & incorrectly removed CMS IDs still work
         Some CMS IDs were lost during an outage. They need to be re-inserted, and able to be validated against. In addition, if a new CMS ID is generated with the same CHPL Listings, the CMS ID should be the new version.

  Scenario Outline: As an end-user, I want to be able to lookup my listings with the old CMS IDs
    Given I am on the CMS ID Reverse Lookup page
    When I look up CMS ID "<CMS_ID>" in the reverse look-up tool
    Then I should see the listings "<CHPL_ID>" that make up the CMS ID
    Examples:
      | CMS_ID          | CHPL_ID                           |
      | 0015H8GK6K0ZZB2 | 14.07.07.2452.VEI1.01.01.0.161111 |
      | 0015H8GK6K0ZZB2 | 15.04.04.2891.Sunr.07.01.1.171201 |

  Scenario Outline: Generating a CMS ID
    When I add "<CHPL_IDs>" Listings to the CMS Widget
    And I generate a CMS ID
    Then the generated CMS ID should be "<CMS_ID>"
    Examples:
      | CHPL_IDs  | CMS_ID          |
      | 8169;8969 | 0015H8GK6K0ZZB2 |