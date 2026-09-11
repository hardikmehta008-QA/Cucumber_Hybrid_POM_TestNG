Feature: Login page feature

  Scenario: Home page title
    Given user is on home page
    When user gets the title of the home page
    Then home page title should be "Automation Exercise"

  Scenario Outline: Login with correct credentials
    Given user clicks on login link
    When user is navigated to login page
    Then verify Login to your account text is visible
    Then user enters valid "<username>" and "<password>"
    And user clicks on the login button
    #And verify that Logged in as username is visible
    Examples:
      | username                | password    |
      | testauto_45@yopmail.com | Testauto@45 |