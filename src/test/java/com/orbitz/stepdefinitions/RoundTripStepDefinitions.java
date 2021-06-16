package com.orbitz.stepdefinitions;

import com.orbitz.pages.BasePage;
import com.orbitz.pages.FlightListPage;
import com.orbitz.pages.FlightPage;
import com.orbitz.pages.ReviewPage;
import com.orbitz.utilities.BrowserUtil;
import com.orbitz.utilities.ConfigurationReader;
import com.orbitz.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RoundTripStepDefinitions {

    BasePage mainPage = new BasePage();
    FlightPage flightPage;
    FlightListPage flightListPage;
    ReviewPage reviewPage;

    private  String departureTicket;
    private  String returnTicket;

    @Given("user is on the main page")
    public void user_is_on_the_main_page() {

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.get("url"));

    }

    @Then("user clicks on more travel dropdown and clicks Flights")
    public void user_clicks_on_more_travel_dropdown_and_clicks_flights() {
        flightPage = mainPage.navigate();
    }

    @Then("user clicks on Leaving from button and User enters {string}")
    public void user_clicks_on_leaving_from_button_and_user_enters(String departure) {
        flightPage.chooseDepartureAirport(departure);
    }

    @Then("user clicks on Going to button and User enters {string}")
    public void user_clicks_on_going_to_button_and_user_enters(String arrival) {
        flightPage.chooseArrivalAirpot(arrival);
    }

    @Then("user click on Departing button and User chooses Departing and Returning date")
    public void user_click_on_departing_button_and_user_chooses_departing_and_returning_date() {
        flightPage.departureAndArrivalDate();
    }

    @Then("user clicks on Search button and User sees search results contain {string} and {string}")
    public void user_clicks_on_search_button_and_user_sees_search_results_contain_and(String departure, String arrival) {

        String ticketDetail = flightPage.chosenFlightDates();
        flightListPage = flightPage.searchFlights();
        BrowserUtil.waitFor(4);
        String resultDetails = flightListPage.flightDetails();

        Assert.assertTrue(resultDetails.contains(departure));
        Assert.assertTrue(resultDetails.contains(arrival));
        Assert.assertTrue(resultDetails.contains(ticketDetail));

    }

    @Then("User click on nonstop for departure flights")
    public void user_click_on_nonstop_for_departure_flights() {
        flightListPage.findNonStopFlights();
    }

    @Then("User sorts for most expensive departure ticket and selects that ticket")
    public void user_sorts_for_most_expensive_departure_ticket_and_selects_that_ticket() {

        BrowserUtil.waitFor(3);
        flightListPage.highestPriceDepartureTicket();
        departureTicket = flightListPage.departureTicketDetails();
        flightListPage.selectTicket();
    }

    @Then("User click on nonstop for returning flights")
    public void user_click_on_nonstop_for_returning_flights(){

        BrowserUtil.waitFor(3);
        flightListPage.findNonStopFlights();

    }

    @Then("User sorts for most expensive returning ticket and continue to review page")
    public void user_sorts_for_most_expensive_returning_ticket_and_continue_to_review_page() {
        BrowserUtil.waitFor(3);
        flightListPage.highestPriceReturnTicket();
        returnTicket = flightListPage.returnTicketDetails();
        flightListPage.selectSecondTicket();
        BrowserUtil.waitFor(3);
    }

    @Then("User sees the flight information is correct")
    public void user_sees_the_flight_information_is_correct() {
        System.out.println(departureTicket);
        System.out.println(returnTicket);

        String price = flightListPage.price();
        System.out.println(price);



    }


}
