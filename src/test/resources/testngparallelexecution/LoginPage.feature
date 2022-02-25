Feature: Login Page Feature

@smoke
  Scenario: Login Page Title
    Given user is on login page
    When user get title of the page
    Then page title should be "Login - My Store"

@sanity
  Scenario: Forgot Password link
    Given user is on login page
    Then Forgot your password link should be displayed

@regression
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "ashish.karodkar@gmail.com"
    And user enters password "Test@1234"
    And user clicks on Login button
    Then user get title of the page
    And page title should be "My account - My Store"
