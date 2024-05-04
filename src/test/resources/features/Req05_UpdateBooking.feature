Feature: Update Booking

  Scenario: Update Booking

    And body param from file "createBooking.json"
    And path param "bookingid" with data value
    Given header param "Content-type" with value "application/json"
    Given header param "Accept" with value "application/json"
    Given header param "Cookie" with value "token"
    When I do PUT request with URL "booking/{bookingid}"
    Then I validate the status code is 200
    And print response


