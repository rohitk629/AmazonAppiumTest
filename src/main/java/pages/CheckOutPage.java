package pages;

import org.testng.Assert;

import base.BasePage;
import util.TestUtil;



public class CheckOutPage extends BasePage {

	static BasePage base = new BasePage();

	final String cart_Icon = "//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_cart_image']";

	final String productName_CheckoutPage = "//*[@class='android.view.View' and @bounds='[260,842][990,940]']";

	final String productPrice_CheckoutPage = "//*[@class='android.view.View' and @bounds='[260,940][1045,992]']";

	/*
	 * Compare the expected details of the product to the actual details of the
	 * product Compare the name & price of the product displayed in Checkout page to
	 * the data stored in global variables from search result page
	 */
	public void compareProductDetails() {
		try {
			if (base.isDisplayed(cart_Icon)) {
				base.tapElement(cart_Icon);
				Assert.assertEquals(base.gettext(productName_CheckoutPage), TestUtil.productPriceText);
				Assert.assertEquals(base.gettext(productPrice_CheckoutPage), TestUtil.productPriceText);
			}
		} catch (Exception e) {
			Assert.fail("Expected product details from search result does not match with actual product details in Checkout Page");
		}
	}

	//Closing the application
	public void closeApp() {
		base.close();
	}
}
