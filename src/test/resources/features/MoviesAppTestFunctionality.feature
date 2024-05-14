Feature: MoviesAppTestFunctionality
  As a user of MoviesAppApplication
  I want to be login in my account
  so that i can get access of personalized features
  and watch movies

  Scenario: LoginPageTest With Empty Inputs
    Given I am on Login page
    When I click on login button
    Then I got error Message *Username or password is invalid

  Scenario: LoginPageTest With Valid userinput and empty password
    Given I am on Login page
    When I enter valid username
    And I click on login button
    Then I got Error message *Username or password is invalid

  Scenario: LoginPageTest With empty userinput and valid password
    Given I am on Login page
    When I enter valid password
    And I click on login button
    Then I got Error message1 *Username or password is invalid


  Scenario: LoginPageTest With valid userinput and invalid password
    Given I am on Login page
    When I enter valid username and invalid password
    And I click on login button
    Then I got Error message1 *username and password didn't match

  Scenario: LoginPageTest With valid userinput and valid password
    Given I am on Login page
    When I enter valid username and valid password
    And I click on login button
    Then I redirected to home page

  Scenario: HomePageTest To find Heading Elements
    Given I am on Login page
    When I enter valid username and valid password
    And I click on login button
    Then I redirected to home page