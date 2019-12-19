@Regression
Feature: Search filters
        Search filters include only specific filter options under each category. Other options/placeholders should not show in the list.
        OCD-2825 - 'Pending' certification status shouldn't exist. Tests added to validate only valid options show in certification status filter and check default selections.

Scenario: Verify Certification Status filter options list shows 8 statuses
    Given I am on CHPL search page
    When I look at Certification Status options
    Then I see that Certification Status filter shows "8" statuses

Scenario Outline: Verify Certification Status filter options list shows valid options only
    Given I am on CHPL search page
    When I look at Certification Status options
    Then the displayed status options should include all valid statuses: "<Status>"
    Examples:
    |Status|    
    |Active|
    |Retired|
    |Suspended by ONC|
    |Suspended by ONC-ACB|
    |Terminated by ONC|
    |Withdrawn by Developer|
    |Withdrawn by Developer Under Surveillance/Review|
    |Withdrawn by ONC-ACB|
    
    Scenario Outline: Verify some Certification Status filter options are selected on default search results
    Given I am on CHPL search page
    When I look at Certification Status options
    Then I see that Certification Status "<Status>" checkbox is checked by default
    Examples:
    |Status|    
    |Active|
    |Suspended by ONC|
    |Suspended by ONC-ACB|
    
    Scenario Outline: Verify some Certification Status filter options are not selected on default search results
    Given I am on CHPL search page
    When I look at Certification Status options
    Then I see that Certification Status "<Status>" checkbox is unchecked
    Examples:
    |Status|
    |Retired|
    |Terminated by ONC|
    |Withdrawn by Developer|
    |Withdrawn by Developer Under Surveillance/Review|
    |Withdrawn by ONC-ACB|
    