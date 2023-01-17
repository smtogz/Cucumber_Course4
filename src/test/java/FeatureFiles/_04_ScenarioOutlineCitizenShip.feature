Feature: Citizenship Scenario

  Background:
    Given Navigate to campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to citizenship page

  @Regression
  Scenario Outline: Create Citizenship
    When Create a citizenship name as "<Name>" shortName as "<Shortname>"
    Then Success message should be displayed

    When Create a citizenship name as "<Name>" shortName as "<Shortname>"
    Then Already exits message should be displayed

    When User should delete a citizenship name as "<Name>" shortName as "<Shortname>"
    Then Success message should be displayed

    Examples:
      | Name  | Shortname|
      | Onem2 | Onem5    |
      | Onem3 | Onem6    |
      | Onem4 | Onem7    |
