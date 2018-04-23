@Regression
Feature: OCD-2023: Monitor that download files on CHPL download resources page are correct and current
  Verify download files are recent, to ensure file generation didn't fail at any point.

  Background: We need to start with an empty download directory, so that we can be sure we're checking the right file for recency.
    Given I am on download the CHPL resources page
    And the download directory is empty

  Scenario Outline: The download files are "recent"
    When I download the "<edition>" "<type>" products file
    Then the downloaded file is no more than "<days>" days old
    Examples:
      | edition | type | days |
      |    2011 | xml  |   92 |
      |    2014 | xml  |    1 |
      |    2014 | csv  |    1 |
      |    2015 | xml  |    1 |
      |    2015 | csv  |    1 |

  Scenario: At any given time, when downloaded, Surveillance Activity file is up-to-date
    When I download the Surveillance Activity file
    Then the downloaded file shows surveillance-all.csv filename

  Scenario: At any given time, when downloaded, Non-Conformities file is up-to-date
    When I download the Non-Conformities file
    Then the downloaded file shows surveillance-with-nonconformities.csv filename
