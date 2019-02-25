@Regression 
Feature: OCD-2023: Monitor that download files on CHPL download resources page are correct and current 
  Verify download files are recent, to ensure file generation didn't fail at any point.

  Background: 
    We need to start with an empty download directory, so that we can be sure we're checking the right file for recency. 
    Given I am on download the CHPL resources page on "<env>" 
    And the download directory is empty 

  Scenario Outline: The download files are "recent" 
    Given I am on download the CHPL resources page on "<env>" 
    When I download the "<edition>" "<type>" products file 
    Then the download file is no more than "<days>" days old 
    And the download file is at least "<size>" "<units>" in size 
    And the download file has at least "<items>" items 
    Examples: 
      | env  | edition | type | days | size | units | items |
      | DEV  |    2011 | xml  |   92 |  148 | MB    |  3885 |
      | DEV  |    2014 | xml  |    1 |  470 | MB    |  5250 |
      | DEV  |    2014 | csv  |    1 | 2900 | KB    |  5250 |
      | DEV  |    2015 | xml  |    1 |  180 | MB    |   710 |
      | DEV  |    2015 | csv  |    1 |  420 | KB    |   710 |
      | STG  |    2011 | xml  |   92 |  148 | MB    |  3885 |
      | STG  |    2014 | xml  |    1 |  470 | MB    |  5250 |
      | STG  |    2014 | csv  |    1 | 2900 | KB    |  5250 |
      | STG  |    2015 | xml  |    1 |  180 | MB    |   710 |
      | STG  |    2015 | csv  |    1 |  420 | KB    |   710 |
      | PROD |    2011 | xml  |   92 |  148 | MB    |  3885 |
      | PROD |    2014 | xml  |    1 |  470 | MB    |  5250 |
      | PROD |    2014 | csv  |    1 | 2900 | KB    |  5250 |
      | PROD |    2015 | xml  |    1 |  180 | MB    |   710 |
      | PROD |    2015 | csv  |    1 |  420 | KB    |   710 |

  Scenario Outline: 
    At any given time, when downloaded, file name ends with Date and time format 
    Given I am on download the CHPL resources page on "<env>" 
    When I select the "<File>", download it from drop-down and I see the "<Downloaded File Name>" 
    Then the "<Downloaded File Name>" ends with "yyyyMMdd_HHmmss" and is no more than Days "<Days>" old 
    Examples: 
      | env  | File                 |Downloaded File Name             |Days|
      | DEV  | Surveillance Activity|surveillance-all                 |1   |
      | DEV  | Non-Conformities     |surveillance-with-nonconformities|1   |
      | STG  | Surveillance Activity|surveillance-all                 |1   |
      | STG  | Non-Conformities     |surveillance-with-nonconformities|1   |
      | PROD | Surveillance Activity|surveillance-all                 |1   |
      | PROD | Non-Conformities     |surveillance-with-nonconformities|1   |

  Scenario Outline: 
    At any given time, when downloaded, SED Details file name ends with Date and time format 
    Given I am on collections page: "<Page Name>" on "<env>" 
    When I download the "<File Name>" file 
    Then the "<File Name>" ends with "yyyyMMdd_HHmmss" and is no more than Days "<Days>" old 
    Examples: 
      | env  | Page Name| File Name |Days|
      | DEV  | sed      | chpl-sed  |1   |
      | STG  | sed      | chpl-sed  |1   |
      | PROD | sed      | chpl-sed  |1   |
