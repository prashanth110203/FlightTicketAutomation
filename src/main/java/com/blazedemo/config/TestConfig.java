package com.blazedemo.config;

public class TestConfig {
    
    // Application URL
    public static final String BASE_URL = "https://blazedemo.com/";
    
    // Timeout settings (in seconds)
    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 15;
    public static final int PAGE_LOAD_TIMEOUT = 30;
    
    // Browser settings
    public static final String BROWSER = "chrome";
    public static final boolean HEADLESS = false;
    
    // Excel file configuration
    public static final String EXCEL_FILE_PATH = "test-data/flightdata.xlsx";
    public static final String SHEET_NAME = "BookingData";
    
    // Screenshot folder
    public static final String SCREENSHOT_FOLDER = "screenshots";
    
    // Private constructor to prevent instantiation
    private TestConfig() {
        throw new IllegalStateException("Config class cannot be instantiated");
    }
}