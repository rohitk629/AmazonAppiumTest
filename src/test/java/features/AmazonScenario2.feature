Feature: Login to amazon mobile application and search for an item and add to cart and purchase it 
	As a user of the Amazpn app
 	I want to purchase a 65-inch TV

@scenario
Scenario: Login to amazon mobile application and search for an item and add to cart and purchase it
	Given I launch the amazon app and landing screen appears 
	And I tap on Signin button and navigate to Login screen 
	And I enter valid login credentials from excel sheetname "Login_Success" 
	When I tap on submit button 
	Then I am on dashboard page of the amazon mobile application and verify if hamburger menu button is displayed
	And I tap on Hamburger menu and I press on Settings tab from main menu
	And I selected countries/regions as "Australia" and tap on Done button to navigate to Dashboard page
	Then I enter a product name in the search bar from the excel sheetname "Product_Search"
	And I press and select a random product from the displayed serached prodct list
	Then I save the name and cost of the randomly selected product
	And I add the product to the cart
	And I navigate to checkout screen and compare the displayed product details to the stored product details
	