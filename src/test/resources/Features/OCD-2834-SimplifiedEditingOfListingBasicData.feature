@Regression
Feature: OCD-2834 Simplified Editing of Listing - Basic data
  This test checks whether edit certified product link is available for logged in users

Scenario Outline: User logs in as ROLE and sees edit certified product link exists on listing details page
    Given I'm logged in as "<ROLE>"
    When I am on listing details page of listing with ID "<listing id>"
    Then I see edit link to edit certified product
    Examples:
      |ROLE       |listing id|
      |ROLE_ACB   |4229      |
      |ROLE_ADMIN |1799      |
      |ROLE_ONC   |5737      |

Scenario Outline: User logs in as ROLE and edits a listing
    Given I'm logged in as "<ROLE>"
    When I am on listing details page of listing with ID "<listing id>"
    And I click on edit certified product link
    And I set the ACB certification field
    Then I see ONC ACB Certification ID is updated on Listing Details Page
    Examples:
      |ROLE       |listing id|
      |ROLE_ACB   |4229      |
      |ROLE_ADMIN |1799      |
      |ROLE_ONC   |5737      |

Scenario: User logs in as ROLE and edits a listing
    Given I'm logged in as "ROLE_ONC"
    When I am on listing details page of listing with ID "5737"
    And I click on edit certified product link
    And I set the Mandatory Disclosures URL filed to "www.example.com"
    Then I see "Improper format" error message for Mandatory Disclosures URL field

Scenario: User logs in as ROLE and edits a listing
    Given I'm logged in as "ROLE_ONC"
    When I am on listing details page of listing with ID "3384"
    And I click on edit certified product link
    And I set the Report File Location field
    Then I see "not a valid URL." error message for Report File Location

Scenario: Verify error message is displayed when the Certification Date field is left blank
    Given I'm logged in as "ROLE_ONC"
    When I am on listing details page of listing with ID "3384"
    And I click on edit certified product link
    And I set the certification date field to ""
    Then I see error message "Field is required" for Certification date

Scenario: Verify error message is displayed when the Product Code field is left blank in the CHPL Product Number
    Given I'm logged in as "ROLE_ONC"
    When I am on listing details page of listing with ID "9268"
    And I click on edit certified product link
    And I set the product code field to ""
    Then I see error message "Product Code is required" for CHPL Product Number

Scenario: Verify error message is displayed when the Version Code field is left blank in the CHPL Product Number
    Given I'm logged in as "ROLE_ONC"
    When I am on listing details page of listing with ID "9268"
    And I click on edit certified product link
    And I set the version code field to ""
    Then I see error message "Version Code is required" for CHPL Product Number

Scenario: Verify error message is displayed when the ICS field is left blank in the CHPL Product Number
    Given I'm logged in as "ROLE_ONC"
    When I am on listing details page of listing with ID "9268"
    And I click on edit certified product link
    And I set the ICS field to ""
    Then I see error message "ICS Code is required" for CHPL Product Number

Scenario Outline: Verify error message is displayed when one/two/three characters/numbers entered in the Product Code field for the CHPL Product Number
    Given I'm logged in as "<ROLE>"
    When I am on listing details page of listing with ID "<listing id>"
    And I click on edit certified product link
    And I set the product code field to "<value>"
    Then I see error message "<Error Message>" for CHPL Product Number
    Examples:
      |ROLE      |listing id|value |Error Message                                                                     |
      |ROLE_ADMIN|9268      |a     |Product Code must consist of letters, numbers and/or "_", and be 4 characters long|
      |ROLE_ONC  |9268      |ab    |Product Code must consist of letters, numbers and/or "_", and be 4 characters long|
      |ROLE_ACB  |9268      |abc   |Product Code must consist of letters, numbers and/or "_", and be 4 characters long|
      |ROLE_ONC  |9268      |AB#$  |Product Code must consist of letters, numbers and/or "_", and be 4 characters long|
      |ROLE_ONC  |9268      |ABCDE |Product Code must consist of letters, numbers and/or "_", and be 4 characters long|

