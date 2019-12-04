@Regression
Feature: OCD-2534 Replace ONC_CHPL@hhs.gov email address with Health IT Feedback Form Website
This test checks whether ONC_CHPL@hhs.gov email addresss is replaced with Health IT Feedback From Website in different pages

Scenario: Verify in CHPL Charts Page
    Given I am on CHPL charts page
    Then "Health IT Feedback Form" points to "https://www.healthit.gov/form/healthit-feedback-form"

Scenario: Verify in CHPL Resources Dropdown - Contact us
    Given I am on CHPL search page
    When I click CHPL Resources Top Navigation Link
    Then I see Contact Us link points to "https://www.healthit.gov/form/healthit-feedback-form"

Scenario: Verify in User Registration Page
    Given I am on User Registration page
    When I open create a new account form
    Then "Health IT Feedback Form", points to "https://www.healthit.gov/form/healthit-feedback-form"

Scenario: Verify in CHPL API Page
    Given I am on CHPL API page
    Then Verify "Created by CHPL Development Team. Please submit any questions using the Health IT Feedback Form and select the "Certified Health IT Products List (CHPL)" category." under Certified Health IT Product Listing is followed by "https://www.healthit.gov/form/healthit-feedback-form"