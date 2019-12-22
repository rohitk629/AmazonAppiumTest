package stepDefinitions;

import cucumber.api.java.en.Then;
import pages.CheckOutPage;

public class CheckoutPageSteps {
	
	CheckOutPage checkout = new CheckOutPage();
	

	@Then("I navigate to checkout screen and compare the displayed product details to the stored product details")
	public void i_navigate_to_checkout_screen_and_compare_the_displayed_product_details_to_the_stored_product_details() {
		checkout.compareProductDetails();
	}
	
	@Then("I close the application")
	public void i_close_the_application() {
		checkout.closeApp();
	}

}
