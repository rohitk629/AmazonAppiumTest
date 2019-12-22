package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
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
	}

	/**
	 * To reset the app after completion of a scenario
	 */
	public void resetApp() {
		try {
			driver.resetApp();
			wait = new WebDriverWait(driver, 30);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	 * Runs the current app as a background app for the number of seconds Number of
	 * seconds to run App in background
	 */
	public void runAppInBackground(Duration seconds) {
		try {
			driver.runAppInBackground(seconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To hide the keyboard in the app
	 **/
	public void hideKeyboard() {
		try {
			driver.hideKeyboard();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	// To verify if keypad is open
	public boolean isKeyBoardOpen() {
		Keyboard Element = driver.getKeyboard();
		boolean isOpen = false;
		try {
			if (Element != null) {
				isOpen = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isOpen;
	}

	/**
	 * Long press on a element to view sub-options
	 **/
	public void longPress(LongPressOptions element) {
		TouchAction action = new TouchAction(driver);
		try {
			action.longPress(element).release().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * TO allow the permission pop-up
	 **/
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
		try {
			waitForElementToBeClickable(ele);
			ele.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		try {
			if (element != null) {
				isSelected = element.isSelected();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSelected;
	}

	/**
	 * To Get the selected value from the dropdown
	 * 
	 * @param element
	 * @return
	 */
	public String getDropdownValue(String element) {
		String selectedOption = null;
		WebElement option = driver.findElement(By.xpath(element));
		try {
			if (option != null) {
				selectedOption = new Select(option).getFirstSelectedOption().getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectedOption;
	}

	/**
	 * To Delete Cookies before loging into the Application
	 */
	public void deleteCookies() {
		try {
			driver.manage().deleteAllCookies();
		} catch (Exception e) {
			Assert.fail("Not able to delete cookies");
		}
	}

	/**
	 *
	 * @param locator locator of the element(ie.xpath)
	 * @param element element on the page
	 */
	public String gettext(String element) {
		String text = null;
		WebElement Element = driver.findElement(By.xpath(element));
		try {
			if (Element != null) {
				text = Element.getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * To get text based on attribute(EX: id,src, value...) *
	 * 
	 * @param element   locator of the element(ie.xpath)
	 * @param attribute element on the page
	 */
	public String gettext(String element, String attribute) {
		String value = null;
		WebElement Element = driver.findElement(By.xpath(element));
		try {
			if (Element != null) {
				value = Element.getAttribute(attribute);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * To get text based on attribute(EX: id,src, value...)
	 * 
	 * @param element   WebElement of locator
	 * @param attribute element on the page
	 */
	public String gettexts(WebElement element, String attribute) {
		String value = null;
		// WebElement Element = getElement(XPATH, element)
		try {
			if (element != null) {
				value = element.getAttribute(attribute);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	// To verify element is enabled
	public boolean checkEnabled(String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		boolean isEnabled = false;
		try {
			if (element != null) {
				isEnabled = element.isEnabled();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isEnabled;
	}

	// To verify if element is displayed
	public boolean isDisplayed(String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		boolean isDisplayed = false;
		try {
			if (element != null) {
				isDisplayed = element.isDisplayed();
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	/**
	 * To get all elements from the list
	 * 
	 * @param String xpath
	 */
	public List<MobileElement> getListElements(String element) {

		List<MobileElement> elementList = null;
		try {
			elementList = driver.findElements(By.xpath(element));
//		waitForElementToBeClickable(elementList.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementList;
	}

	/**
	 * Scroll and Click an element
	 * 
	 * @param String xpath
	 */
	public void scrollAndClickAnElement(String xpathValue) {

		MobileElement mobElement = driver.findElement(MobileBy.xpath(xpathValue));
		try {
			if (mobElement != null) {
				Point point = mobElement.getLocation();
				int startY = point.y;
				int endY = point.y;

				int startX = (int) ((driver.manage().window().getSize().getWidth()) * 0.80);
				driver.manage().window().getSize().getWidth();
				new TouchAction(driver).press(PointOption.point(startX, startY)).waitAction()
						.moveTo(PointOption.point(startX, endY)).release().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Selects from drop down based on value
	 * 
	 * @param String xpath
	 * @param String value of the text
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
			e.printStackTrace();
		}
	}

	/**
	 * To select through index from a dropdown*
	 * 
	 * @param String  xpath
	 * @param Integer index of the element to be selected
	 */
	public void selectOptionFromDropdown(String element, int indexvalue) {
		WebElement mySelectElm = driver.findElement(By.xpath(element));
		try {
			if (mySelectElm != null) {
				Select mySelect = new Select(mySelectElm);
				mySelect.selectByIndex(indexvalue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To Change the xpath into WebElement *
	 * 
	 * @param String xpath of the element
	 */
	public MobileElement getElement(String Xpath) {
		MobileElement element = driver.findElement(By.xpath(Xpath));
		return element;

	}

	/**
	 * To enter the data into a text field*
	 * 
	 * @param element xpath (String) of the element
	 * @param text    String value of data to enter
	 */
	public void populateFields(String element, String text) {
		WebElement elem = driver.findElement(By.xpath(element));
		try {
			if (elem != null) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * To tap on the element *
	 * 
	 * @param element xpath (String) of the element
	 */
	public void tapElement(String element) {
		MobileElement ele = driver.findElement(By.xpath(element));
		try {
			if (ele != null) {
				waitForElementToBeClickable(ele);
				driver.findElement(By.xpath(element)).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
