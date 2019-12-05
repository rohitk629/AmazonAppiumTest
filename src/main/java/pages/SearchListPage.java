package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class SearchListPage extends BasePage {

	// Page Factory - OR:
	@FindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	WebElement SearchTextBox;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"TCL 163.96 cm (65 inches) 4K Ultra HD Smart Certified Android LED TV 65P8E (Black) (2019 Model),image\"]")
	WebElement Product;

	// Initializing the Page Objects:
	public SearchListPage() {
	}

	// Actions:
	// Method to scroll down in search list page
	public void selectProductusingScroll() {

	}

	// Method to click on desied product from search list
	public ProductDetailsPage fetchingProduct() throws InterruptedException {

		Product.click();
		Thread.sleep(5000);
		return new ProductDetailsPage();
	}

}
