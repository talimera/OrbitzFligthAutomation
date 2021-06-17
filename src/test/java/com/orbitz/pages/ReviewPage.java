package com.orbitz.pages;

import com.orbitz.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReviewPage {

    public ReviewPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//span[@class='uitk-text uitk-type-500 uitk-type-bold uitk-text-emphasis-theme']")
    @CacheLookup
    private WebElement totalPrice;

    @FindBy(xpath = "//div[@data-test-id='flight-review-header']")
    @CacheLookup
    private List<WebElement> tickets;

    @FindBy(xpath = "//div[@data-test-id='flight-operated']")
    @CacheLookup
    private List<WebElement> flightDetails;

    public String priceTotal(){
        return totalPrice.getText();
    }

    public String departureTicketDetails(){
        return tickets.get(0).getText();
    }

    public String returnTicketDetails(){
        return tickets.get(1).getText();
    }

    public String totalPrice(){
        return totalPrice.getText();
    }





}
