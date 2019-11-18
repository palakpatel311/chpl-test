@Regression
Feature: OCD-3161 Navigation to Shortcuts Pages is successful and displays correct page title

Scenario Outline: Verify navigation to Charts page is successful and displays correct page title
    Given I'm on Overview page
    And I click Shortcuts top navigation link
    When I open "<Collections>" page
    Then I see "<Page title>" as the page title for the Collections Page
    Examples:
      |Collections                    |Page title                                |
      |API Info for 2015 Ed. Products |API Information for 2015 Edition Products |
      |Banned Developers              |Developers Under Certification Ban        |
      |Decertified Products           |Decertified Products                      |
      |Inactive Certificates          |Inactive Certificates                     |
      |Products: Corrective Action    |Products: Corrective Action Status        |
      |SED Info for 2015 Ed. Products |SED Information for 2015 Edition Products |

Scenario: Verify navigation to Charts page is successful and displays correct page title
    Given I'm on Overview page
    And I click Shortcuts top navigation link
    When I open "Charts" page
    Then I see "Charts" as the page title for the CHPL Charts page



