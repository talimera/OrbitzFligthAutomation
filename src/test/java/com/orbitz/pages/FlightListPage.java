package com.orbitz.pages;

import com.orbitz.utilities.BrowserUtil;
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

    @FindBy(id = "stops-0")
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

    @FindBy(xpath = "//a[@data-test-id='forcedChoiceNoThanks']")
    @CacheLookup
    private WebElement noThanksButton;


    public String price() {
        return roundTripPrice.getText();
    }


    public void findNonStopFlights() {
        BrowserUtil.waitFor(1);
        nonStopBox.click();
        BrowserUtil.waitFor(2);

    }

    public void highestPriceDepartureTicket() {
        BrowserUtil.waitFor(1);
        sortDropdown.click();
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByValue("PRICE_DECREASING");
        BrowserUtil.waitFor(2);
        departureTicket.click();
    }


    public void highestPriceReturnTicket() {
        BrowserUtil.waitFor(1);
        sortDropdown.click();
        Select dropdown = new Select(sortDropdown);
        dropdown.selectByValue("PRICE_DECREASING");
        BrowserUtil.waitFor(2);
        returnTicket.click();
    }

    public void selectTicket() {
        selectTicketButton.click();
    }

    public void selectSecondTicket() {

        BrowserUtil.waitFor(2);
        continueButton.click();
        if (noThanksButton.isDisplayed()) {
            BrowserUtil.waitFor(2);
            noThanksButton.click();
        }
    }

    public String flightDetails() {
        return flyingFrom.getText() + " " + flyingTo.getText() + " " +
                departing.getText() + " " + returning.getText();
    }

    public String departureTicketDetails() {
        return departureDirection.getText() + "\n" + departureTicketDetails.getText();
    }

    public String returnTicketDetails() {
        return returnDirection.getText() + "\n" + returnTicketDetails.getText();
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

        BrowserUtil.waitFor(3);

        return new ReviewPage();
    }


}
