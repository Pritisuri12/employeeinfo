@edit @positiveedit
Feature: Edit the information of the employee
  Scenario: Able to edit the name of the employee
    Given that I am logged in
    And click on the name of first employee
    And  able to see the Edit button
    And click on edit button
    And able to add sur name "JoJO"
    When I click on update button
    Then information of employee is saved

  Scenario:Able to edit the date of the join for employee
    Given that I am logged in
    And click on the name of first employee
    And  able to see the Edit button
    And click on edit button
    And able to add new date "2018-10-10"
    When I click on update button
    Then information of employee is saved

  @negativename
  Scenario:Enter blank format in the name
    Given that I am logged in
    And click on the name of first employee
    And able to see the Edit button
    And click on edit button
    And able to add sur name " "
    When I click on update button
    Then I will get warning message

