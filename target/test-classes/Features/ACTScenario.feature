Feature: ACT Scenario feature file
 Scenario Outline: ACT Round2 Scenario
    Given valid registered email and password in <row_number> row 
    And clicked on SignIn
    Then login should be successfull
    When clicked My addresses
    Then addresses page should be navigated successfully
    When clicked Add New Addresses
    Then Add address pages should be displayed
    When user fills all fields from <row_number> with new data and click on save 
    Then my address page should be displayed
    When clicked on women and selected summer dresses
    Then summer dresses page should be opened
    Then change view to list view
    And add 3 items to cart
    When clicked on checkout
    Then order page should be opened
		Then complete the order 
		When clicked on username
		Then acoount details should be opened
		When clicked order history and details
		Then order history should be displayed
		When clicked sign out
		Then signIn home page should be displayed
	  
Examples:
	|row_number|
	| 1|