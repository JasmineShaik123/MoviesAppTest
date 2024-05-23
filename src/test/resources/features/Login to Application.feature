Feature: Login to Application
  As a user of the movies web page
  I am able to login to my account
  I should be able to redirected to home page of movies page

  Scenario: Test The Login page UI
    Given I am on the login page
    When  Website logo is displayed or not
    And Whether the heading text login is correct or not
    And Whether the Username label text is correct or not
    And Whether the Password label text is correct or not
    And Whether the Login text Of login button is correct or not
    Then close the driver

  Scenario: Test the Login Page Functionalities
    Given I am on the Login page
    When Test the login with empty input fields
    And  Test the login with empty USERNAME
    And  Test the login with an empty PASSWORD
    And  Test the login with invalid credentials
    And  Test the login with valid CREDENTIALS
    Then close the driver1