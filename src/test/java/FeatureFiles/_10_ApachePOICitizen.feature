Feature: ApachePoi Citizen Func
  Background:
    Given Navigate to campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenship page

    Scenario: Create citizenship from excel
      When User create citizenship with ApachePOI

      Scenario: Delete citizenship from excel
        When User delete citizenship with ApachePOI