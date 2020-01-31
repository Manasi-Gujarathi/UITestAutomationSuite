package main.java.com.trivago.lib.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	private ThreadLocal<WebDriver>driver=new ThreadLocal<WebDriver>();
	private String browser;
	private Logger logger;
	
	public BrowserFactory(String browser,Logger log) {
		this.browser=browser.toLowerCase();
		this.logger=log;
	}
	
	public WebDriver createDriver() {
		
		logger.info("Creating driver: "+ browser);
		
		switch(browser) {
		
		case "chrome": System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
						driver.set(new ChromeDriver());
			break;
		case "firefox":System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
						driver.set(new FirefoxDriver());
			break;
		default		:logger.info("Do not know how to start " +browser+"  Starting chrome :" );
			 			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			 			 driver.set(new ChromeDriver());
			break;
		
		}
		
		return driver.get();
	}

}