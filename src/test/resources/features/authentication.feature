#As a <user>, when i do <action> ,so that i observe the <behaviour>
Feature: To test ecommerce authentication
  As a user, when i try to register/log in/retrieve credentials, so that i can do corresponding action

	@SmokeTests @AuthenticationTests
  Scenario: To test whether user can navigate to log in page
  	As a user, when i click on Sig In link ,So that i am taken to Log In Page
    Given I am on Home Page
    When I click on Sign In Link
    Then I should be taken to Log In page

