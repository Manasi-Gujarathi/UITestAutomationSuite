package test.java.stepdefinations;

import java.io.IOException;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import main.java.com.trivago.lib.base.BaseTest;


public class Hooks {
	
	protected static WebDriver driver;
	protected Logger log;
	BaseTest base=new BaseTest();
	
	
	@Before
	public void beforeEachTest() throws IOException {
		//Initializes webDriver instance and opens browser. 
			base.setUp();
	}
	
	@After
	public void tearDown() {
		//Closed webDriver window
		base.tearDown();
	}

}
