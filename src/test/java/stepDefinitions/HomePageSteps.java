package stepDefinitions;

import java.io.IOException;

import cucumber.api.java.en.Then;
import pages.HomePage;
import reader.StaticProvider;

public class HomePageSteps {

	HomePage home = new HomePage();

	@Then("I am on dashboard page of the amazon mobile application and verify if hamburger menu button is displayed")
	public void i_am_on_dashboard_page_of_the_amazon_mobile_application_and_verify_if_hamburger_menu_button_is_displayed() {
		home.verifyHomePageLogo();
	}

	@Then("I tap on Hamburger menu and I press on Settings tab from main menu")
	public void i_tap_on_Hamburger_menu_and_I_press_on_Settings_tab_from_main_menu() {
		home.navigateToSettingsTab();
	}

	@Then("I selected countries\\/regions as {string} and tap on Done button to navigate to Dashboard page")
	public void i_selected_countries_regions_as_and_tap_on_Done_button_to_navigate_to_Dashboard_page(String country) {
		home.selectCountyRegion(country);
	}
	
}
