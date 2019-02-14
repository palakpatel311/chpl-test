@Regression
Feature: OCD-2533 -  Update eCQM numbers and versions for 2019 reporting bundle

Scenario Outline: Verify newly added CQMs in listing details
    Given I am on listing details page of listing with ID "<DB_ID>"
    When I look at CQM details on listing details page
    Then I see newly added CQMs "<CMSID_title>"
    Examples:
    |DB_ID|CMSID_title|
    |9261|CMS349: HIV Screening|
    |9261|CMS645: Bone density evaluation for patients with prostate cancer and receiving androgen deprivation therapy|
    |8490|CMS349: HIV Screening|
    |8490|CMS645: Bone density evaluation for patients with prostate cancer and receiving androgen deprivation therapy|
    
    Scenario Outline: Verify newly added CQM versions
    Given I'm logged in as "ROLE_ACB"
    And I navigate to Manage Developers and Products page listing details section of listing with ID "8511"
    And I open listing edit page
    When I look at CQM details  
    Then there should be version "<version>" available for "<CQM>"    
    Examples:
    |version|CQM|
    |v8|CMS2: Preventive Care and Screening: Screening for Clinical Depression and Follow-Up Plan|
    |v7|CMS9: Exclusive Breast Milk Feeding|
    |v7|CMS22: Preventive Care and Screening: Screening for High Blood Pressure and Follow-Up Documented|
    |v8|CMS65: Hypertension: Improvement in Blood Pressure|
    |v7|CMS155: Weight Assessment and Counseling for Nutrition and Physical Activity for Children and Adolescents|
    |v1|CMS249: Appropriate Use of DXA Scans in Women Under 65 Years Who Do Not Meet the Risk Factor Profile for Osteoporotic Fracture|
    |v1|CMS349: HIV Screening|
