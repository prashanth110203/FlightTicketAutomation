package com.blazedemo.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    
    @Override
    public void onStart(ITestContext context) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("TEST SUITE STARTED: " + context.getName());
        System.out.println("=".repeat(80) + "\n");
        
        // Reset screenshot counters
        ScreenshotUtil.resetCounters();
        
        // Clean old screenshots (older than 7 days)
        ScreenshotUtil.cleanOldScreenshots(7);
    }
    
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("TEST SUITE FINISHED: " + context.getName());
        System.out.println("-".repeat(80));
        System.out.println("Total: " + context.getAllTestMethods().length + 
                         " | Passed: " + context.getPassedTests().size() + 
                         " | Failed: " + context.getFailedTests().size() + 
                         " | Skipped: " + context.getSkippedTests().size());
        System.out.println("-".repeat(80));
        System.out.println("📸 " + ScreenshotUtil.getScreenshotStats());
        System.out.println("=".repeat(80) + "\n");
    }
    
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("STARTING: " + result.getMethod().getMethodName());
        System.out.println("-".repeat(80));
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        long duration = (result.getEndMillis() - result.getStartMillis()) / 1000;
        System.out.println("\n" + "-".repeat(80));
        System.out.println("✅ PASSED: " + result.getMethod().getMethodName() + 
                         " (Duration: " + duration + "s)");
        
        // Capture screenshot on PASS
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            String testName = result.getMethod().getMethodName();
            String screenshotPath = ScreenshotUtil.captureScreenshotOnSuccess(driver, testName);
            if (screenshotPath != null) {
                System.out.println("📍 Screenshot Location: " + screenshotPath);
            }
        }
        
        System.out.println("-".repeat(80) + "\n");
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("❌ FAILED: " + result.getMethod().getMethodName());
        System.out.println("Error: " + result.getThrowable().getMessage());
        System.out.println("=".repeat(80));
        
        // Capture screenshot on FAILURE
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            String testName = result.getMethod().getMethodName();
            String screenshotPath = ScreenshotUtil.captureScreenshotOnFailure(driver, testName);
            if (screenshotPath != null) {
                System.out.println("📍 Screenshot Location: " + screenshotPath);
            }
        }
        
        System.out.println("=".repeat(80) + "\n");
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("⚠️ SKIPPED: " + result.getMethod().getMethodName());
        
        if (result.getThrowable() != null) {
            System.out.println("Reason: " + result.getThrowable().getMessage());
        }
        
        System.out.println("-".repeat(80) + "\n");
    }
}