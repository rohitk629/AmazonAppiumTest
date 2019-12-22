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
		login.verifyLandingScreen();
	}
	
	@Given("I tap on Signin button and navigate to Login screen")
	public void i_tap_on_Signin_button_and_navigate_to_Login_screen() throws IOException {
		login.clickSignInBtn();
		
	}

	@Given("I enter valid login credentials from excel sheetname {string}")
	public void i_enter_valid_login_credentials_from_excel_sheetname(String testData) throws IOException {
		String[][] formData =  StaticProvider.getExcelData(testData);  // Passing testData as "Login_Success" from feature file
		login.populateLoginFields(formData);
	}

	@When("I tap on submit button")
	public void i_tap_on_submit_button() {
		login.clickSubmitButton();
	}

}