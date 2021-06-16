package com.orbitz.pages;

import com.orbitz.utilities.ConfigurationReader;
import com.orbitz.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class deneme {

    // Leaving From
    //button[@aria-label='Leaving from']

    // Going To
    //button[@aria-label='Going to']

    //Departure
    //button[@id='d1-btn']

    // Returning
    //button[@id='d2-btn']

    //input[@placeholder='Where are you leaving from?']

    //input[@placeholder='Where are you going to?']

    // Date June 29
    // (//button[@data-day='29'])[1]
    //button[starts-with(@aria-label,'Jun 29')]

    // Date July 6
    //button[starts-with(@aria-label,'Jul 6')]

    // Done button
    //button[@data-stid='apply-date-picker']

    // Search Button
    //button[contains(text(),'Search')]

    // San Francisco
    //ul[@class='uitk-typeahead-results no-bullet']//strong[.='San Francisco (SFO - San Francisco Intl.)']
    //strong[.='San Francisco (SFO - San Francisco Intl.)']


    // New york has more airports choose all airports
    //strong[.='New York (NYC - All Airports)']

    //Nonstop checkbox
    //span[@id='Nonstop-stop-flights-checkbox']


    // dropdown
    //select[@id='sortDropdown']

    // Highest Price
    //ul[@data-test-id='listings']/li[1]

    // Ticket Select Button
    //button[@data-test-id='select-button']

    // First Ticket Name
    //h2[@class='uitk-heading-4']

    // First Ticket Flight company
    //div[@class='uitk-text uitk-text-default-theme']

    // Second Ticket Name
    //h2[@class='uitk-heading-4']

    // First Ticket Flight details
    //div[@class='uitk-text uitk-text-default-theme']

    // Total Price
    //footer//span[@aria-hidden='true']

    //Review Page Total Price
    //span[@class='uitk-text uitk-type-500 uitk-type-bold uitk-text-emphasis-theme']


    @Test
    public void test1() throws InterruptedException {

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.get("url"));


        WebElement travel = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'travel')]"));
        travel.click();
        WebElement flights = Driver.getDriver().findElement(By.xpath("//a[@href='/Flights']"));
        flights.click();

        String title = Driver.getDriver().getTitle();
        System.out.println(title);

        WebElement departure = Driver.getDriver().findElement(By.xpath("//button[@aria-label='Leaving from']"));
        departure.click();
        Thread.sleep(1000);

        WebElement placeholder = Driver.getDriver().findElement(By.xpath("//input[@placeholder='Where are you leaving from?']"));
        placeholder.sendKeys("San Francisco");

        Thread.sleep(1000);
        WebElement airportDep = Driver.getDriver().findElement(By.xpath("//strong[.='San Francisco (SFO - San Francisco Intl.)']"));
        airportDep.click();

        WebElement arrival = Driver.getDriver().findElement(By.xpath("//button[@aria-label='Going to']"));
        arrival.click();

        WebElement placeholderArr = Driver.getDriver().findElement(By.xpath("//input[@placeholder='Where are you going to?']"));
        placeholderArr.sendKeys("New York");

        Thread.sleep(1000);
        WebElement airportArr = Driver.getDriver().findElement(By.xpath("//strong[.='New York (NYC - All Airports)']"));
        airportArr.click();

        WebElement date = Driver.getDriver().findElement(By.id("d1-btn"));
        date.click();


        Thread.sleep(1000);
        WebElement departureDate = Driver.getDriver().findElement(By.xpath("//button[starts-with(@aria-label,'Jun 29')]"));
        departureDate.click();

        WebElement returnDate = Driver.getDriver().findElement(By.xpath("//button[starts-with(@aria-label,'Jul 6')]"));
        returnDate.click();

        WebElement doneButton = Driver.getDriver().findElement(By.xpath("//button[@data-stid='apply-date-picker']"));
        doneButton.click();

        WebElement searchButton = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'Search')]"));
        searchButton.click();

        Thread.sleep(2000);
        String title2 = Driver.getDriver().getTitle();
        System.out.println(title2);


        WebElement sortDropdown = Driver.getDriver().findElement(By.id("listings-sort"));

        WebElement nonStop = Driver.getDriver().findElement(By.cssSelector("input#stops-0"));
        //WebElement nonStop2 = Driver.getDriver().findElement(By.xpath("//span[@id='Nonstop-stop-flights-checkbox']"));
        nonStop.click();
        //nonStop2.click();
        Thread.sleep(2000);

        sortDropdown.click();

        Select dropdown = new Select(sortDropdown);
        dropdown.selectByValue("PRICE_DECREASING");
        Thread.sleep(2000);

        WebElement highestPriceTicket = Driver.getDriver().findElement(By.xpath("//ul[@data-test-id='listings']/li[1]"));
        highestPriceTicket.click();


        Thread.sleep(3000);
        WebElement firstTicket = Driver.getDriver().findElement(By.xpath("//h2[@class='uitk-heading-4']"));
        String departureName = firstTicket.getText();
        System.out.println(departureName);

        WebElement firstTicketDetails = Driver.getDriver().findElement(By.xpath("//div[@class='uitk-text uitk-text-default-theme']"));
        String firstTicketDet = firstTicketDetails.getText();
        System.out.println(firstTicketDet);

        WebElement selectBut = Driver.getDriver().findElement(By.xpath("//button[@data-test-id='select-button']"));
        selectBut.click();

        Thread.sleep(3000);


        nonStop.click();
        sortDropdown.click();
        dropdown.selectByValue("PRICE_DECREASING");
        Thread.sleep(3000);

        WebElement secondTicket = Driver.getDriver().findElement(By.xpath("//ul[@data-test-id='listings']/li[1]"));
        secondTicket.click();

        WebElement returningTicket = Driver.getDriver().findElement(By.xpath("//h2[@class='uitk-heading-4']"));
        String returningTic = returningTicket.getText();
        System.out.println(returningTic);

        WebElement returningTicketDetails = Driver.getDriver().findElement(By.xpath("//div[@class='uitk-text uitk-text-default-theme']"));
        String returningTicketDet = returningTicketDetails.getText();
        System.out.println(returningTicketDet);

        selectBut = Driver.getDriver().findElement(By.xpath("//button[@data-test-id='select-button']"));
        selectBut.click();


        Thread.sleep(3000);
        String title3 = Driver.getDriver().getTitle();
        System.out.println(title3);


        String currentWindow = Driver.getDriver().getWindowHandle();
        Set<String> handles = Driver.getDriver().getWindowHandles();

        for (String childWindow : handles) {
            if (!currentWindow.equals(childWindow)) {
                Driver.getDriver().switchTo().window(childWindow);
            }


        }

        String reviewPageTitle = Driver.getDriver().getTitle();
        System.out.println(reviewPageTitle);


        // //div[contains(text(),'travel')] More Travel
        // //a[@href='/Flights'] Flights

    }
}
