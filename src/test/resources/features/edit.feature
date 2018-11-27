@edit
Feature: Edit the information of the employee
  Scenario: Able to edit the information of the employee
    Given that I am logged in
    And click on the name of first employee
    And  able to see the Edit button
    And click on edit button
    And able to add sar name of that employee "JoJO"
    When I click on save button
    Then information of employee is saved


    @negativecase
    Scenario:Enter wrong format in the name
      Given that I am logged in
      And click on the name of first employee
      And able to see the Edit button
      And click on edit button
      And enter the sar name "&&&&&"
      When I click on save button
      Then I will get warnning message