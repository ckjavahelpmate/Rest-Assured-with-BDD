Feature: Partial Update Booking

  Scenario: Partial Update Booking

    And body param from file "createBooking.json"
    And path param "bookingid" with data value
    Given header param "Content-type" with value "application/json"
    Given header param "Cookie" with value "token"
    When I do PATCH request with URL "booking/{bookingid}"
    Then I validate the status code is 200
    And print response


