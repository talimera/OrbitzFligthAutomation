package com.orbitz.pages;

import com.orbitz.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class FlightPage {


    public FlightPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//div[@class='uitk-tabs-inner-container']/li[1]")
    @CacheLookup
    private WebElement roundTripButton;

    @FindBy(xpath = "//button[@aria-label='Leaving from']")
    @CacheLookup
    private WebElement leavingFromButton;

    @FindBy(xpath = "//button[@aria-label='Going to']")
    @CacheLookup
    private WebElement goingToButton;

    @FindBy(xpath = "//input[@placeholder='Where are you leaving from?']")
    @CacheLookup
    private WebElement departureAirport;

    @FindBy(xpath = "//strong[.='San Francisco (SFO - San Francisco Intl.)']")
    @CacheLookup
    private WebElement selectDepartureAirport;

    @FindBy(xpath = "//input[@placeholder='Where are you going to?']")
    @CacheLookup
    private WebElement arrivalAirport;

    @FindBy(xpath = "//strong[.='New York (NYC - All Airports)']")
    @CacheLookup
    private WebElement selectArrivalAirport;

    @FindBy(id = "d1-btn")
    @CacheLookup
    private WebElement departureDateButton;

    @FindBy(id = "d2-btn")
    @CacheLookup
    private WebElement returnDateButton;

    @FindBy(xpath = "//button[starts-with(@aria-label,'Jun 29')]")
    @CacheLookup
    private WebElement departureDate;

    @FindBy(xpath = "//button[starts-with(@aria-label,'Jul 6')]")
    @CacheLookup
    private WebElement returnDate;

    @FindBy(xpath = "//button[@data-stid='apply-date-picker']")
    @CacheLookup
    private WebElement dateDoneButton;

    @FindBy(xpath = "(//button[@class='uitk-faux-input'])[1]")
    @CacheLookup
    private WebElement leavingFrom;

    @FindBy(xpath = "(//button[@class='uitk-faux-input'])[2]")
    @CacheLookup
    private WebElement goingTo;



    @FindBy(xpath = "//button[contains(text(),'Search')]")
    @CacheLookup
    private WebElement searchButton;


    public void roundTripSelected() {
        Assert.assertTrue(roundTripButton.isSelected());
    }

    public void chooseDepartureAirport(String departure) {

        leavingFromButton.click();
        departureAirport.sendKeys(departure);
        selectDepartureAirport.click();

    }

    public void chooseArrivalAirpot(String arrival){
        goingToButton.click();
        arrivalAirport.sendKeys(arrival);
        selectArrivalAirport.click();
    }


    public void departureAndArrivalDate() {

        departureDateButton.click();
        departureDate.click();
        returnDate.click();
        dateDoneButton.click();

    }


    public String chosenFlightDates(){
        return  departureDateButton.getText() +
                " " + returnDateButton.getText();
    }



    public FlightListPage searchFlights() {
        searchButton.click();
        return new FlightListPage();
    }









}
