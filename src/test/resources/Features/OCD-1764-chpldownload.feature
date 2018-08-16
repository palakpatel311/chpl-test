@Regression
Feature: OCD-1764 - Chpl data files are downloadable and have respective definition files
  To test download files functionality of CHPL application

  Scenario: Anonymous user sees seven download files
    Given I am on download the CHPL resources page on "DEV"
    Then user sees "7" download files

  Scenario: Each download file has associated definition file
    Given I am on download the CHPL resources page on "DEV"
    When user selects a file in download file box
    Then definition file shows based on download file selection
