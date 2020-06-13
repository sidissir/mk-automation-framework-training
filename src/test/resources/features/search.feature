Feature: To verify search functionality
  As a user, when i search using search box or navigation , so that i am shown with relevant results

	@SmokeTests @SearchTests
  Scenario: To verify search box search functionality 
  	As a user, when i search using keyword from search box, so that i am shown relevant results
  	
  	Given I am on Home Page 
  	When I enter keyword "Summer Dresses" and click search button
  	Then I should be shown relevant results
   