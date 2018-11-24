Feature: OCD-2262 - Remove API POST calls that were deprecated in favor of PUT/DELETE 
    This test checks whether deprecated calls are removed from CHPL API webpage

@Regression
Scenario: CHPL API page loads and shows correct title 
    Given I am on CHPL API page 
    Then CHPL API page title should be "CHPL API" 

Scenario Outline: 
    Verify API list in Controller does not contain deprecated calls 
    Given I am on CHPL API page 
    When I click on "<Controller>" link 
    Then list of "<Controller>" operations should be displayed without deprecated calls 
    Examples: 
        | Controller |
        | product-controller |
        | scheduler-controller |
        | collections-controller |
        | api-key-controller |
        | status-controller |

@Acceptance
Scenario Outline: 
    Verify API list in Controller does not contain deprecated calls 
    Given I am on CHPL API page 
    When I click on "<Controller>" link 
    Then list of "<Controller>" operations should be displayed without deprecated calls 
    Examples: 
        | Controller |
        | product-controller |
        | scheduler-controller |
        | collections-controller |
        | api-key-controller |
        | status-controller |
        | authentication-controller |
        | search-view-controller |
        | activity-controller |
        | certification-body-controller |
        | developer-controller |
        | notification-controller |
        | testing-lab-controller |
        | certification-id-controller |
        | user-management-controller |
        | corrective-action-plan-controller |
        | product-version-controller |
        | announcement-controller |
        | job-controller |
        | certified-product-controller |
        | surveillance-controller |
        
