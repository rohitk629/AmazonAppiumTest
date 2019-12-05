package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("deprecation")
public class BasePage {

	protected static AppiumDriver<MobileElement> driver;
	
	public Properties prop;
	
	protected String backButton = "//android.widget.ImageButton[@content-desc = 'Navigate up']";

	protected static WebDriverWait wait;
	
	public BasePage() {
		this.driver = driver;
//		this.wait = new WebDriverWait(driver, DRIVER_WAIT_TIME);
	}
	
	public void resetApp() {
		driver.resetApp();
		System.out.println("Resetting the app");
		wait = new WebDriverWait(driver, 30);
	}
	/**
	 * Close the app which was provided in the capabilities at session creation
	 */
	public void close() {
		try {
			driver.quit();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Runs the current app as a background app for the number of seconds
	 *            Number of seconds to run App in background
	 */
	public void runAppInBackground(Duration seconds){
		driver.runAppInBackground(seconds);
	}



	/**To hide the keyboard
	 * in the app**/
	public void hideKeyboard() {
		try {
			driver.hideKeyboard();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public boolean isAlertPresent(){
		boolean foundAlert = false;
		new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

	//To verify if keypad is open
	public boolean isKeyBoardOpen(){
		Keyboard Element = driver.getKeyboard();
		boolean isOpen = false;
		if(Element != null){
			isOpen = true;
		}
		return isOpen;
	}

	/**Long press on a element
	 * to view sub-options**/
	public void longPress(LongPressOptions element){
		TouchAction action = new TouchAction(driver);
		action.longPress(element).release().perform();
	}




	public void tapElementJsExec(String element){

		MobileElement ele = driver.findElement(By.xpath(element));
		Point p = ele.getLocation();
		Dimension size = ele.getSize();
		double x = p.getX() + size.getWidth() / 2.0;
		double y = p.getY() + size.getHeight() / 2.0;
		HashMap<String , Double> point = new HashMap<String , Double>();
		point.put("x" , x);
		point.put("y" , y);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("mobile: tap", point);
	}


	public boolean allowPermissionPopup() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		try {
			By allowXpath = By.xpath("//*[@text='Allow']");
			WebElement acceptElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(allowXpath));
			acceptElement.click();
			acceptElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(allowXpath));
			acceptElement.click();
			return true;
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void tapOnBackButton() {
		MobileElement ele = driver.findElement(By.xpath(backButton));
		waitForElementToBeClickable(ele);
		ele.click();
	}


	/**
	 * Takes snapshot
	 * 
	 * @param filename(String) filename of the snapshot
	 */
	public void takeScreenShot(String filename) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile, new File(
					System.getProperty("user.dir") + "/Screenshots/" + filename + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Get element text
	public String getTexts(WebElement element) {
		String text = element.getText();
		return text;
	}

	// To verify that the checkBox is selected or not
	public boolean isSelected(String xpath) {
		MobileElement element = driver.findElement(By.xpath(xpath));
		boolean isSelected = false;
		if (element != null) {
			isSelected = element.isSelected();
		}
		return isSelected;
	}

	/**
	 * To Get the selected value from the dropdown
	 * 
	 * @param browser browser instance
	 * @param element
	 * @return
	 */
	public String getDropdownValue(String element) {
		String selectedOption = null;
		WebElement option = driver.findElement(By.xpath(element));
		if (option != null) {
			selectedOption = new Select(option).getFirstSelectedOption().getText();
		}
		return selectedOption;
	}

	/**
	 * To Delete Cookies before loging into the Application
	 */
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
		System.out.println("Deleted all cookies before login to the application");
	}

	/**
	 *
	 * @param locator locator of the element(ie., id/xpath/....)
	 * @param element element on the page
	 * @return PageName
	 */
	public String gettext(String element) {
		String text = null;
		WebElement Element = driver.findElement(By.xpath(element));
		if (Element != null) {
			text = Element.getText();
		}
		return text;
	}

	// To get text based on attribute(EX: id,src, value...)
	public String gettext(String element, String attribute) {
		String value = null;
		WebElement Element = driver.findElement(By.xpath(element));
		if (Element != null) {
			value = Element.getAttribute(attribute);
		}
		return value;
	}

	// To get text based on attribute(EX: id,src, value...)
	public String gettexts(WebElement element, String attribute) {
		String value = null;
		// WebElement Element = getElement(XPATH, element)
		if (element != null) {
			value = element.getAttribute(attribute);
		}
		return value;
	}

	// To verify element is enabled
	public boolean checkEnabled(String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		boolean isEnabled = false;
		if (element != null) {
			isEnabled = element.isEnabled();
		}
		return isEnabled;
	}

	// To verify if element is displayed
	public boolean isDisplayed(String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		boolean isDisplayed = false;
		if (element != null) {
			isDisplayed = element.isDisplayed();
		}
		return isDisplayed;
	}

	// To get the text of the lists
	public List<String> getLists(String element) {
		List<String> list = new ArrayList<String>();
		List<MobileElement> lists = driver.findElements(By.xpath(element));
		for (int i = 0; i < lists.size(); i++) {
			String text = lists.get(i).getText();
			list.add(text);
		}
		return list;
	}

	// To get the attribute values
	public List<String> getLists(String element, String value) {
		List<String> list = new ArrayList<String>();
		List<MobileElement> lists = driver.findElements(By.xpath(element));
		for (int i = 0; i < lists.size(); i++) {
			String text = lists.get(i).getAttribute(value);
			list.add(text);
		}
		return list;
	}

	// To get all elements from the list
	public List<MobileElement> getListElements(String element) {
		List<MobileElement> elementList = driver.findElements(By.xpath(element));
//		waitForElementToBeClickable(elementList.get(0));
		return elementList;
	}
	
	
	// Scroll and Click an element
	public void scrollAndClickAnElement(String xpathValue){
		
		MobileElement mobElement = driver.findElement(MobileBy.xpath(xpathValue));
		Point point = mobElement.getLocation();
		int startY = point.y;
		int endY = point.y;

		int startX = (int) ((driver.manage().window().getSize().getWidth()) * 0.80);
		driver.manage().window().getSize().getWidth();

		new TouchAction(driver).press(PointOption.point(startX, startY)).waitAction().moveTo(PointOption.point(startX, endY)).release().perform();

	}

	/**
	 * Selects from drop down based on value
	 * 
	 * @param String
	 * @param String
	 */
	public void selectDropdownValue(String element, String value) {

		boolean flag = false;
		try {
			WebElement dropDownListBox = driver.findElement(By.xpath(element));
			List<WebElement> lists = dropDownListBox.findElements(By.tagName("option"));
			// delay(1000)
			for (int i = 0; i <= lists.size() - 1; i++) {
				String dropdownValue = lists.get(i).getText().trim();
				if (value.equals(dropdownValue)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				value = "Select";
			}
			if (dropDownListBox != null) {
				Select clickThis = new Select(dropDownListBox);
				clickThis.selectByVisibleText(value);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Unable to select list item from the dropdown");
		}
	}

	/**
	 * To select through index from a dropdown
	 */
	public void selectOptionFromDropdown(String element, int indexvalue) {
		WebElement mySelectElm = driver.findElement(By.xpath(element));
		Select mySelect = new Select(mySelectElm);
		mySelect.selectByIndex(indexvalue);
	}

	public MobileElement getElement(String Xpath) {
		MobileElement element = driver.findElement(By.xpath(Xpath));
		System.out.println("ele:: "+element);
		return element;

	}

	public void populateFields(String element, String text) {
		WebElement elem = driver.findElement(By.xpath(element));
		waitForElementToBeClickable(elem);
		elem.click();
		if (text != null) {
			if (!elem.getText().isEmpty()) {
				elem.clear();
			}
			elem.sendKeys(text);
		} else {
			Assert.assertNotNull(elem.getText());
		}
	}

	public void tapElement(String element) {
		MobileElement ele = driver.findElement(By.xpath(element));
		waitForElementToBeClickable(ele);
		driver.findElement(By.xpath(element)).click();
	}

	// To click an element
	public void tapMobileElement(WebElement element) {
		waitForElementToBeClickable(element);
		element.click();
	}

	public void waitForElementToBeVisible(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForElementToBeVisible(By by, int timeout) {
		wait = new WebDriverWait(driver, timeout);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {

		}
	}

	public WebElement waitForElementToBeVisible(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeSelected(WebElement element) {
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}

	public void waitForElementToBeRefreshed(WebElement element) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}

	public void waitForElementToBeRefreshed(By by) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
	}

	public void waitForElementToBeClickable(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public WebElement waitForPresenceOfElement(By by) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitForPresenceOfAllElements(By by) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}

	public void waitForInvisibilityOfElementByText(By by, String text) {
		wait.until(ExpectedConditions.invisibilityOfElementWithText(by, text));
	}

	public void waitForElementToBeInvisible(By by) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitForElementToBeChecked(WebElement element) {
		wait.until(elementToBeChecked(element));
	}

	private ExpectedCondition<WebElement> elementToBeChecked(final WebElement element) {
		return new ExpectedCondition<WebElement>() {

			public ExpectedCondition<WebElement> visibilityOfElement = ExpectedConditions.visibilityOf(element);

			public WebElement apply(WebDriver driver) {
				WebElement element = visibilityOfElement.apply(driver);
				try {
					if (element != null && element.getAttribute("checked").equals("true")) {
						return element;
					} else {
						return null;
					}
				} catch (StaleElementReferenceException e) {
					return null;
				}
			}

			@Override
			public String toString() {
				return "element to be checked : " + element;
			}
		};
	}



}
