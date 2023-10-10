#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Test Login Page 
  I want to use this template for my feature file


  Scenario: Login application with valid credentials
    Given User can access application
    And Login with valid username <name> and password <password>
    Then User should see products

    Examples: 
      | name 								| password  |
      | adityatest@test.com | Test@123  |


  Scenario: Login application with invalid credentials
    Given User can access application
    And Login with valid username <name> and password <password>
    Then User should be unsuccessful

    Examples: 
      | name 								| password  |
      | adityatest@test.com | ssdfsdff  |
