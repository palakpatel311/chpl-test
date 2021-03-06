@selenium
@Regression
Feature: Overview page tests
  OCD-1763 - This test checks overview page under CHPL resources and verifies that it displays correct information from Database
  OCD-2673 - Update content of Overview page
  This test checks whether content is updated on the overview page
  OCD-2840 - Verify navigation links to different sections on Overview page
  OCD-2894 - Adjust Overview Page for Recommended Web Browsers section
             Verify order of headings, location and new nav link for Recommended Web Browsers section on overiew page.
   
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
      
  Scenario Outline: Verify navigation links on overview page
  Given I'm on Overview page
  When I click "<LinkText>" link from left hand navigation
  Then the link should point to correct url "<URL>" for respective section of "<LinkText>" and header "<headerNumber>" on the page
  Examples:
  |LinkText|URL|headerNumber|
  |What is the CHPL|https://chpl.ahrqdev.org/#/resources/overview#whatIsTheChpl|1|
  |Recommended Web Browsers|https://chpl.ahrqdev.org/#/resources/overview#recommendedWebBrowsers|2|
  |Using the CHPL Website|https://chpl.ahrqdev.org/#/resources/overview#usingTheChplWebsite|3|
  |ONC Certification Program|https://chpl.ahrqdev.org/#/resources/overview#oncCertificationProgram|4|
  |For EHR Developers|https://chpl.ahrqdev.org/#/resources/overview#forEhrDevelopers|5|
  |ONC-ACB and ONC-ATL information|https://chpl.ahrqdev.org/#/resources/overview#oncacbAndAtlInformation|6|
  
   Scenario Outline: Verify order of headings on Overview page
    Given I'm on Overview page
    Then heading number "<headingNumber>" on the page is: "<headingText>"
    Examples:
    |headingNumber|headingText|
    |1|What is the CHPL?|
    |2|Recommended Web Browsers|
    |3|Using the CHPL Website|
    |4|ONC Certification Program|
    |5|For EHR Developers|
    |6|ONC-ACB and ONC-ATL Information|
   