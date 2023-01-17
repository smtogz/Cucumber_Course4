Feature: Testing JDBC States

  Background:
    Given Navigate to campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: States testing with JDBC
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | states     |
    Then Send The query the database "select * from states" and control match