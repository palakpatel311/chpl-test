@Regression
Feature: OCD-2023: Monitor that download files on CHPL download resources page are correct and current
  Verify download files are recent, to ensure file generation didn't fail at any point.

  Background: We need to start with an empty download directory, so that we can be sure we're checking the right file for recency.
    Given I am on download the CHPL resources page on "<env>"
    And the download directory is empty

  Scenario Outline: The download files are "recent"
    Given I am on download the CHPL resources page on "<env>"
    When I download the "<edition>" "<type>" products file
    Then the downloaded file is no more than "<days>" days old
    And the downloaded file is at least "<size>" "<units>" in size
    Examples:
      | env  | edition | type | days | size | units |
      | DEV  |    2011 | xml  |   92 |  380 | MB    |
      | DEV  |    2014 | xml  |    1 |  440 | MB    |
      | DEV  |    2014 | csv  |    1 | 2400 | KB    |
      | DEV  |    2015 | xml  |    1 |  120 | MB    |
      | DEV  |    2015 | csv  |    1 |  230 | KB    |
      | STG  |    2011 | xml  |   92 |  380 | MB    |
      | STG  |    2014 | xml  |    1 |  440 | MB    |
      | STG  |    2014 | csv  |    1 | 2400 | KB    |
      | STG  |    2015 | xml  |    1 |  120 | MB    |
      | STG  |    2015 | csv  |    1 |  230 | KB    |
      | PROD |    2011 | xml  |   92 |  380 | MB    |
      | PROD |    2014 | xml  |    1 |  440 | MB    |
      | PROD |    2014 | csv  |    1 | 2400 | KB    |
      | PROD |    2015 | xml  |    1 |  130 | MB    |
      | PROD |    2015 | csv  |    1 |  250 | KB    |

 Scenario: At any given time, when downloaded, Non-Conformities file is up-to-date
    When I select the Non-Conformities file from drop-down
    And I download "surveillance-with-nonconformities" file
    Then the downloaded file shows surveillance-with-nonconformities.csv filename

  Scenario: At any given time, when downloaded, Surveillance activity file name ends with Date and time format
    When I select the Surveillance Activity file from drop-down
    And I download "surveillance-all" file
    Then the "surveillance-all" file ends with "-yyyyMMdd_HHmmss"

  Scenario: At any given time, when downloaded, SED Details file name ends with Date and time format
    Given I am on the Collections page
    When I download the "chpl-sed" file
    Then the "chpl-sed" file ends with "-yyyyMMdd_HHmmss"
