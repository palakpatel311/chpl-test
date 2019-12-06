@Regression
Feature: Verify search-view-controller endpoints return correct status code

Scenario Outline: Verify search-view-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/data/accessibility_standards       |200        |
      |/data/age_ranges                    |200        |
      |/data/certification-criteria        |200        |
      |/data/certification_bodies          |200        |
      |/data/certification_editions        |200        |
      |/data/certification_statuses        |200        |
      |/data/change-request-status-types   |200        |
      |/data/change-request-types          |200        |
      |/data/classification_types          |200        |
      |/data/complainant-types             |200        |
      |/data/complaint-status-types        |200        |
      |/data/developer_statuses            |200        |
      |/data/developers                    |200        |
      |/data/education_types               |200        |
      |/data/filter_types                  |200        |
      |/data/fuzzy_choices                 |401        |
      |/data/job_types                     |200        |
      |/data/macra-measures                |200        |
      |/data/nonconformity_status_types    |200        |
      |/data/practice_types                |200        |
      |/data/products                      |200        |
      |/data/qms_standards                 |200        |
      |/data/quarters                      |200        |
      |/data/search-options                |200        |
      |/data/surveillance-outcomes         |401        |
      |/data/surveillance-process-types    |401        |
      |/data/surveillance_requirement_types|200        |
      |/data/surveillance_requirements     |200        |
      |/data/surveillance_result_types     |200        |
      |/data/surveillance_types            |200        |
      |/data/targeted_users                |200        |
      |/data/test_data                     |200        |
      |/data/test_functionality            |200        |
      |/data/test_procedures               |200        |
      |/data/test_standards                |200        |
      | /data/test_tools                   |200        |
      |/data/ucd_processes                 |200        |
      |/download                           |200        |
