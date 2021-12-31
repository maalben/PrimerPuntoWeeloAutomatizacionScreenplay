Feature: Consume post service

  Description:
  As an automatizer,
  I need to perform service consumption to postman-echo.com through the post method
  to see a successful response.

  @CP010
  Scenario: Consumption of successful post service
    Given Load customer information
      | phone   | name  | email            |
      | 1111111 | Pedro | pedro@correo.com |
    When Call post services API
    Then Should see response post service is success

  @CP011
  Scenario: 200 response status validation with post method
    Given Load customer information
      | phone   | name  | email            |
      | 1111111 | Pedro | pedro@correo.com |
    When Call post services API
    Then Should see status code is 200

  @CP012
  Scenario: Validation of number of fields in the response with post method
    Given Load customer information
      | phone   | name  | email            |
      | 1111111 | Pedro | pedro@correo.com |
    When Call post services API
    Then Should see that quantity fields in the root are 7

  @CP013
  Scenario: Post method response schema validation
    Given Load customer information
      | phone   | name  | email            |
      | 1111111 | Pedro | pedro@correo.com |
    When Call post services API
    Then Should verify schema postService

  @CP014
  Scenario: Field validation of post method response
    Given Load customer information
      | phone   | name  | email            |
      | 1111111 | Pedro | pedro@correo.com |
    When Call post services API
    Then Should see the fields post method response are expected

  @CP015
  Scenario: Validation of field contents and post method values
    Given Load customer information
      | phone   | name  | email            |
      | 1111111 | Pedro | pedro@correo.com |
    When Call post services API
    Then Should see the fields and values in the response post service are expected

  @CP016
  Scenario: Consuming service without parameters in post method
    When Call post services API without parameters
    Then Should see response without parameters success