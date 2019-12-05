package stepDefinitions;

import java.io.IOException;

import cucumber.api.java.en.Then;
import pages.SearchPage;
import reader.StaticProvider;

public class SearchPageSteps {
	
	SearchPage searchPage = new SearchPage();
	
	@Then("I enter a product name in the search bar from the excel sheetname {string}")
	public void i_enter_a_product_name_in_the_search_bar_from_the_excel_sheetname(String testData) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		String[][] formData =  StaticProvider.getExcelData(testData);  // Passing testData as "Login_Success" from feature file
		searchPage.enterProductNameInSearchBar(formData);
	}
	
	
	@Then("I select a random product from the displayed serached product list")
	public void i_select_a_random_product_from_the_displayed_serached_product_list() {
		// Write code here that turns the phrase above into concrete actions
		searchPage.selectRandomItemFromList();
	}
}
