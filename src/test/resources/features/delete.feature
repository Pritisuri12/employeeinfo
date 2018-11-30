@delete
Feature: Delete the selected employee from the list
  Scenario: Able to delete the employee detail
    Given that I am logged in
    And I select first employee
    And able to see the delete button
    When I click on delete button
    Then it shows warning message
    Then accept the alert and detail is deleted from the list

    Scenario: Able to cancel the delete of the employee infomation
      Given that I am logged in
      And I select first employee
      And able to see the delete button
      When I click on delete button
      Then it shows warning message
      Then delete request can cancelled by click the cancel
