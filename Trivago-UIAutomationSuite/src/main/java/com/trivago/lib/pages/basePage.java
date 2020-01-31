package main.java.com.trivago.lib.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class basePage {

protected static WebDriver driver;
protected static Logger log;
	
	public void setWebDriver(WebDriver driver,Logger log) throws IOException {
		basePage.driver = driver;
		basePage.log=log;
	}
}
