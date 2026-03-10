package com.blazedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PurchasePage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Personal Details Locators
    @FindBy(id = "inputName")
    private WebElement nameInput;
    
    @FindBy(id = "address")
    private WebElement addressInput;
    
    @FindBy(id = "city")
    private WebElement cityInput;
    
    @FindBy(id = "state")
    private WebElement stateInput;
    
    @FindBy(id = "zipCode")
    private WebElement zipCodeInput;
    
    // Payment Details Locators
    @FindBy(id = "creditCardNumber")
    private WebElement cardNumberInput;
    
    @FindBy(id = "creditCardMonth")
    private WebElement cardMonthInput;
    
    @FindBy(id = "creditCardYear")
    private WebElement cardYearInput;
    
    @FindBy(id = "nameOnCard")
    private WebElement nameOnCardInput;
    
    // Purchase Button
    @FindBy(xpath = "//input[@value='Purchase Flight']")
    private WebElement purchaseButton;
    
    // Page Header
    @FindBy(xpath = "//h2[contains(text(),'Your flight')]")
    private WebElement purchasePageHeader;
    
    /**
     * Constructor
     */
    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    
    /**
     * Check if purchase page is displayed
     */
    public boolean isPurchasePageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(purchasePageHeader));
            wait.until(ExpectedConditions.visibilityOf(nameInput));
            System.out.println("STEP 7: Purchase page displayed with flight details");
            return true;
        } catch (Exception e) {
            System.out.println("STEP 7 FAILED: Purchase page not displayed");
            return false;
        }
    }
    
    /**
     * Enter personal details
     */
    public void enterPersonalDetails(String name, String address, String city, 
                                      String state, String zipCode) {
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        
        nameInput.clear();
        nameInput.sendKeys(name);
        
        addressInput.clear();
        addressInput.sendKeys(address);
        
        cityInput.clear();
        cityInput.sendKeys(city);
        
        stateInput.clear();
        stateInput.sendKeys(state);
        
        zipCodeInput.clear();
        zipCodeInput.sendKeys(zipCode);
        
        System.out.println("STEP 8: Entered personal details");
        System.out.println("        Name: " + name);
        System.out.println("        Address: " + address + ", " + city + ", " + 
            state + " " + zipCode);
    }
    
    /**
     * Enter payment details
     */
    public void enterPaymentDetails(String cardNumber, String month, String year, 
                                     String nameOnCard) {
        wait.until(ExpectedConditions.visibilityOf(cardNumberInput));
        
        cardNumberInput.clear();
        cardNumberInput.sendKeys(cardNumber);
        
        cardMonthInput.clear();
        cardMonthInput.sendKeys(month);
        
        cardYearInput.clear();
        cardYearInput.sendKeys(year);
        
        nameOnCardInput.clear();
        nameOnCardInput.sendKeys(nameOnCard);
        
        System.out.println("STEP 9: Entered payment details");
        System.out.println("        Card: ****-****-****-" + 
            cardNumber.substring(Math.max(0, cardNumber.length() - 4)));
        System.out.println("        Expiry: " + month + "/" + year);
    }
    
    /**
     * Click Purchase Flight button
     */
    public void clickPurchaseFlight() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButton));
        purchaseButton.click();
        System.out.println("STEP 10: Clicked 'Purchase Flight' button");
    }
}