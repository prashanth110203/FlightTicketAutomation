package com.blazedemo.utils;

import com.blazedemo.config.TestConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    
    private static int passCount = 0;
    private static int failCount = 0;
    
    /**
     * Capture screenshot with custom name
     */
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        String screenshotPath = null;
        
        if (driver == null) {
            System.out.println("⚠️ Cannot capture screenshot - Driver is null");
            return null;
        }
        
        try {
            // Create screenshots directory if not exists
            File screenshotDir = new File(TestConfig.SCREENSHOT_FOLDER);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
                System.out.println("Created screenshots directory");
            }
            
            // Generate filename with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = screenshotName + "_" + timestamp + ".png";
            screenshotPath = TestConfig.SCREENSHOT_FOLDER + File.separator + fileName;
            
            // Capture screenshot
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(screenshotPath);
            FileUtils.copyFile(sourceFile, destinationFile);
            
            System.out.println("📸 Screenshot saved: " + destinationFile.getAbsolutePath());
            
        } catch (IOException e) {
            System.err.println("❌ Failed to capture screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error during screenshot: " + e.getMessage());
        }
        
        return screenshotPath;
    }
    
    /**
     * Capture screenshot on test FAILURE
     */
    public static String captureScreenshotOnFailure(WebDriver driver, String testName) {
        failCount++;
        String fileName = "FAILED_" + failCount + "_" + testName;
        System.out.println("\n❌ TEST FAILED - Capturing Screenshot...");
        return captureScreenshot(driver, fileName);
    }
    
    /**
     * Capture screenshot on test PASS
     */
    public static String captureScreenshotOnSuccess(WebDriver driver, String testName) {
        passCount++;
        String fileName = "PASSED_" + passCount + "_" + testName;
        System.out.println("\n✅ TEST PASSED - Capturing Screenshot...");
        return captureScreenshot(driver, fileName);
    }
    
    /**
     * Capture screenshot with status prefix
     */
    public static String captureScreenshotWithStatus(WebDriver driver, String testName, String status) {
        String fileName = status.toUpperCase() + "_" + testName;
        return captureScreenshot(driver, fileName);
    }
    
    /**
     * Clean old screenshots older than specified days
     */
    public static void cleanOldScreenshots(int daysOld) {
        File screenshotDir = new File(TestConfig.SCREENSHOT_FOLDER);
        if (screenshotDir.exists()) {
            File[] files = screenshotDir.listFiles();
            if (files != null) {
                long cutoffTime = System.currentTimeMillis() - (daysOld * 24 * 60 * 60 * 1000L);
                int deletedCount = 0;
                for (File file : files) {
                    if (file.lastModified() < cutoffTime) {
                        file.delete();
                        deletedCount++;
                    }
                }
                if (deletedCount > 0) {
                    System.out.println("🗑️ Cleaned " + deletedCount + " old screenshots");
                }
            }
        }
    }
    
    /**
     * Get screenshot statistics
     */
    public static String getScreenshotStats() {
        return "Screenshots - Passed: " + passCount + " | Failed: " + failCount;
    }
    
    /**
     * Reset counters (call at start of test suite)
     */
    public static void resetCounters() {
        passCount = 0;
        failCount = 0;
    }
    
    /**
     * Get pass screenshot count
     */
    public static int getPassCount() {
        return passCount;
    }
    
    /**
     * Get fail screenshot count
     */
    public static int getFailCount() {
        return failCount;
    }
}