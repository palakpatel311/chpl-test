@Regression
Feature: Verify API returns correct status codes for a non-logged in user

Scenario Outline: Verify chpl-file-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/files/api_documentation            |200        |
      |/files/api_documentation/details    |200        |

Scenario Outline: Verify surveillance-report-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/surveillance-report/annual         |401        |
      |/surveillance-report/quarterly      |401        |

Scenario Outline: Verify product-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/products                           |200        |
 
Scenario Outline: Verify scheduler-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/schedules/jobs                     |401        |
      |/schedules/triggers                 |401        |

Scenario Outline: Verify collections-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/collections/certified_products     |200        |
      |/collections/decertified-developers |200        |

Scenario Outline: Verify api-key-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/key                                |401        |
      |/key/activity                       |401        |

Scenario Outline: Verify status-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/system-status                      |200        |

Scenario Outline: Verify complaint-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/complaints                         |401        |

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
      |/data/macra_measures                |200        |
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

Scenario Outline: Verify certification-body-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/acbs                               |200        |

Scenario Outline: Verify developer-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/developers                         |200        |

Scenario Outline: Verify dtesting-lab-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/atls                               |200        |

Scenario Outline: Verify certification-id-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/certification_ids                  |401        |
      |/certification_ids/search           |200        |

Scenario Outline: Verify user-management-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/users                              |401        |

Scenario Outline: Verify change-request-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/change-requests                    |401        |

Scenario Outline: Verify annoucement-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/announcements                      |200        |

Scenario Outline: Verify job-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/announcements                      |200        |

Scenario Outline: Verify certified-product-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/certified_products/pending/metadata|401        |
      |/certified_products/sed_details     |200        |

Scenario Outline: Verify surveillance-controller endpoints return correct status codes for a non-logged in user
    Then the "<API>" endpoint returns correct "<Status Code>"
    Examples:
      |API                                 |Status Code|
      |/surveillance/pending               |401        |

