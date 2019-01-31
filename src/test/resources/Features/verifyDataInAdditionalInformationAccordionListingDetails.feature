@Regression
Feature: Verify data in Additional Information accordion in listing details
         OCD-2641-Verify missing Targeted Users data added back correctly

Scenario Outline: Verify data shows correct for Tageted Users
    Given I am on listing details page of listing with ID "<DB_ID>"
    When I look at Additional Information
    Then Targeted Users should show correct data "<TargetedUser_Data>"
    Examples:
    | DB_ID | TargetedUser_Data       |
    | 9565  | Ambulatory and Inpatient|
    | 9723  | Ambulatory |
    | 9724  | Ambulatory |
    | 9377  |Internal/Family/General Medicine|
    | 9390  |Ambulatory and Inpatient EHR Users|
    | 9612  |Inpatient, Ambulatory|
    | 9830  |Medical, Mental Health Services, Correctional facilities and Modules|
    | 9457  |Ambulatory, State Correctional Prisons and County Jails|
    | 9825  |healthcare providers in private Oncology practices|
    