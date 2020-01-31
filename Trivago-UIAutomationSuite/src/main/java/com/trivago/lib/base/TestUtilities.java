package main.java.com.trivago.lib.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class TestUtilities extends BaseTest {
	
	static Properties prop;

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}
		
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/** Take today's date in yyyyMMdd format **/
	private String getTodaysDate() {
		return (new SimpleDateFormat("yyyyMMdd'").format(new Date()));
	}
	
	/** Current time in HHmmssSSS */
	private String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}
	
	/** Take screenshot **/
	protected void takeScreenShot(String fileName) {
		File srcFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")
				+File.separator +"test-output"
				+File.separator +"screenshots"
				+File.separator+getTodaysDate()
				+File.separator+getSystemTime()
				+" "+fileName+".png";
		
		try {
			FileUtils.copyFile(srcFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Properties getProperties() throws IOException {
		if (prop == null) {
			return loadProperties();
		} else {
			return prop;
		}

	}

	public static Properties loadProperties() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\"+System.getProperty("environment")+".properties");
		prop = new Properties();
		prop.load(fis);
		return prop;

	}
	
	/**
	 * Wait for specific ExpectedCondition for the given amount of time in seconds
	 */
	public static void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}

	/**
	 * Wait for given number of seconds for element with given locator to be visible
	 * on the page
	 */
	public static void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}
}
