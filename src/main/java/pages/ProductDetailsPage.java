package pages;

import org.testng.Assert;

import base.BasePage;
import util.TestUtil;

public class ProductDetailsPage extends BasePage {
	
	static BasePage base = new BasePage();
	
	
	
	
	final String productName = "//android.view.View[@resource-id='title']";
	
	final String seeAllBuyingOption = "//android.widget.Button[@text='See All Buying Options']";
	
	final String productPrice = "//android.view.View[@resource-id='price']";
	
	final String addToCart = "//android.widget.Button[@resource-id='add_to_cart/rs_cart']";
	
	

	public void storeProductDetails() {
		// TODO Auto-generated method stub
		
		//Storing the name of product into a global variable
		String nameOfProduct = base.gettext(productName);
		TestUtil.productNameText = nameOfProduct;
		
		if(base.isDisplayed(seeAllBuyingOption)) {
			base.tapElement(seeAllBuyingOption);
		} else {
			Assert.assertTrue(base.isDisplayed(seeAllBuyingOption), "See all buying option is not available");
		}
		
		//Storing the name of product into a global variable
		String priceOfProduct = base.gettext(productPrice);
		TestUtil.productPriceText = priceOfProduct;
		
		
	}



	public void addProductToCart() {
		// TODO Auto-generated method stub
		if(base.isDisplayed(addToCart)) {
			base.tapElement(addToCart);
		} else {
			Assert.assertTrue(base.isDisplayed(addToCart), "Add to cart option is not available");
		}
	}



}
