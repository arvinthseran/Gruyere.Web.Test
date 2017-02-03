Feature: Snippet
  In order to share my opinion
  As a user
  I want create new snippet


Scenario:Can Create New Snippet
  Given I'm on the gruyere website
  And I Create "Time is " as New Snippet
  Then Snippet can be seen under My Snippet

  Scenario: Can Create New Snippet with HTML tags
    Given I'm on the gruyere website
    And I Create "Snippet including Limited HTML tags" New Snippet including HTML tags
    Then Formatted Snippet can be seen under My Snippet