@selenium
@Regression
Feature: OCD-1763 - Overview page tests
  This test checks overview page under CHPL resources and verifies that it displays correct information from Database
  OCD-2673 - Update content of Overview page
  This test checks whether content is updated on the overview page

  Scenario: Overview page loads and shows correct title
    Given I'm on Overview page
    Then Overview page title should be "CHPL Overview"

  Scenario Outline: Verify ONC-ACB and ONC-ATL information loads from database
    Given I'm on Overview page
    Then ONC-ACB and ONC-ATL information table shows "<Body>" and "<Name>"
    Examples:
      | Body    | Name           |
      | ONC-ACB | Drummond Group |
      | ONC-ACB | ICSA Labs      |
      | ONC-ACB | UL LLC         |
      | ONC-ATL | Drummond Group |
      | ONC-ATL | ICSA Labs      |
      | ONC-ATL | UL LLC         |
      | ONC-ATL | SLI Compliance |

  Scenario Outline: Verify text update on Overview page
    Given I'm on Overview page
    Then the "<updated content>" shows as expected
      Examples:
      |updated content|
      |The Certified Health IT Product List (CHPL) is a comprehensive and authoritative listing of all certified health information technology that have been successfully tested and certified by the ONC Health IT Certification program.|
      |Please use ONC's Health IT Feedback Form|
      |Alternatively, you may choose to browse all certified products by clicking the 'Browse all' option.|