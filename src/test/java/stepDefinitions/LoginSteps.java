package stepDefinitions;

import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import reader.StaticProvider;

public class LoginSteps {
	
	LoginPage login = new LoginPage();	
	

	@Given("I launch the amazon app and landing screen appears")
	public void i_launch_the_amazon_app_and_landing_screen_appears() throws IOException  {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Login Steps");
		login.verifyLandingScreen();
	}
	
	@Given("I tap on Signin button and navigate to Login screen")
	public void i_tap_on_Signin_button_and_navigate_to_Login_screen() throws IOException {
		login.clickSignInBtn();
		
	}

	@Given("I enter valid login credentials from excel sheetname {string}")
	public void i_enter_valid_login_credentials_from_excel_sheetname(String testData) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		String[][] formData =  StaticProvider.getExcelData(testData);  // Passing testData as "Login_Success" from feature file
		System.out.println("Excel Data ::: "+formData.toString());
		login.populateLoginFields(formData);
	}

	@When("I tap on submit button")
	public void i_tap_on_submit_button() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("3rd step");
		login.clickSubmitButton();
	}



	@Then("I enter a product name in the search bar from the excel sheetname {string}")
	public void i_enter_a_product_name_in_the_search_bar_from_the_excel_sheetname(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("I press and select a random product from the displayed serached prodct list")
	public void i_press_and_select_a_random_product_from_the_displayed_serached_prodct_list() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("I save the name and cost of the randomly selected product")
	public void i_save_the_name_and_cost_of_the_randomly_selected_product() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("I add the product to the cart")
	public void i_add_the_product_to_the_cart() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("I navigate to checkout screen and compare the displayed product details to the stored product details")
	public void i_navigate_to_checkout_screen_and_compare_the_displayed_product_details_to_the_stored_product_details() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}
}