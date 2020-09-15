Feature: Test Request API

  Scenario: Create Test Lists
    Given I have successfully authenticate
    When I make the Request with valid credential as Token and sessionId
    Then The List is created

  Scenario: Validate to Rate the Movie
    Given I am authenticated with right token and session_id
    When I rate a film
    Then The Movie is rated

  Scenario: Validate to Rate the TV Show
    Given I am authenticated with right token and session_id
    When I rate a film
    Then The TV Show is rated

  Scenario: Validate to Rate the TV Episode
    Given I am authenticated with right token and session_id
    When I rate a film
    Then The TV Episode is rated