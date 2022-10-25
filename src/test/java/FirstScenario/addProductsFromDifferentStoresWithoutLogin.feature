Feature: Feature to test adding products
  Background: navigate to form page
    Given navigate to website
  Scenario: tests to add product from different stores
    And type product name
    And search product
    And choose a product
    And add product to cart
    And add same product from another store to cart
    And navigate to cart page
    Then confirm chosen products are on cart page