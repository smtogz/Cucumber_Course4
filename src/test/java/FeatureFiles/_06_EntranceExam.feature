Feature: Entrance Exam Functionality

  Background:
    Given Navigate to campus
    When Enter username and password and click login button
    Then User should login successfully


    Scenario: Entrance Exam
      And Click on the element in left nav
        |entranceExamsOne|
        |setupTwo|
        |entranceExamsTwo |
      And Click on the element in the dialog
        |addButton|
      And User sending the keys in dialog content
        |nameInput| seads12|
      And Select on the element in form content
        |academicPeriod|
        |gradeLevel|
      And Click on the element in the dialog
        |saveButton|
      Then Success message should be displayed
      And Click on the element in left nav
        |entranceExamsOne|
        |setupTwo|
        |entranceExamsTwo |
      And User delete item from dialog
        |seads12|
      Then Success message should be displayed