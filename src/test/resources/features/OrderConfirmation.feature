Feature: Swag Lab Order Confirmation Test
  Scenario: fill the Checkout form
    Given I am in the Checkout form page
    When I am filling the Checkout form and proceed
    Then I should see theOverview page
    And I should see the message