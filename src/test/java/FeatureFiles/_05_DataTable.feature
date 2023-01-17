Feature: Datatable Functionality

  Background:
    Given Navigate to campus
    When Enter username and password and click login button
    Then User should login successfully
  Scenario: Create Counrty
    And Click on the element in left nav
        |setupOne|
        |parameters|
        |countries |
    And Click on the element in the dialog
        |addButton|
    And User sending the keys in dialog content
        |nameInput| seads12|
        |codeInput| aseda  |
    And Click on the element in the dialog
        |saveButton|
    Then Success message should be displayed
    And User delete item from dialog
        |seads12|
    Then Success message should be displayed
    Scenario: Create a fee
      And Click on the element in left nav
        |setupOne|
        |parameters|
        |feesSetup |
      And Click on the element in the dialog
        |addButton|
      And User sending the keys in dialog content
        |nameInput| seads12|
        |codeInput| 12344569  |
        |integrationCode| 12399  |
        |priorityCode |  120546   |

      And Click on the element in the dialog
        |toggleBar|
        |saveButton|
      Then Success message should be displayed
      And User delete item from dialog
        |seads12|
      Then Success message should be displayed
      #    Senaryo Outline da verilen değerler için tüm senaryo her satır kadar tekrar çalıştırılıyordu.
    #    DataTable da ise, sadece ilgili step için toplu veri gönderme imkanı oluşuyor.