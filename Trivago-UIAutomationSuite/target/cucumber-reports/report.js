$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/TrivagoSanityTest.feature");
formatter.feature({
  "name": "User can search hotel on Trivago site.",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User can search hotel on trivago site for given destination and dates and User can navigate to all pages to search accomodation.",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User logs into the Trivago application",
  "keyword": "Given "
});
formatter.match({
  "location": "test.java.stepdefinations.SearchHotelStepDefination.user_logs_into_the_Trivago_application()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Hotel displayed  American Hotel Amsterdam  in this page is duplicate aldredy listed on previous page also did not expect to find [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:97)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:969)\r\n\tat org.testng.Assert.assertTrue(Assert.java:43)\r\n\tat main.java.com.basetest.frontend.pages.SearchHotelPageObject.searchHotel(SearchHotelPageObject.java:98)\r\n\tat test.java.stepdefinations.SearchHotelStepDefination.user_logs_into_the_Trivago_application(SearchHotelStepDefination.java:14)\r\n\tat ✽.User logs into the Trivago application(file:///E:/ManasiData/BaseFramework/src/test/java/features/TrivagoSanityTest.feature:4)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});