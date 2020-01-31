package main.java.com.trivago.app.pages;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import main.java.com.trivago.lib.base.TestUtilities;
import main.java.com.trivago.lib.pages.basePage;

public class SearchHotelPageObject extends basePage{
	
	public SearchHotelPageObject(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[contains(text(),'www.trivago.com')]")
	public WebElement trivagoRedirectUrl;
	
	@FindBy(id = "querytext")
	public WebElement queryText;
	
	@FindBy(xpath="//span[@class='icon-ic dealform-button__icon']")
	public WebElement checkInDateCalendar;
	
	@FindBy(xpath="//button[@data-qa='search-button']")
	public WebElement searchButton;
	
	@FindBy(xpath="//li[@class='hotel-item item-order__list-item js_co_item']")
	public List<WebElement> hotelList;
	
	@FindBy(xpath="//span[@class='item-link name__copytext']")
	public List<WebElement> hotelNames;
	
	@FindBy(xpath="//button[@class='btn btn--pagination btn--small pagination__page']")
	public List<WebElement> paginationPageNumbers;
	
	@FindBy(xpath="//button[@class='btn btn--pagination btn--small btn--page-arrow btn--next']")
	public WebElement nextPageButton;
	
	@FindBy(xpath="//li[@data-qa='rating-filter']//span[@class='icon-ic icon-contain filter-ic filter-ic--state filter-ic--arrow']")
	public WebElement guestRatingFilterDropDown;
	
	@FindBy(xpath="//div[@class='popover_body']//span[@class='range_text']")
	public List<WebElement> guestRating;
	
	@FindBy(xpath="//span[@itemprop='ratingValue']")
	public List<WebElement> ratingValue;
	
	@FindBy(xpath="//*[@class='item__best-price price_min item__best-price--perstay']")
	public List<WebElement> bestPriceValue;

	@FindBy(xpath="//div[@role='slider']")
	public WebElement priceBarHandler;
	
	@FindBy(xpath="//div[@class='fl-slider__range' and style='width: 51.0924%;']")
	public WebElement priceBarHandlerRange;
	
	
	Set<String> HotelNames=new HashSet<String>();
	static int selectedPriceRange=0;
	
	
	public void openTrivagoSite() throws IOException {
		driver.get(TestUtilities.getProperties().getProperty("AppUrl"));
		TestUtilities.sleep(2000);
		trivagoRedirectUrl.click();
	}
	
	public void userGivesLocation(String cityName) {
		TestUtilities.waitForVisibilityOf(By.id("querytext"),20);
		queryText.sendKeys(cityName);
		
		queryText.sendKeys(Keys.TAB);
		}
	
	public void userGivesTravelDatesAndSearchHotel(String checkinDate,String checkoutDate) {
		
		//User selects check in and check out date
		
		 checkInDateCalendar.click();
		
	     WebElement checkInDate=driver.findElement(By.xpath("//td[@class='cal-day-wrap']/*[@datetime='"+checkinDate+"']"));
			
		 checkInDate.click();
		 
		 WebElement checkOutDate=driver.findElement(By.xpath("//td[@class='cal-day-wrap']/*[@datetime='"+checkoutDate+"']"));
			
		 TestUtilities.waitForVisibilityOf(By.xpath("//td[@class='cal-day-wrap']/*[@datetime='"+checkoutDate+"']"),40);
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", checkOutDate);
	
		 //User clicks on search button to view results.
		 
		 searchButton.click();
		 
		 TestUtilities.sleep(7000);
		
	}
	
	public void userCanSeeHotelListAsPerSearch() {
		
		//Wait for list to appear and check hotels are displayed in the list.
		TestUtilities.waitForVisibilityOf(By.xpath("//div[@id='js_itemlist_controls']"), 40);
		TestUtilities.waitForVisibilityOf(By.xpath("//*[@class='btn btn--pagination btn--small pagination__page btn--active']"), 40);
		Assert.assertTrue(hotelList.size()>0,"Hotels are not displayed on the page: ");
		log.info("Total hotels on the first page are: "+hotelList.size());
		TestUtilities.sleep(2000);
	}
	
	public void userCanNavigateToNextPage() {
		
		//Check how many pages are found in search result
		log.info("Total pages for hotel searches are: "+paginationPageNumbers.size());
		
		//Navigate to each page and check hotel list
		for(int i=0;i<paginationPageNumbers.size();i++)
		{
			nextPageButton.click();
			TestUtilities.sleep(2000);
			TestUtilities.waitForVisibilityOf(By.xpath("//*[@class='btn btn--pagination btn--small pagination__page btn--active']"), 40);
			TestUtilities.waitForVisibilityOf(By.xpath("//div[@id='js_itemlist_controls']"), 40);
			Assert.assertTrue(hotelNames.size()>0);
			log.info("User is on page : "+i+2);
			log.info("Total hotels in the list are: "+hotelList.size());
		}
	}
	
	   public void selectAveragePriceFromBar() {
		   //Move price bar to select any price range
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='fl-slider__range']")));
			priceBarHandler.sendKeys(Keys.ARROW_LEFT);
			priceBarHandler.sendKeys(Keys.ARROW_LEFT);
			priceBarHandler.sendKeys(Keys.ARROW_LEFT);
			selectedPriceRange=Integer.parseInt(priceBarHandler.getAttribute("aria-valuenow"));
			 log.info("Price selected from price bar is  "+selectedPriceRange);
			 priceBarHandler.sendKeys(Keys.ENTER);
			 TestUtilities.sleep(2000);
			TestUtilities.waitForVisibilityOf(By.xpath("//div[@id='js_itemlist_controls']"), 40);
	   }
	   
		 public void validateOrderListForHotel(){
			 
		 //Validate hotels within selected price range are displayed
			 
			   for(WebElement e:bestPriceValue) {
					int price=Integer.parseInt(e.getText().substring(1));
					log.info("Prices are: "+price);
					Assert.assertTrue(price<=selectedPriceRange);
				}	
			
			}
	   
	
	public void userSelectsGuestRatingFilter(String selectedGuestRating) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", guestRatingFilterDropDown);
		 
		for(WebElement e:guestRating) {
			log.info("Available Ratings are: "+ e.getText());
			if(e.getText().equalsIgnoreCase(selectedGuestRating)) {
				e.click();
				break;
			}
		}
		log.info("Guest rating is selected");
		searchButton.click();
    	 TestUtilities.sleep(5000);
	}

	public void validateHotelsDisplayedAsPerGivenRating() {
		for(WebElement e:ratingValue) {
			log.info("Rating is : "+e.getText());
		}
	}
	
		public void selectHotelByFilterPrice()
		{
			Select filter=new Select(driver.findElement(By.id("mf-select-sortby")));
		
			filter.selectByVisibleText("Price only");
		}
		
	  
	
	
	
	
}
