package tests;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase {
	
	public static WebDriver driver;
	public static String downloadPath = System.getProperty
			("user.dir") + "downloads";
	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/pdf,application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting",
				false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}
	
	@SuppressWarnings("deprecation")
	public static ChromeOptions chromeOption() {
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups",0);
		chromePrefs.put("download.default_directry", downloadPath);
		option.setExperimentalOption("prefs", chromePrefs);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return option;
		
	}
	
	
	
	
		
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
			System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(chromeOption());			
		}
		else if (browserName.equalsIgnoreCase("firefoxe")) {
			System.setProperty("webdriver.gecko.driver", 
			System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(firefoxOption());			
		}
		
//		else if (safari) {
//			
//		}
//		else if (opra) {
//			
//		}		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	
	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}
	
	//take screenshot when test case fail and add it in screenshots folder
//	@AfterMethod
//	public void screenShotOnFaiure(ITestResult result) {
//		
//		if (result.getStatus() == ITestResult.FAILURE) {
//			System.out.println("Failed");
//			System.out.println("Taking a screenshot...");
//			Helper.captureScreenShot(driver, result.getName());
//			
//			
//		}
//	}
	

}
