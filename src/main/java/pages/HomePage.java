package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.BasePage;

public class HomePage extends BasePage {

	static BasePage base = new BasePage();

	/*
	 * public HomePage(BasePage base) { this.base = base; }
	 */

	final String homePageLogo = "//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_home_logo']";

	final String hamburgerMenu = "//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_burger_icon']";

	final String settingsTab = "//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/drawer_item_title'][@text='Settings']";

	final String country_languages_Tab = "//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/drawer_item_title'][@text='Country & Language']";

	final String selectCountry_Region = "//android.view.View[@resource-id='landing-countryButton']/android.view.View[1]/android.widget.Button[1]";

	final String selectAustralia = "//android.widget.RadioButton[@resource-id='pref-option-group-primary-opt-0']";

	final String doneButton = "//android.widget.Button[@text='Done']";


	// Method to verify logo on Home page of application
	public void verifyHomePageLogo() {
		Assert.assertTrue(base.isDisplayed(homePageLogo), "Amazon logo is displayed in the Home Page");
		Assert.assertTrue(base.isDisplayed(hamburgerMenu), "Hamburger menu is displayed in the Home Page");
	}

	// Click on hamburger menu and navigate to settings page
	public void navigateToSettingsTab() {
		if (base.isDisplayed(hamburgerMenu)) {
			base.tapElement(hamburgerMenu);
			if (base.isDisplayed(settingsTab)) {
				base.tapElement(settingsTab);
			} else {
				Assert.assertNull(base.isDisplayed(settingsTab), "Setting tab element is not visible");
			}
		} else {
			Assert.assertNull(base.isDisplayed(hamburgerMenu), "HamburgerMenu element is not visible");
		}
	}

	// Select Australia as a country
	public void selectCountyRegion(String country) {
		if (base.isDisplayed(country_languages_Tab)) {
			base.tapElement(country_languages_Tab);
			if (base.isDisplayed(selectCountry_Region)) {
				base.tapElement(selectCountry_Region);
				base.tapElement(selectAustralia);

				if (base.isDisplayed(doneButton)) {
					base.tapElement(doneButton);
				}
			}
		} else {
			Assert.assertNull(base.isDisplayed(country_languages_Tab), "Country/Region tab element is not visible");
		}
	}


	
}
