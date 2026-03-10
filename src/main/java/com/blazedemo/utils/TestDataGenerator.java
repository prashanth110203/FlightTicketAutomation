package com.blazedemo.utils;

import java.util.Random;

public class TestDataGenerator {
    
    private static final Random random = new Random();
    
    public static String generateName() {
        String[] names = {"John Smith", "Jane Doe", "Michael Johnson", "Sarah Williams", "David Brown"};
        return names[random.nextInt(names.length)];
    }
    
    public static String generateAddress() {
        return (100 + random.nextInt(9900)) + " Main Street";
    }
    
    public static String generateCity() {
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix"};
        return cities[random.nextInt(cities.length)];
    }
    
    public static String generateState() {
        String[] states = {"NY", "CA", "IL", "TX", "AZ", "FL", "PA", "OH"};
        return states[random.nextInt(states.length)];
    }
    
    public static String generateZipCode() {
        return String.format("%05d", random.nextInt(100000));
    }
    
    public static String generateCardNumber() {
        // Generate valid-looking test card number
        return "4532123456789012";
    }
    
    public static String generateMonth() {
        return String.format("%02d", random.nextInt(12) + 1);
    }
    
    public static String generateYear() {
        return String.valueOf(2024 + random.nextInt(5));
    }
    
    public static String generateNameOnCard() {
        return generateName();
    }
}