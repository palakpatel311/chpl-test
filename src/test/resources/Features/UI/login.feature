Feature: User login

  Scenario Outline: User logs in as given ROLE
    Given I'm logged in as "<ROLE>"
    Then I should be logged in to CHPL as "<Name>"
    Examples:
      | ROLE       | Name      |
      | ROLE_ADMIN | AQA Admin |
      | ROLE_ONC   | AQA ONC   |
      | ROLE_ACB   | AQA ACB   |
