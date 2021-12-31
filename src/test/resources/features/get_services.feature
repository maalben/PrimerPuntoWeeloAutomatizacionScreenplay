Feature: Consume get service

    Description:
    As an automatizer,
    I need to perform service consumption to postman-echo.com through the get method
    to see a successful response.

  @CP001
  Scenario: Consumption of successful service get
    Given Load customer information
      | test     | other    |
      | value    | 34       |
    When Call get services API
    Then Should see response is success

  @CP002
  Scenario: Successful service consumption with multiple parameters with get method
    Given Load customer information
      | test     | other    | var1  |  var2  |  var3  |
      | value    | 34       |   1   |   2    |   3    |
    When Call get services API
    Then Should see response with multiples parameters is success

  @CP003
  Scenario: 200 response status validation with get method
    Given Load customer information
      | test     | other    |
      | value    | 34       |
    When Call get services API
    Then Should see status code is 200

  @CP004
  Scenario: Validation of number of fields in the response with get method
    Given Load customer information
      | test     | other    |
      | value    | 34       |
    When Call get services API
    Then Should see that quantity fields in the root are 3

  @CP005
  Scenario: Get method response schema validation
    Given Load customer information
      | test     | other    |
      | value    | 34       |
    When Call get services API
    Then Should verify schema getService

  @CP006
  Scenario: Field validation of get method response
    Given Load customer information
      | test     | other    |
      | value    | 34       |
    When Call get services API
    Then Should see the fields get method response are expected

  @CP007
  Scenario: Validation of field contents and get method values
    Given Load customer information
      | test     | other    |
      | value    | 34       |
    When Call get services API
    Then Should see the fields and values in the response get service are expected

  @CP008
  Scenario: Consuming service without parameters in get method
    When Call get services API without parameters
    Then Should see response without parameters success

  @CP009
  Scenario: 404 response status validation with get method
    When Call services API with method not known
    Then Should see status code is 404