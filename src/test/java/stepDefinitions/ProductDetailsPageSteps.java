package stepDefinitions;

import cucumber.api.java.en.Then;
import pages.ProductDetailsPage;

public class ProductDetailsPageSteps {

	ProductDetailsPage product = new ProductDetailsPage();

	@Then("I save the name and cost of the randomly selected product")
	public void i_save_the_name_and_cost_of_the_randomly_selected_product() {
		product.storeProductDetails();
	}
	
	@Then("I add the product to the cart")
	public void i_add_the_product_to_the_cart() {
		product.addProductToCart();
	}

}
