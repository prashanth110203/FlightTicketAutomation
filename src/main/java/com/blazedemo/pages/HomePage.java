package com.blazedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Locators
    @FindBy(name = "fromPort")
    private WebElement departureDropdown;
    
    @FindBy(name = "toPort")
    private WebElement destinationDropdown;
    
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement findFlightsButton;
    
    @FindBy(xpath = "//h1[contains(text(),'Welcome')]")
    private WebElement welcomeHeader;
    
    /**
     * Constructor
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    
    /**
     * Navigate to BlazeDemo homepage
     */
    public void navigateToHomePage(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOf(welcomeHeader));
        System.out.println("STEP 1: Navigated to BlazeDemo");
    }
    
    /**
     * Select departure city from dropdown
     */
    public void selectDepartureCity(String city) {
        wait.until(ExpectedConditions.visibilityOf(departureDropdown));
        Select select = new Select(departureDropdown);
        select.selectByVisibleText(city);
        System.out.println("STEP 2: Selected Departure City: " + city);
    }
    
    /**
     * Select destination city from dropdown
     */
    public void selectDestinationCity(String city) {
        wait.until(ExpectedConditions.visibilityOf(destinationDropdown));
        Select select = new Select(destinationDropdown);
        select.selectByVisibleText(city);
        System.out.println("STEP 3: Selected Destination City: " + city);
    }
    
    /**
     * Click Find Flights button
     */
    public void clickFindFlights() {
        wait.until(ExpectedConditions.elementToBeClickable(findFlightsButton));
        findFlightsButton.click();
        System.out.println("STEP 4: Clicked 'Find Flights' button");
    }
}