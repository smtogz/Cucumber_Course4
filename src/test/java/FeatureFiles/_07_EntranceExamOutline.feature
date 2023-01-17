Feature: Entrance Exam Functionality

  Background:
    Given Navigate to campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Entrance Exam
    And Click on the element in left nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |
    And Click on the element in the dialog
      | addButton |
    And User sending the keys in dialog content
      | nameInput | <ExamName> |
    And Select on the element in form content
      | academicPeriod         |
      | <academicPeriodOption> |
      | gradeLevel             |
      | <gradeLevelOption>     |
    And Click on the element in the dialog
      | saveButton |
    Then Success message should be displayed
    And Click on the element in left nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |
    And User delete item from dialog
      | <ExamName> |
    Then Success message should be displayed
    Examples:
      | ExamName         | academicPeriodOption | gradeLevelOption |
      | Math exam vize 1 | 1                    | 2                |
      | Fiz exam vize 1  | 1                    | 3                |
      | Kim exam vize 1  | 1                    | 4                |
      | Bio exam vize 1  | 1                    | 5                |
