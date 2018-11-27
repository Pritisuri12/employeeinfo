@view
  Feature: As a employee I should be able to see the information of employee

    Scenario: Able to see the information of selected employee
      Given that I am logged in
      When I double click on the employee name
      Then I should be able to see detailed information
