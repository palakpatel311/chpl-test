@Regression
Feature: OCD-3161 Navigation to Shortcuts Pages is successful and displays correct page title

Scenario Outline: Verify navigation to Collections page is successful and displays correct page title
    Given I'm on Overview page
    When I navigate to "<Collections>" page
    Then I see "<Page title>" as the page title for the Collections Page
    Examples:
      |Collections       |Page title                                |
      |api-documentation |API Information for 2015 Edition Products |
      |developers        |Developers Under Certification Ban        |
      |products          |Decertified Products                      |
      |inactive          |Inactive Certificates                     |
      |corrective-action |Products: Corrective Action Status        |
      |sed               |SED Information for 2015 Edition Products |

Scenario: Verify navigation to Charts page is successful and displays correct page title
    Given I'm on Overview page
    When I navigate to "charts" page
    Then I see "Charts" as the page title for the CHPL Charts page

