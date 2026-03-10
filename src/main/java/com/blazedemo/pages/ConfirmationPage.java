package com.blazedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ConfirmationPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Locators
    @FindBy(xpath = "//h1[contains(text(),'Thank you')]")
    private WebElement confirmationTitle;
    
    @FindBy(xpath = "//td[text()='Id']/following-sibling::td")
    private WebElement confirmationId;
    
    @FindBy(xpath = "//td[text()='Status']/following-sibling::td")
    private WebElement confirmationStatus;
    
    @FindBy(xpath = "//td[text()='Amount']/following-sibling::td")
    private WebElement confirmationAmount;
    
    @FindBy(xpath = "//table[@class='table']")
    private WebElement confirmationTable;
    
    /**
     * Constructor
     */
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    
    /**
     * Check if booking is confirmed
     */
    public boolean isBookingConfirmed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(confirmationTitle));
            String title = confirmationTitle.getText();
            System.out.println("STEP 11: Booking Confirmation Received");
            System.out.println("        Message: " + title);
            displayConfirmationDetails();
            return title.contains("Thank you");
        } catch (Exception e) {
            System.out.println("STEP 11 FAILED: Confirmation not displayed");
            return false;
        }
    }
    
    /**
     * Display confirmation details
     */
    private void displayConfirmationDetails() {
        try {
            String id = confirmationId.getText();
            String status = confirmationStatus.getText();
            String amount = confirmationAmount.getText();
            
            System.out.println("\n        " + "=".repeat(50));
            System.out.println("        BOOKING CONFIRMATION DETAILS");
            System.out.println("        " + "=".repeat(50));
            System.out.println("        Confirmation ID: " + id);
            System.out.println("        Status: " + status);
            System.out.println("        Total Amount: " + amount);
            System.out.println("        " + "=".repeat(50) + "\n");
        } catch (Exception e) {
            System.out.println("        ⚠️ Could not retrieve all confirmation details");
        }
    }
    
    /**
     * Get confirmation ID
     */
    public String getConfirmationId() {
        try {
            wait.until(ExpectedConditions.visibilityOf(confirmationId));
            return confirmationId.getText();
        } catch (Exception e) {
            return "";
        }
    }
    
    /**
     * Get confirmation status
     */
    public String getConfirmationStatus() {
        try {
            return confirmationStatus.getText();
        } catch (Exception e) {
            return "";
        }
    }
    
    /**
     * Get total amount
     */
    public String getTotalAmount() {
        try {
            return confirmationAmount.getText();
        } catch (Exception e) {
            return "";
        }
    }
}