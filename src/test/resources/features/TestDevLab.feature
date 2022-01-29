@TestDevLab
Feature: TestDevLab Clicking Checkboxes
  Background:
    Given The user clicks Part 4

  @case1
  Scenario: User tries to click correctly for required checkboxes
    And The user selects all checkboxes in first section
    And The user selects correct checkboxes in second section
    And The user slides down to get in third section
    And The user selects correct checkboxes in third section
    And The user clicks Submit button
    Then The user should see Success messages for all sections
#    And The user opens Baby Care category
#    And The user opens any product on Baby Care category
#    And The user adds the product into the basket
#    And The user gets back to Baby Care category
#    And The user opens Snacks category
#    And The user opens any product on Snacks category
#    And The user adds the product into the basket
#    And The user gets back to Snacks category
#    And The user goes to basket and controls the prices and products
#    And The user deletes all products in the basket
#@case2
#    Scenario: Case 2
#      Given The user turns back to homepage
#      Then The user makes sure homepage is open
#      Then The user checks the number of categories
#      And The user opens a random category
#      And The user adds 3 random product into the wishlist in that category
#      And The user goes to my profile section
#      And The user clicks My Wishlist
#      And The user controls the products and the prices
#      And The user deletes all products in the wishlist