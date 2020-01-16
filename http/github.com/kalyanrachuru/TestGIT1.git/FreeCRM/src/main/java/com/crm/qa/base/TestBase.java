package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
	//	System.out.println("Test Base entered");
		try {
			Properties prop = new Properties();
			FileInputStream fip = new FileInputStream(
					"/Users/Kalyan/workspace-2019-12/FreeCRM/src/main/java/com/crm/qa/config/config.properties");
		//	System.out.println("file path =  " + fip);
			prop.load(fip);
		//	System.out.println("fip loaded");
			 

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

public static void initialization() {
	System.out.println("Browser =  " + prop.getProperty("browser"));
	
	String browserName = prop.getProperty("browser");
	if (browserName.equals("chrome") )  {
		System.setProperty("webdriver.chrome.driver", "Users/Kalyan/workspace-2019-12/DemoMaven/src/main/resources/driver/chromedriver");
		  driver = new ChromeDriver();
		
	} else 
		if (browserName.equals("firefox") )  {
		System.setProperty("webdriver.gecko.driver", "Users/Kalyan/workspace-2019-12/DemoMaven/src/main/resources/driver/geckodriver");
		  driver = new FirefoxDriver();
		}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.ITO, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	
}
 

}
