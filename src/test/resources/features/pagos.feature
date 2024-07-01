Feature: As a demo app user.
  I want to realize a pay

  Background: enter the ecommerce page
    Given I want to enter the ecommerce page

  Scenario: realize a pay
    Given  i get the account and the account balance
    Given the user use the service "Bill Pay"
    When i make a payment
      | PayeeName     | Address     | City   | State  | ZipCode | Phone      | Account | VerifyAccount | Amount |
      | Pago Servicio | Avenida 100 | Bogota | Bogota | 111111  | 3001234567 | 12001   | 12001         | 5      |
    Then validate success transaction "Bill Payment Complete"