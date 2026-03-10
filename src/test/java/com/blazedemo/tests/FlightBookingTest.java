package com.blazedemo.tests;

import com.blazedemo.config.TestConfig;
import com.blazedemo.pages.*;
import com.blazedemo.utils.DriverManager;
import com.blazedemo.utils.ExcelReader;
import com.blazedemo.utils.ScreenshotUtil;
import com.blazedemo.utils.TestDataGenerator;
import com.blazedemo.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.util.List;
import java.util.Map;

@Listeners(TestListener.class)
public class FlightBookingTest {
    
    private WebDriver driver;
    private HomePage homePage;
    private FlightListPage flightListPage;
    private PurchasePage purchasePage;
    private ConfirmationPage confirmationPage;
    private static ExcelReader excelReader;
    private static int testNumber = 0;
    
    /**
     * Setup before entire test suite
     */
    @BeforeSuite
    public void setupSuite() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("BLAZEDEMO FLIGHT BOOKING AUTOMATION PROJECT");
        System.out.println("Wipro Training - Capstone Project");
        System.out.println("=".repeat(80));
        
        // Load Excel file
        excelReader = new ExcelReader(TestConfig.EXCEL_FILE_PATH, TestConfig.SHEET_NAME);
    }
    
    /**
     * Setup before each test method
     */
    @BeforeMethod
    public void setup() {
        // Initialize WebDriver
        driver = DriverManager.initializeDriver(TestConfig.BROWSER);
        
        // Initialize Page Objects
        homePage = new HomePage(driver);
        flightListPage = new FlightListPage(driver);
        purchasePage = new PurchasePage(driver);
        confirmationPage = new ConfirmationPage(driver);
        
        testNumber++;
    }
    
    /**
     * Main test method - End-to-End flight booking
     */
    @Test(dataProvider = "flightData", description = "End-to-End Flight Booking Test")
    public void testFlightBooking(Map<String, String> data) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("TEST EXECUTION #" + testNumber);
        System.out.println("=".repeat(80));
        
        // Extract test data from Excel
        String from = data.get("DepartureCity");
        String to = data.get("DestinationCity");
        String passenger = data.get("PassengerName");
        String flightSelection = data.get("FlightSelection");
        
        System.out.println("\nTest Scenario:");
        System.out.println("  Departure: " + from);
        System.out.println("  Destination: " + to);
        System.out.println("  Passenger: " + passenger);
        System.out.println("  Flight Selection Method: " + flightSelection);
        System.out.println("\n" + "-".repeat(80) + "\n");
        
        // Step 1-4: Home page interactions
        homePage.navigateToHomePage(TestConfig.BASE_URL);
        homePage.selectDepartureCity(from);
        homePage.selectDestinationCity(to);
        homePage.clickFindFlights();
        
        // Step 5: Verify flight list
        Assert.assertTrue(flightListPage.isFlightListDisplayed(), 
            "Flight list not displayed");
        
        // Step 6: Select flight based on strategy
        selectFlight(flightSelection);
        
        // Step 7: Verify purchase page
        Assert.assertTrue(purchasePage.isPurchasePageDisplayed(), 
            "Purchase page not displayed");
        
        // Step 8: Enter personal details
        purchasePage.enterPersonalDetails(
            passenger,
            TestDataGenerator.generateAddress(),
            TestDataGenerator.generateCity(),
            TestDataGenerator.generateState(),
            TestDataGenerator.generateZipCode()
        );
        
        // Step 9: Enter payment details
        purchasePage.enterPaymentDetails(
            TestDataGenerator.generateCardNumber(),
            TestDataGenerator.generateMonth(),
            TestDataGenerator.generateYear(),
            TestDataGenerator.generateNameOnCard()
        );
        
        // Step 10: Purchase flight
        purchasePage.clickPurchaseFlight();
        
        // Step 11: Verify confirmation
        Assert.assertTrue(confirmationPage.isBookingConfirmed(), 
            "Booking confirmation not received");
        
        System.out.println("=".repeat(80));
        System.out.println("TEST #" + testNumber + " COMPLETED SUCCESSFULLY");
        System.out.println("Flight booked: " + from + " -> " + to + " for " + passenger);
        System.out.println("=".repeat(80) + "\n");
    }
    
    /**
     * Select flight based on strategy from Excel
     */
    private void selectFlight(String selectionMethod) {
        if (selectionMethod == null || selectionMethod.trim().isEmpty()) {
            selectionMethod = "1";
        }
        
        String method = selectionMethod.trim().toUpperCase();
        
        switch (method) {
            case "1":
            case "FIRST":
                flightListPage.selectFlightByIndex(1);
                break;
                
            case "2":
            case "SECOND":
                flightListPage.selectFlightByIndex(2);
                break;
                
            case "3":
            case "THIRD":
                flightListPage.selectFlightByIndex(3);
                break;
                
            case "4":
            case "FOURTH":
                flightListPage.selectFlightByIndex(4);
                break;
                
            case "5":
            case "FIFTH":
                flightListPage.selectFlightByIndex(5);
                break;
                
            case "RANDOM":
                flightListPage.selectRandomFlight();
                break;
                
            case "SEQUENTIAL":
            case "NEXT":
                flightListPage.selectNextFlight();
                break;
                
            case "CHEAPEST":
            case "LOWEST":
                flightListPage.selectCheapestFlight();
                break;
                
            case "EXPENSIVE":
            case "HIGHEST":
            case "MOST EXPENSIVE":
                flightListPage.selectMostExpensiveFlight();
                break;
                
            default:
                // Try to parse as number
                try {
                    int index = Integer.parseInt(method);
                    if (index >= 1 && index <= 5) {
                        flightListPage.selectFlightByIndex(index);
                    } else {
                        System.out.println("Invalid index " + index + ", defaulting to first flight");
                        flightListPage.selectFlightByIndex(1);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Unknown selection method '" + selectionMethod + "', defaulting to first flight");
                    flightListPage.selectFlightByIndex(1);
                }
                break;
        }
    }
    
    /**
     * Data provider - reads test data from Excel
     */
    @DataProvider(name = "flightData")
    public Object[][] flightData() {
        List<Map<String, String>> dataList = excelReader.getAllRowsAsMaps();
        Object[][] data = new Object[dataList.size()][1];
        
        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i);
        }
        
        return data;
    }
    
    /**
     * Cleanup after each test method
     * Screenshots are captured by TestListener automatically
     */
    @AfterMethod
    public void teardown(ITestResult result) {
        // Note: Screenshots are now handled by TestListener
        // This method only handles browser cleanup
        
        // Quit browser
        DriverManager.quitDriver();
    }
    
    /**
     * Cleanup after entire test suite
     */
    @AfterSuite
    public void teardownSuite() {
        if (excelReader != null) {
            excelReader.close();
        }
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("TEST SUITE EXECUTION COMPLETED");
        System.out.println("Total Tests Executed: " + testNumber);
        System.out.println("📸 Screenshots: " + ScreenshotUtil.getScreenshotStats());
        System.out.println("📁 Screenshots Folder: " + TestConfig.SCREENSHOT_FOLDER);
        System.out.println("=".repeat(80) + "\n");
    }
}