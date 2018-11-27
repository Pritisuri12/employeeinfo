@logout
  Feature: As a employee I want to logout from application
    Scenario: Able to logout the application
      Given that I am logged in
      And I am able to see the logout button
      When I click on logout button
      Then I am logged out
