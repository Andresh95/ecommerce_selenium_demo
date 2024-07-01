Feature: As a demo app user.
  I want to open an account

  Background: enter the ecommerce page
    Given I want to enter the ecommerce page

  Scenario Outline: create new account
    Given the user use the service "Open Account"
    When you fill out the creation request "<typeCta>"
    Then the accounts answer is "Account Opened!"
    Then validate number and "<typeCta>"
    Examples:
      | typeCta  |
      | CHECKING |
      | SAVINGS  |