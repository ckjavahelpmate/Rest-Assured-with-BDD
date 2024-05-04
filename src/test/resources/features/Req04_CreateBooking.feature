Feature: Create Booking

  Scenario Outline: Create Booking
    Given header param <headerParam> with value <headerParamValue>
    And header param "Cookie" with value "token"
    And body param from file <fileName>
    When I do POST request with URL <url>
    Then I validate the status code is <statusCode>
    And store value of key "bookingid"
    And print response
    And print value of key "token" on console


    Examples:
      | headerParam    | headerParamValue   | fileName             | url       | statusCode |
      | "Content-type" | "application/json" | "createBooking.json" | "booking" | 200        |