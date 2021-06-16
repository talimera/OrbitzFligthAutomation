package com.orbitz.pages;

import com.orbitz.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//nav[@aria-label='primary navigation']")
    @CacheLookup
    private WebElement navDropdown;

    @FindBy(xpath = "//a[@href='/Flights']")
    @CacheLookup
    private WebElement flights;

    public FlightPage navigate(){
        navDropdown.click();
        flights.click();
        return new FlightPage();
    }

}
