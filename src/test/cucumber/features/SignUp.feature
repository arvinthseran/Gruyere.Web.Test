Feature: SignUp
  In order to create snippet
  As a user
  I want a sign up for new account

  Scenario: User already exists warning message is displayed
    Given I'm on the gruyere website
    When I sign up for new account using existing username
      | username | password |
      | arvin    | arvin    |
    Then  Message "User already exists." should be displayed

  Scenario: Acknowledgement message should be displayed after Successful SignUp
    Given I'm on the gruyere website
    When I sign up for new account as username:gruuser
    Then  Message "Account created." should be displayed

  Scenario: Can create account using foreign languages
    Given I'm on the gruyere website
    When I sign up for new account as username:伟张请联系我
    Then  Message "Account created." should be displayed
