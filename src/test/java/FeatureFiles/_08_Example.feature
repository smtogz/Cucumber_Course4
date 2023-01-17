Feature: Example for outline

  Background:
    Given Navigate to campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Create a fee
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | feesSetup  |
    And Click on the element in the dialog
      | addButton |
    And User sending the keys in dialog content
      | nameInput       | <Name>  |
      | codeInput       | <Code>  |
      | integrationCode | <Icode> |
      | priorityCode    | <Pcode> |

    And Click on the element in the dialog
      | toggleBar  |
      | saveButton |
    Then Success message should be displayed
    And User delete item from dialog
      | <Name> |
    Then Success message should be displayed
    Examples:
      | Name     | Code | Icode | Pcode |
      | fruktoz  | 9999 | 90009 | 8909  |
      | seluloz  | 9899 | 80009 | 8809  |
      | emprio   | 9799 | 70009 | 8709  |
      | states   | 9699 | 60009 | 8609  |
      | korkusuz | 9599 | 50009 | 8509  |