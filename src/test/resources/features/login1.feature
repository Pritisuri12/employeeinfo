@login
Feature: As a employee want to login in the application

  Scenario:Able to login in the web page
    Given that I want to login as employee
    When I enter the user name "Luke"
    And password value "Skywalker"
    And click on login button
    Then I should be able to login

  @negativecase

  Scenario: login with wrong username or password
    Given that I want to login as Employee
    When I enter the user name "luke"
    And password value "skywalker"
    And click on login button
    Then I should get warning message
