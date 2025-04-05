Feature: Check Checkout Feature
  Scenario: verify the checkout feature by adding a product in to the cart
    Given I am in the Inventory Page
    And I am sorting the items by their price
    When I add a product in to the cart
    Then I should see the Cart Page

