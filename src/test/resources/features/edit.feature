@edit @positiveedit
Feature: Edit the information of the employee
  Scenario: Able to edit the information of the employee
    Given that I am logged in
    And click on the name of first employee
    And  able to see the Edit button
    And click on edit button
    And able to add sur name "JoJO"
    When I click on update button
    Then information of employee is saved

  @negativename
  Scenario:Enter wrong format in the name
    Given that I am logged in
    And click on the name of first employee
    And able to see the Edit button
    And click on edit button
    And able to add sur name "&&&&&"
    When I click on update button
    Then I will get warning message

  @negativedate
  Scenario:Enter wrong format in the date
    Given that I am logged in
    And click on the name of first employee
    And able to see the Edit button
    And click on edit button
    And able to add date "&&&&&"
    When I click on update button
    Then I will get warning message

