
@tag
Feature: 
Placing order from Ecommerce website

Background: Given User launch the URL

  @tag2
  Scenario Outline: Adding Product to the cart and Submitting the order successfully
    Given User enter <username> and <password>
    When User add Product to cart
    And check out the product and place the order
    Then User is logged out successfully

   Examples: 
   
      | username       | password | 
      | nitika@test.com|Test@12345|   
     
    
    

  
 

  
