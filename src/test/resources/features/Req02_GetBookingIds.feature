Feature: Get Booking ids

  Scenario Outline: Get Booking ids
    When I do GET request with URL <url>
    Then I validate the status code is <statusCode>
    And print value of key <key> on console
    And print response


    Examples:
      | url       | statusCode | key     |
      | "booking" | 200        | "token" |