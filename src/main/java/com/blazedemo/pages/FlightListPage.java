package com.blazedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class FlightListPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private static int flightIndex = 0;
    private static final Random random = new Random();
    
    // Locators
    @FindBy(xpath = "//table[@class='table']//tbody//tr")
    private List<WebElement> flightRows;
    
    @FindBy(xpath = "//input[@value='Choose This Flight']")
    private List<WebElement> chooseFlightButtons;
    
    @FindBy(xpath = "//table[@class='table']//tbody//tr/td[3]")
    private List<WebElement> airlines;
    
    @FindBy(xpath = "//table[@class='table']//tbody//tr/td[6]")
    private List<WebElement> prices;
    
    @FindBy(xpath = "//h3[contains(text(),'Flights')]")
    private WebElement flightListHeader;
    
    /**
     * Constructor
     */
    public FlightListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    
    /**
     * Check if flight list is displayed
     */
    public boolean isFlightListDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(flightListHeader));
            wait.until(ExpectedConditions.visibilityOfAllElements(flightRows));
            System.out.println("STEP 5: Flight list displayed (" + flightRows.size() + " flights available)");
            displayAllFlights();
            return flightRows.size() > 0;
        } catch (Exception e) {
            System.out.println("STEP 5 FAILED: Flight list not displayed");
            return false;
        }
    }
    
    /**
     * Display all available flights in table format
     */
    private void displayAllFlights() {
        System.out.println("\n        " + "-".repeat(50));
        System.out.println("        | # | Airline            | Price     |");
        System.out.println("        " + "-".repeat(50));
        
        for (int i = 0; i < Math.min(flightRows.size(), airlines.size()); i++) {
            String airline = airlines.get(i).getText();
            String price = prices.get(i).getText();
            System.out.println(String.format("        | %d | %-18s | %-9s |", 
                (i + 1), airline, price));
        }
        System.out.println("        " + "-".repeat(50) + "\n");
    }
    
    /**
     * Select flight by index (1-based)
     */
    public void selectFlightByIndex(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElements(chooseFlightButtons));
        
        if (index < 1 || index > chooseFlightButtons.size()) {
            System.out.println("⚠️ Invalid index. Selecting first flight.");
            index = 1;
        }
        
        String airline = airlines.get(index - 1).getText();
        String price = prices.get(index - 1).getText();
        
        chooseFlightButtons.get(index - 1).click();
        
        System.out.println("STEP 6: Selected Flight #" + index);
        System.out.println("        Airline: " + airline + " | Price: " + price);
    }
    
    /**
     * Select random flight
     */
    public void selectRandomFlight() {
        wait.until(ExpectedConditions.visibilityOfAllElements(chooseFlightButtons));
        
        int totalFlights = chooseFlightButtons.size();
        int randomIndex = random.nextInt(totalFlights);
        
        String airline = airlines.get(randomIndex).getText();
        String price = prices.get(randomIndex).getText();
        
        chooseFlightButtons.get(randomIndex).click();
        
        System.out.println("STEP 6: Selected RANDOM Flight #" + (randomIndex + 1) + 
            " of " + totalFlights);
        System.out.println("        Airline: " + airline + " | Price: " + price);
    }
    
    /**
     * Select next flight sequentially (rotates through all flights)
     */
    public void selectNextFlight() {
        wait.until(ExpectedConditions.visibilityOfAllElements(chooseFlightButtons));
        
        int totalFlights = chooseFlightButtons.size();
        int currentIndex = flightIndex % totalFlights;
        
        String airline = airlines.get(currentIndex).getText();
        String price = prices.get(currentIndex).getText();
        
        chooseFlightButtons.get(currentIndex).click();
        
        System.out.println("STEP 6: Selected Sequential Flight #" + (currentIndex + 1) + 
            " of " + totalFlights);
        System.out.println("        Airline: " + airline + " | Price: " + price);
        
        flightIndex++;
    }
    
    /**
     * Select cheapest flight
     */
    public void selectCheapestFlight() {
        wait.until(ExpectedConditions.visibilityOfAllElements(chooseFlightButtons));
        
        int cheapestIndex = 0;
        double minPrice = Double.MAX_VALUE;
        
        for (int i = 0; i < prices.size(); i++) {
            String priceText = prices.get(i).getText().replace("$", "").replace(",", "");
            double price = Double.parseDouble(priceText);
            if (price < minPrice) {
                minPrice = price;
                cheapestIndex = i;
            }
        }
        
        String airline = airlines.get(cheapestIndex).getText();
        chooseFlightButtons.get(cheapestIndex).click();
        
        System.out.println("STEP 6: Selected CHEAPEST Flight #" + (cheapestIndex + 1));
        System.out.println("        Airline: " + airline + " | Price: $" + minPrice);
    }
    
    /**
     * Select most expensive flight
     */
    public void selectMostExpensiveFlight() {
        wait.until(ExpectedConditions.visibilityOfAllElements(chooseFlightButtons));
        
        int expensiveIndex = 0;
        double maxPrice = 0;
        
        for (int i = 0; i < prices.size(); i++) {
            String priceText = prices.get(i).getText().replace("$", "").replace(",", "");
            double price = Double.parseDouble(priceText);
            if (price > maxPrice) {
                maxPrice = price;
                expensiveIndex = i;
            }
        }
        
        String airline = airlines.get(expensiveIndex).getText();
        chooseFlightButtons.get(expensiveIndex).click();
        
        System.out.println("STEP 6: Selected MOST EXPENSIVE Flight #" + (expensiveIndex + 1));
        System.out.println("        Airline: " + airline + " | Price: $" + maxPrice);
    }
    
    /**
     * Get total flight count
     */
    public int getFlightCount() {
        return flightRows.size();
    }
}