@regression
Feature: Complete the order by adding a product
  I want to use this template for my feature file

	@smoke
  Scenario: Login application with valid credentials
    Given User logged into portal with <username> and <password>
    When User adds to cart the cart <productName>
    And User clicks on checkout
    And User adds country <country>
    Then clicking on Place Orders should complete the order

    Examples: 
      | username            | password | productName | country 		|
      | adityatest@test.com | Test@123 | ZARA COAT 3 |   Ind		  |