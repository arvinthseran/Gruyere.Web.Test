Feature: SignIn
  In order to create snippet
  As a user
  I want login

  Scenario: Can SignIn
    Given I'm on the gruyere website
    When I login using existing username
      | username | password |
      | arvin    | arvin    |
    Then I'm taken to my account page

    Scenario: Invalid user name or password
      Given I'm on the gruyere website
      When I enter invalid username or password
      Then Message "Invalid user name or password." should be displayed