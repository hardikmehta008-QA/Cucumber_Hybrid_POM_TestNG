Feature: Home Page Feature

  Background:
    Given user has already logged in to application
      | email                   | pwd    |
      | testauto_45@yopmail.com | Testauto@45 |

Scenario: Verify that user is navigated to home page successfully
    Given verify that Logged in as username is visible
    When user gets the title of the home page
    Then home page title should be "Automation Exercise"

  Scenario: Verify product category section count
    Given verify that product category section is visible on home page
    When user gets the count of product categories
    |WOMEN|
    |MEN|
    |KIDS|
    Then verify that count of product categories is 3