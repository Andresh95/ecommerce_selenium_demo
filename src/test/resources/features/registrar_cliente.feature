Feature: As a demo app user.
  I want to create a client


  Scenario: create new account
    When i fill out the form
      | FirstName | LastName | Address     | City   | State  | ZipCode | Phone      | SSN  | Username | Password | Confirm |
      | Andres    | Hincapie | Avenida 100 | Bogota | Bogota | 11111   | 3001234567 | 7009 | admin    | 123456   | 123456  |
    Then the client is created