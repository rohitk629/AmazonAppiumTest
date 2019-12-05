package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.BasePage;
import util.TestUtil;

public class CheckOutPage extends BasePage {
	
	static BasePage base = new BasePage();
	
	final String cart_Icon =  "//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_cart_image']";
	
	final String productName_CheckoutPage = "//android.view.View[@resource-id='sc-item-C6ffa6213-4ffe-499e-ace3-543f66d13bbb']/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.Image]";

	final String productPrice_CheckoutPage = "//android.view.View[@resource-id='sc-item-C6ffa6213-4ffe-499e-ace3-543f66d13bbb']/android.view.View[1]/android.view.View[1]/android.view.View[3]/aandroid.widget.ListView/android.view.View[1]]";
	
	public void compareProductDetails() {
		// TODO Auto-generated method stub
		if(base.isDisplayed(cart_Icon)) {
			base.tapElement(cart_Icon);
		}
		
		Assert.assertEquals(base.gettext(productName_CheckoutPage), TestUtil.productPriceText);
		Assert.assertEquals(base.gettext(productPrice_CheckoutPage), TestUtil.productPriceText);
	
	}

	// Closing the application
	public void closeApp() {
		// TODO Auto-generated method stub
		base.close();
	}
	

}
