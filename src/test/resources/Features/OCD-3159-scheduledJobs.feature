@Regression
Feature: OCD-3159 - Types of Jobs listed in Scheduled Jobs page
  This test checks whether the correct jobs are listed in scheduled jobs page based on user role

Scenario Outline: For ROLE_ADMIN verify whether the correct jobs are listed in scheduled jobs page
    Given I'm logged in as "ROLE_ADMIN"
    And I'm on Scheduled Jobs page
    Then I see types of jobs with "<Job Name>" , "<Description>" , "<ONC-ACB specific>" and "<Job Type>"
     Examples: 
      |Job Name                                              |Description                                                                                                                |ONC-ACB specific   |Job Type   |
      |urlStatusDataCollector                                |Generates the data for the questionable url report                                                                         |No                 |System Job |
      |updateSingleListingStatusJob                          |Updates the status for a single listing                                                                                    |No                 |User Job   |
      |brokenSurveillanceRulesCreator                        |Generates the data for the broken surveillance rules report                                                                |No                 |System Job |
      |chartDataCreator                                      |Generates the chart data                                                                                                   |No                 |System Job |
      |downloadFileJob2011                                   |Generate download files for 2011.                                                                                          |No                 |System Job |
      |downloadFileJob2014                                   |Generate download files for 2014.                                                                                          |No                 |System Job |
      |downloadFileJob2015                                   |Generate download files for 2015.                                                                                          |No                 |System Job |
      |g3Sed2015DownloadFileJob                              |Generate SED download files for 2015 listings with G3.                                                                     |No                 |System Job |
      |inheritanceErrorsReportCreator                        |Generates the inheritance errors data                                                                                      |No                 |System Job |
      |interruptJob                                          |Triggers interruption of other running job                                                                                 |No                 |System Job |
      |massRequirePasswordChangeJob                          |Require password change, on next login, of all non-super-admin users                                                       |No                 |System Job |
      |ONC All Broken Surveillance Rules Report              |Sends an error report for all Listings breaking Surveillance rules                                                         |No                 |User Job   |
      |ONC Inherited Certification Status Errors Report      |Sends an error report for all Listings breaking ICS rules                                                                  |No                 |User Job   |
      |ONC Overnight Broken Surveillance Rules Report        |Sends an error report for all Listings breaking Surveillance rules within the last day                                     |No                 |User Job   |
      |ONC-ACB All Broken Surveillance Rules Report          |Sends an error report for all Listings breaking Surveillance rules, by specific ACB                                        |Yes                |User Job   |
      |ONC-ACB Inherited Certification Status Errors Report  |Sends an error report for all Listings breaking ICS rules, by specific ACB                                                 |Yes                |User Job   |
      |ONC-ACB Overnight Broken Surveillance Rules Report    |Sends an error report for all Listings breaking Surveillance rules within the last day, by specific ACB                    |Yes                |User Job   |
      |Pending Change Request Report                         |Sends a report of all pending change requests                                                                              |No                 |User Job   |
      |Questionable Activity Report                          |Sends a report of questionable activity within a user defined range of days                                                |No                 |User Job   |
      |Questionable URL Report                               |Sends a report of all URLs entered into the system that respond with a questionable status code.                           |No                 |User Job   |
      |remove2014UploadTemplates                             |Marks 2014 upload templates as deleted                                                                                     |No                 |System Job |
      |removeCriteriaJob                                     |Sets the removed flag to 'true' for specific 2015 criteria                                                                 |No                 |System Job |
      |Summary Statistics Email                              |Sends the Summary Statistics Report                                                                                        |No                 |User Job   |
      |summaryStatisticsCreator                              |Generates the summary statistics report                                                                                    |No                 |System Job |
      |surveillanceDownloadFileJob                           |Generate Surveillance download files.                                                                                      |No                 |System Job |
      |Trigger Developer Ban Notification                    |Send warnings to subscribers when an ONC-ACB has changed status of a listing to a state that might warrant a Developer Ban.|No                 |User Job   |
      |update2014ListingStatusJob                            |Updates the status for 2014 listings                                                                                       |No                 |System Job |
      |updateListingStatusJob                                |Updates the status for a set of listings                                                                                   |No                 |System Job |
      |urlStatusDataCollector                                |Generates the data for the questionable url report                                                                         |No                 |System Job |

