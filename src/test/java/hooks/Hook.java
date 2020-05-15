package hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author rohit
 *
 */

public class Hook extends BasePage {

	public static Properties prop;

	public static DesiredCapabilities capabilities = new DesiredCapabilities();

	String prop_filePath = System.getProperty("user.dir") + "/Configuration/config.properties";

	BasePage base;

	public Hook(BasePage base) {
		this.base = base;
	}
	
	
	@Before
	public void initializeTest() throws MalformedURLException {

		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(prop_filePath);
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File appDir = new File("APK");
		File app = new File(appDir, prop.getProperty("appName"));
//		base.deleteCookies();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("automationName"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));

		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, String.valueOf(120));

		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getProperty("appPackage"));
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getProperty("appActivity"));

		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);

		try {
			driver = new AppiumDriver<MobileElement>(new URL(prop.getProperty("URL_Capability")), capabilities);
//			wait = new WebDriverWait(this.driver, 30);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			base.takeScreenShot(scenario.getName());
		}
		base.resetApp();
		base.close();

	}

}
