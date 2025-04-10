Feature: Swag Labs Login Tests

  Background: I open the browser

  @Valid
  Scenario: Verify the Login Feature with Valid Credentials
    Given I open the url to test login functionality with valid credentials
    When I Enter Valid Credentials and click log in button int the Login Page
    Then I should see the Inventory Page

  @Invalid
  Scenario Outline: Verify the Login Feature with Invalid Credentials
    Given I open the url of Swag Lab to test login functionality with invalid credentials
    When I enter "<username>" and "<password>" and click the login button in the Login Page
    Then I should see the error message

    Examples:
      | username                   | password        |
      | locked_out_user            | secret_sauceM   |
      | problem_userNOK            | secret_sauceM   |
      | performance_glitch_userNOK | secret_sauceNOK |