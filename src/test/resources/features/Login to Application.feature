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

  Scenario:Test the Home Page
    Given I entered Home Page
    And Test the heading texts of each section
    And Test whether the play button is displayed or not
    And Test whether the Movies are displayed, in the corresponding movies sections
    And Test the Contact Us Section
    Then Close the browser window

  Scenario: Test the Header Section UI
    Given I am on Header Section Page
    And Test whether the Website logo is displayed or not
    And Test the Navbar elements
    Then Close the browser window.

  Scenario: Test the Header Section Functionalities
    Given I am on Header Section page
    And Test the navigation to the Home and Popular pages through elements in the header section
    And Test the navigation to the account page through elements in the header section
    Then Close the browser Window

  Scenario:Test the Popular Page UI
    Given I am on Popular Page
    And Test whether the movies are displayed
    Then close the Popular Page browser Window

  Scenario:Test the Search Functionality
    Given I am on Search Functionality Page
    And Test the Search functionality by searching with some movie names and the count of movies displayed
    Then Close the Search Functionality browser window

  Scenario:Test the Movie Details Page
    Given I am on movie details page
    And In the Home Page click on any Movie and test all the UI elements present in it
    And In the Popular Page click on any Movie and test all the UI elements present in it
    Then Close the Movie Details browser window

  Scenario:Test the Account Page
    Given I am on Account Page
    And Test all the UI elements present on the web page
    And Test the Logout functionality
    Then Close the Account Page browser window


