package com.orbitz.pages;

import com.orbitz.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class FlightListPage {

    public FlightListPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    private FlightPage flightPage = new FlightPage();

    @FindBy(xpath = "(//button[@class='uitk-faux-input'])[1]")
    @CacheLookup
    private WebElement flyingFrom;

    @FindBy(xpath = "(//button[@class='uitk-faux-input'])[2]")
    @CacheLookup
    private WebElement flyingTo;

    @FindBy(xpath = "//button[@id='start-date-ROUND_TRIP-0-btn']")
    @CacheLookup
    private WebElement departing;

    @FindBy(xpath = "//button[@id='end-date-ROUND_TRIP-0-btn']")
    @CacheLookup
    private WebElement returning;

    @FindBy(css = "input#stops-0")
    @CacheLookup
    private WebElement nonStopBox;

    @FindBy(id = "listings-sort")
    @CacheLookup
    private WebElement sortDropdown;

    @FindBy(xpath = "//ul[@data-test-id='listings']/li[1]")
    @CacheLookup
    private WebElement departureTicket;

    @FindBy(xpath = "//h2[@class='uitk-heading-4']")
    @CacheLookup
    private WebElement departureDirection;

    @FindBy(xpath = "//div[@class='uitk-text uitk-text-default-theme']")
    @CacheLookup
    private WebElement departureTicketDetails;

    @FindBy(xpath = "//ul[@data-test-id='listings']/li[1]")
    @CacheLookup
    private WebElement returnTicket;

    @FindBy(xpath = "//h2[@class='uitk-heading-4']")
    @CacheLookup
    private WebElement returnDirection;

    @FindBy(xpath = "//div[@class='uitk-text uitk-text-default-theme']")
    @CacheLookup
    private WebElement returnTicketDetails;

    @FindBy(xpath = "//button[@data-test-id='select-button']")
    @CacheLookup
    private WebElement selectTicketButton;

    @FindBy(xpath = "//button[@data-test-id='select-button']")
    @CacheLookup
    private WebElement continueButton;

    @FindBy(xpath = "//footer//span[@aria-hidden='true']")
    @CacheLookup
    private WebElement roundTripPrice;


    public void findNonStopFlights() {
        nonStopBox.click();
        // add wait here
    }

    public void highestPriceDepartureTicket() {
        sortDropdown.click();
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByValue("PRICE_DECREASING");
        // add wait here
        departureTicket.click();
        selectTicketButton.click();
    }


    public void highestPriceReturnTicket() {
        sortDropdown.click();
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByValue("PRICE_DECREASING");
        // add wait here
        returnTicket.click();
        continueButton.click();
    }

    public String flightDetails() {
        return flyingFrom.getText() + " " + flyingTo.getText() + " " +
                departing.getText() + " " + returning.getText();
    }

    public String departureTicketDetails() {
        return departureDirection.getText() + " " + departureTicketDetails.getText();
    }

    public String returnTicketDetails() {
        return returnDirection.getText() + " " + returnTicketDetails.getText();
    }

    public void assertTicketDetails() {

    }


    public ReviewPage goToReviewPage() {
        // Selecting returning ticket opens another tab for review page which need to switch to in order to make assertions

        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String> handles = Driver.getDriver().getWindowHandles();

        for (String childWindow : handles) {
            if (!currentWindow.equals(childWindow)) {
                Driver.getDriver().switchTo().window(childWindow);
            }
        }
        return new ReviewPage();
    }


}
