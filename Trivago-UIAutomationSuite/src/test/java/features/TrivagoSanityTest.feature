Feature: User can search hotel on Trivago site and navigate to different pages and user can view hotel list accourding to selected filter.


Scenario Outline: User can search hotel on trivago site for given destination and dates and User can navigate to all pages to search accomodation.
Given User logs into the Trivago application
When user inputs "<City>" of his choice
And user selects check in date as "<check-in>" and check out date as "<check-out>" date and search hotels
Then user can see list of hotels on page
And user can navigate to next pages
Examples:
|City|check-in|check-out|
|Amsterdam|2020-02-25|2020-02-28| 
 
Scenario Outline: User can search hotel using filter like price and results matching given search criteria are displayed.
Given User logs into the Trivago application
When user inputs "<City>" of his choice
And user selects check in date as "<check-in>" and check out date as "<check-out>" date and search hotels
Then user can see list of hotels on page
And user selects value from price bar
Then hotels within given price range are displayed
Examples:
|City|check-in|check-out|
|Amsterdam|2020-02-25|2020-02-28|