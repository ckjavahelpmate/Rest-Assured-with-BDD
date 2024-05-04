Feature: Create AUth token

  Scenario Outline: Create Auth token
    Given body param from file <fileName>
    When I do POST request with URL <url>
    Then I validate the status code is <statusCode>
    And store value of key <key>
    And print value of key <key> on console
    And print response


    Examples:
      | fileName          | url    | statusCode | key     |
      | "authCreate.json" | "auth" | 200        | "token" |