@Regression
Feature: OCD-2806 Simplified Editing of Version
  This test checks whether edit and merge version functionality work as expected

Scenario Outline: User logs in as ROLE and sees edit version link exists on new developer page
    Given I'm logged in as "<ROLE>"
    When I navigate to edit version page of listing "5085"
    Then I see edit link to edit the version of "5085"
    Examples:
      |ROLE       |
      |ROLE_ACB   |
      |ROLE_ADMIN |
      |ROLE_ONC   |

Scenario Outline: User logs in as ROLE and sees merge version link exists on new developer page
    Given I'm logged in as "<ROLE>"
    When I navigate to edit version page of listing "5085"
    Then I see merge link to merge the version of "5085"
    Examples:
      |ROLE       |
      |ROLE_ADMIN |
      |ROLE_ONC   | 

Scenario Outline: User logs in as ROLE and edits a version
    Given I'm logged in as "<ROLE>"
    And I navigate to edit version page of listing "<Product Version Number>"
    And I edit the version of "<Product Version Number>"
    Then I see the version is recorded and updated on View Version page of "<Product Version Number>"
    Examples:
      |ROLE       |Product Version Number|
      |ROLE_ACB   |6118                  |
      |ROLE_ADMIN |2018                  |
      |ROLE_ONC   |6118                  |