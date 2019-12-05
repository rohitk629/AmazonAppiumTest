package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CheckOutPage extends BasePage {
	
	//Page Factory - OR:
	@FindBy(xpath="//android.view.View[@text='TCL 163.96 cm (65 inches) 4K Ultra HD Smart Certified Android LED TV 65P8E (Black) (2019 Model)']")
	WebElement CheckOutProductDetail;
	
	//Initializing the Page Objects:
	public CheckOutPage() {}
	
	//Method to validate the details of product in checkout page
	public String validateCheckOutProductDetails() throws InterruptedException {
		return CheckOutProductDetail.getText();
	}
	
	
	
	
	

}
