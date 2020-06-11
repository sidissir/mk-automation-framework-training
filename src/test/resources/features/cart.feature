Feature: To Test Cart functionality
  As a User, I should be able to add,delete and update items to cart so that cart gets updated accordingly

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

  Scenario Outline: To test user registartion

    Given I am on Home Page
    When I click on register
    And I enter "<fname>"
    And I enter "<lname>"
    And I enter "<pwd>"
    And I enter "<address>"
    And i enter register button
    Then user should get created

    Examples: 
      | fname  | lname  | pwd  | address  |
      | fname1 | lname1 | pwd1 | address1 |
      | fname2 | lname2 | pwd2 | address2 |
      | fname3 | lname3 | pwd3 | address3 |

  Scenario Outline: To test user registartion

    Given I am on Home Page
    When I click on register
    And I enter user details of user <user_number>
    And i enter register button
    Then user should get created

    Examples: 
      | user_number |
      |           1 |
      |           2 |
      |           3 |
