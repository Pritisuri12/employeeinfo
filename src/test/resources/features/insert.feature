@create
Feature: Employee can be added in the list

  Scenario: Able to insert the information of employee in the list
    Given  that I am logged in
    And I am able to see the create button
    When I click on the create button
    And I inserted first name "TestQA"
    And entered last name is "Engineer"
    And entered start date "2018-08-10"
    And entered email id "abc@testqa.com"
    When I click on add button
    Then the new employee is added in the list

    @emptyname
    Scenario: Try to save empty name
      Given  that I am logged in
      And I am able to see the create button
      When I click on the create button
      And I inserted first name ""
      And entered last name is "Engineer"
      And entered start date "2018-08-10"
      And entered email id "abc@testqa.com"
      When I click on add button
      Then the data is not save in the list