Feature: customers in database

  @getCustomer
  Scenario: get customers
    Given enter the baseUri "https://www.gmibank.com"
    And enter the basePath "/api/tp-customers"
    When get the customers
    Then assert the status code 200

