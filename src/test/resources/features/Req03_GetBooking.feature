Feature: Get Booking

  Scenario Outline: Get Booking
    When I do GET request with URL <url>
    Then I validate the status code is <statusCode>
    And print response

    Examples:
      | url         | statusCode |
      | "booking/2" | 200        |