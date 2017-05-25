package com.ohrm.pom;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.ohrm.data.DataFactory;
import com.ohrm.data.OhrmData;
import com.ohrm.res.ResultUtility;

public class OhrmPOM {
	public String testClassName;
	
	WebDriver driver;
	public LoginPage loginPage;
	public WelcomePage welcomePage;
	public AddEmployeePage addEmpPage;
	public DataFactory data;
	public ResultUtility report; 
	public void openApplication(String brName, String appUrl) {

		switch (brName) {

		case "chrome":
			// configure browser driver
			System.setProperty("webdriver.chrome.driver",
					OhrmData.chromeDriverPath);

			// open new chrome window
			driver = new ChromeDriver();
			break;
		case "ff":
			// configure browser driver
			System.setProperty("webdriver.gecko.driver",
					OhrmData.firefoxDriverPath);

			// open new chrome window
			driver = new FirefoxDriver();
			break;
		case "edge":
			break;
		default:
			System.out.println("not a valid browser name");
			System.exit(0); // to exit from test
		}

		// navigate to url
		driver.get(appUrl);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initPageClasses();
	}
	public void openApplicationInRemote(String brName, String appUrl,String nUrl) throws MalformedURLException {

		switch (brName) {

		case "chrome":
			// open new chrome window
			driver = new RemoteWebDriver(new URL(nUrl), DesiredCapabilities.chrome());
			break;
		case "ff":
			driver = new RemoteWebDriver(new URL(nUrl), DesiredCapabilities.firefox());
			break;
		case "edge":
			driver = new RemoteWebDriver(new URL(nUrl), DesiredCapabilities.edge());
			break;
		default:
			System.out.println("not a valid browser name");
			System.exit(0); // to exit from test
		}

		// navigate to url
		driver.get(appUrl);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		initPageClasses();
	}
	private void initPageClasses() {
		loginPage = new LoginPage(driver);
		welcomePage = new WelcomePage(driver);
		addEmpPage = new AddEmployeePage(driver);
		data = new DataFactory();
		report = new ResultUtility(testClassName);
	}
	
	public void closeApplication(){
		driver.quit();
		report.endTest();
	}
	

}
