package test.java.stepdefinations;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.com.trivago.app.pages.SearchHotelPageObject;

public class SearchHotelStepDefination {
	
	SearchHotelPageObject obj=new SearchHotelPageObject();	
	
	@Given("User logs into the Trivago application")
	public void user_logs_into_the_Trivago_application() throws IOException, InterruptedException {
		obj.openTrivagoSite();
	}

	@When("user inputs {string} of his choice")
	public void user_inputs_of_his_choice(String cityName) {
		obj.userGivesLocation(cityName);
	}

	@When("user selects check in date as {string} and check out date as {string} date and search hotels")
	public void user_selects_date_and_date_for_stay_and_search_hotels(String checkInDate, String checkOutDate) {
		obj.userGivesTravelDatesAndSearchHotel(checkInDate, checkOutDate);
	}

	@Then("user can see list of hotels on page")
	public void user_can_see_list_of_hotels_on_page() {
		obj.userCanSeeHotelListAsPerSearch();
	}

	@Then("user can navigate to next pages")
	public void user_can_navigate_to_next_pages() {
		obj.userCanNavigateToNextPage();
	}
	
	@When("user selects guest rating as {string} from page")
	public void user_selects_guest_rating(String guestRating) {
		obj.userSelectsGuestRatingFilter(guestRating);
	}
	
	@Then("user can search hotel by price only")
	public void user_can_search_hotel_by_price_only() {
		obj.selectHotelByFilterPrice();
	}
	
	@When("user can see list of hotels having ratings higher or same as selected by user")
	public void user_can_view_hotels_for_given_ratings() {
		obj.validateHotelsDisplayedAsPerGivenRating();
	}
	
	@Then("user selects value from price bar")
	public void user_selects_value_from_price_bar() {
	  obj.selectAveragePriceFromBar();
	}
	
	@Then("hotels within given price range are displayed")
	public void hotels_within_given_price_range_are_displayed() {
		obj.validateOrderListForHotel();
	}
	

}
