Feature: To Test Cart functionality
  As a User, I should be able to add,delete and update items to cart so that cart gets updated accordingly
	
	@IntegrationTests
  Scenario Outline: To test items can be added to cart
    As a user , when i add items to cart, so that cart gets updated with items

    Given I am on Home Page
    When I move to "Dresses" in top category menu
    And I choose "<subcategory>" in sub menu
    And I add first item to the cart
    Then Cart should have added item

    Examples: 
      | subcategory     |
      | SUMMER DRESSES  |
      | CASUAL DRESSES  |
      | EVENING DRESSES |

 