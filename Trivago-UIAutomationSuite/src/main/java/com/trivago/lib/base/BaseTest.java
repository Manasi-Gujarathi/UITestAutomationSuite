package main.java.com.trivago.lib.base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import main.java.com.trivago.lib.pages.basePage;

public class BaseTest {

	protected static WebDriver driver;
	protected Logger log;
	
	protected String testSuiteName;
	protected String testName;
	
	protected String browser=System.getProperty("browser");
	
	protected static basePage page;
	
	
	public void setUp() throws IOException {
		
		log=LogManager.getLogger(testName);
		
		BrowserFactory factory=new BrowserFactory(browser,log);
		driver = factory.createDriver();
		driver.manage().window().maximize();
		
		page=new basePage();
		page.setWebDriver(driver,log);
		
	}
	
	
	public void tearDown() {
		log.info("Close Driver");
		//close browser
		 driver.quit();
		 log.info("Please find detailed report at the location: "+ System.getProperty("user.dir")+"\\target\\cucumber-html-reports\\overview-features.html");
	}
	
}