Scenario Outline: Verify error message is displayed when one character/number is entered in the Version Code field for the CHPL Product Number
    Given I'm logged in as "<ROLE>"
    When I am on listing details page of listing with ID "<listing id>"
    And I click on edit certified product link
    And I set the version code field to "<value>"
    Then I see error message "<Error Message>" for CHPL Product Number
    Examples:
      |ROLE      |listing id|value|Error Message                                                                     |
      |ROLE_ADMIN|9268      |1    |Version Code must consist of letters, numbers and/or "_", and be 2 characters long|
      |ROLE_ONC  |9268      |a    |Version Code must consist of letters, numbers and/or "_", and be 2 characters long|
      |ROLE_ADMIN|9268      |AB#$ |Version Code must consist of letters, numbers and/or "_", and be 2 characters long|
      |ROLE_ADMIN|9268      |abc  |Version Code must consist of letters, numbers and/or "_", and be 2 characters long|
      |ROLE_ONC  |9268      |123  |Version Code must consist of letters, numbers and/or "_", and be 2 characters long|

Scenario Outline: Verify error message is displayed when one or more than two numbers entered in the ICS field for the CHPL Product Number
    Given I'm logged in as "<ROLE>"
    When I am on listing details page of listing with ID "<listing id>"
    And I click on edit certified product link
    And I set the ICS field to "<value>"
    Then I see error message "<Error Message>" for CHPL Product Number
    Examples:
      |ROLE      |listing id|value|Error Message                                                                     |
      |ROLE_ADMIN|9268      |1    |ICS Code must be a two digit single number from 00 to 99                          |
      |ROLE_ONC  |9268      |123  |ICS Code must be a two digit single number from 00 to 99                          |
      |ROLE_ONC  |9268      |a    |ICS Code must be a two digit single number from 00 to 99                          |
      |ROLE_ADMIN|9268      |#$   |ICS Code must be a two digit single number from 00 to 99                          |

Scenario Outline: Verify certification status messages are correct based on the certification status selected from the drop-down list
    Given I'm logged in as "<ROLE>"
    When I am on listing details page of listing with ID "<listing id>"
    And I click on edit certified product link
    And I add a certification status
    And I select "<Certification Status>" certification status from the drop-down list
    Then I see the "<Certification Status Message>"
    Examples:
     |ROLE      |listing id|Certification Status                              |Certification Status Message                                                                                                                                |
     |ROLE_ONC  |9268      |'Active'                                          |Certification Status must differ from previous Status                                                                                                       |
     |ROLE_ONC  |9268      |'Suspended by ONC'                                |Setting this product to this status will cause the developer to be marked as "Suspended by ONC"                                                             |
     |ROLE_ADMIN|9268      |'Terminated by ONC'                               |Setting this product to this status will cause the developer to be marked as "Under Certification Ban"                                                      |
     |ROLE_ADMIN|9268      |'Withdrawn by Developer'                          |Be sure this product is not under surveillance or soon to be under surveillance, otherwise use the status "Withdrawn by Developer Under Surveillance/Review"|
     |ROLE_ACB  |9268      |'Withdrawn by Developer Under Surveillance/Review'|Setting this product to this status may trigger a ban by ONC                                                                                                |
     |ROLE_ACB  |9268      |'Withdrawn by ONC-ACB'                            |Setting this product to this status may trigger a ban by ONC                                                                                                |

Scenario: Verify editing Other ACB field is saved and recorded on listing details page under Additional Information section
    Given I'm logged in as "ROLE_ADMIN"
    When I am on listing details page of listing with ID "3901"
    And I click on edit certified product link
    And I set the Other ACB field
    And I expand the Additional Information section on listing details page
    Then I see Other ACB is updated on listing details page under Additional Information section

Scenario: Verify editing Relied Upon Software field is saved and recorded on listing details page under Additional Information section
    Given I'm logged in as "ROLE_ADMIN"
    When I am on listing details page of listing with ID "3901"
    And I click on edit certified product link
    And I set the Relied Upon Software Field
    Then I see Relied Upon Software is updated on listing details page
    
