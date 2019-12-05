package pages;

import org.openqa.selenium.Keys;

import base.BasePage;

public class SearchPage extends BasePage  {
	
	static BasePage base = new BasePage();
	
	final String searchBar = "//android.widget.LinearLayout[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_plate']";
	
	final String productToBeSelected = "//android.view.View[@text=' Sony 55\" X70F Smart LED 4K Ultra HDR TV ']";
	
	
	// Enter the data '65-inch TV' in the search bar
	public void enterProductNameInSearchBar(String[][] formData) {
		// TODO Auto-generated method stub
		base.populateFields(searchBar, formData[0][0]);
		base.getElement(searchBar).sendKeys(Keys.ENTER);
	}


	public void selectRandomItemFromList() {
		// TODO Auto-generated method stub		
		base.scrollAndClickAnElement(productToBeSelected);
		
	}

}
