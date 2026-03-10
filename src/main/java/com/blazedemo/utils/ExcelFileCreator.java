package com.blazedemo.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFileCreator {
    
    public static void main(String[] args) {
        createFlightDataFile();
    }
    
    public static void createFlightDataFile() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("BookingData");
        
        // Create header style
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"DepartureCity", "DestinationCity", "PassengerName", "FlightSelection"};
        
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
        
        // Test data
        Object[][] testData = {
            {"Paris", "Buenos Aires", "John Smith", "1"},
            {"Boston", "London", "Jane Doe", "2"},
            {"Portland", "Dublin", "Michael Johnson", "RANDOM"},
            {"Philadelphia", "Rome", "Sarah Williams", "CHEAPEST"},
            {"San Diego", "Cairo", "David Brown", "3"}
        };
        
        // Create data rows
        for (int i = 0; i < testData.length; i++) {
            Row row = sheet.createRow(i + 1);
            Object[] rowData = testData[i];
            
            for (int j = 0; j < rowData.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(rowData[j].toString());
            }
        }
        
        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
        
        // Write to file
        try {
            File directory = new File("test-data");
            if (!directory.exists()) {
                directory.mkdir();
                System.out.println("Created test-data directory");
            }
            
            String filePath = "test-data/flightdata.xlsx";
            File excelFile = new File(filePath);
            
            if (excelFile.exists()) {
                excelFile.delete();
            }
            
            FileOutputStream fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            
            System.out.println("=".repeat(80));
            System.out.println("SUCCESS: Excel file created!");
            System.out.println("Location: " + excelFile.getAbsolutePath());
            System.out.println("Sheet Name: BookingData");
            System.out.println("Total records: " + testData.length);
            System.out.println("=".repeat(80));
            System.out.println("\nFlight Selection Options:");
            System.out.println("  1-5      : Select specific flight number");
            System.out.println("  RANDOM   : Select random flight");
            System.out.println("  CHEAPEST : Select lowest price");
            System.out.println("  EXPENSIVE: Select highest price");
            System.out.println("=".repeat(80));
            
        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}