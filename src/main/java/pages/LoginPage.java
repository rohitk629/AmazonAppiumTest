package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import base.BasePage;

public class LoginPage extends BasePage {

	static BasePage base = new BasePage();

	// Declaring all the xpaths of the required elements available on Landing and
	// Login screens

	final static String splashAmazonLogo = "//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/sso_splash_logo']";

	final static String signInBtn = "//android.widget.Button[@resource-id='com.amazon.mShop.android.shopping:id/sign_in_button']";

	final static String loginRadioButton = "//android.view.View[@resource-id='login_accordion_header']";

	final static String userName = "//android.widget.EditText[@resource-id='ap_email_login']";

	final static String password = "//android.widget.EditText[@resource-id='ap_password']";

	final static String continueButton = "//android.widget.Button[@resource-id='continue']";

	final static String submitButton = "//android.widget.Button[@resource-id='signInSubmit']";

	final static String[] fields = { userName, password };

	// Validate if Amazon logo and Sign In buttons are displayed on Landing Page
	public void verifyLandingScreen() {
		// TODO Auto-generated method stub
		System.out.println("Driver is ::: " + driver);
		Assert.assertTrue(base.isDisplayed(splashAmazonLogo));
		Assert.assertTrue(base.isDisplayed(signInBtn));

	}

	// To click on a button 'Already a customer? Sign in'
	public void clickSignInBtn() {
		// TODO Auto-generated method stub
		if (base.isDisplayed(signInBtn)) {
			base.tapElement(signInBtn);
		} else {
			Assert.assertNull(base.getElement(signInBtn), "Sign in button is not clicked");
		}
	}

	// To enter the excel data into email and password fields
	public void populateLoginFields(String[][] formData) {
		// TODO Auto-generated method stub

		// Check if login radio button is selected, if not then click on the radio button
		if (!base.isSelected(loginRadioButton)) {
			base.tapElement(loginRadioButton);
		}
		
		base.populateFields(userName, formData[0][0]);  // Enter the data in login field
		
		if (base.isDisplayed(continueButton) && base.checkEnabled(continueButton)) {
			base.tapElement(continueButton);
		}
		
		base.populateFields(password, formData[0][1]);  // Enter the data in password field

	}

	// Click Submit button
	public void clickSubmitButton() {
		// TODO Auto-generated method stub
		System.out.println("Inside submit button");
		if (base.isDisplayed(submitButton)) {
			base.tapElement(submitButton);
		} else {
			Assert.assertNull(base.getElement(submitButton), "Submit button is not clicked");
		}
	}

}
