@Regression
Feature: OCD-111 Develop export/download functionality for search results
  This test checks whether search results are downloaded and displays correct information

Scenario Outline: Verify whether search results file is downloaded and displays correct information 
    Given I am on CHPL search page
    And the download directory is empty 
    When I click Download Search Results button
    And I click download 50 Results button
    Then the file is downloaded and contains selected filter options as "Edition,Developer,Product,Version,Certification Date,CHPL ID,Status,Details" where CHPL ID is "<CHPL ID>"
    Examples:
      |CHPL ID   |
      |CHP-022844|
      |CHP-026059|
      |CHP-028979|

Scenario Outline: Verify whether correct error message is displayed if more than 50 results per page is selected 
    Given I am on CHPL search page
    When I search "<count>" results per page and I try to download the file
    Then I see the text as "Please reduce results to less than 50 to download them"
    Examples:
      |count|
      |100  |
      |250  |
