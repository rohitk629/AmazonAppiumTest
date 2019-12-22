package pages;

import org.openqa.selenium.Keys;

import base.BasePage;

public class SearchPage extends BasePage  {
	
	static BasePage base = new BasePage();
	
	final String searchBar = "//android.widget.LinearLayout[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_plate']";
	
	final String productToBeSelected = "//android.view.View[@text='Sony 55\" X70F Smart LED 4K Ultra HDR TV']";
	
	
	// Enter the data '65-inch TV' in the search bar
	public void enterProductNameInSearchBar(String[][] formData) {
		base.populateFields(searchBar, formData[0][0]);
		base.getElement(searchBar).sendKeys(Keys.ENTER);
	}

	// Scroll and click the itemn to be selected
	public void selectRandomItemFromList() {
		try {
			base.scrollAndClickAnElement(productToBeSelected);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
