Feature: customers in database

  @getCustomers
  Scenario: get customers
    Given enter the baseUri "https://www.gmibank.com"
    And enter the basePath "/api/tp-customers"
    When get the customers
    Then assert the status code 200

  @addCustomer
  Scenario: add a customer
    Given enter the baseUri "https://www.gmibank.com"
    And enter the basePath "/api/tp-customers"
    When post a new customer
    """
     {
        "id": 36531,
        "firstName": "Yunus Emre",
        "lastName": "Kaya",
        "middleInitial": "JS",
        "email": "jon.snow@example.com",
        "mobilePhoneNumber": "319-015-1814",
        "phoneNumber": null,
        "zipCode": null,
        "address": "829 McLaughlin River, NY 19004-5961",
        "city": null,
        "ssn": "476-90-5332",
        "createDate": null,
        "zelleEnrolled": null,
        "country": null,
        "state": null,
        "user": null,
        "accounts": null
    }
    """
    Then assert the status code 200
    And assert the customer's first name "Yunus Emre"
    And assert the customer's lastname "Kaya"
    And assert the ssn "476-90-5332"

