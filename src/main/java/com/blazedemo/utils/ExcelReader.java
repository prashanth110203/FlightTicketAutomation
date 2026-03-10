package com.blazedemo.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    
    private Workbook workbook;
    private Sheet sheet;
    
    /**
     * Constructor - Load Excel file
     */
    public ExcelReader(String excelFilePath, String sheetName) {
        try {
            File file = new File(excelFilePath);
            if (!file.exists()) {
                throw new RuntimeException("Excel file not found: " + excelFilePath);
            }
            
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }
            
            System.out.println("Excel loaded successfully: " + excelFilePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load Excel file", e);
        }
    }
    
    /**
     * Get all rows as List of Maps
     */
    public List<Map<String, String>> getAllRowsAsMaps() {
        List<Map<String, String>> dataList = new ArrayList<>();
        Row headerRow = sheet.getRow(0);
        int columnCount = headerRow.getLastCellNum();
        
        // Get column names from header
        List<String> columnNames = new ArrayList<>();
        for (int i = 0; i < columnCount; i++) {
            columnNames.add(headerRow.getCell(i).getStringCellValue().trim());
        }
        
        // Read data rows
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row == null) continue;
            
            Map<String, String> rowData = new HashMap<>();
            for (int colIndex = 0; colIndex < columnCount; colIndex++) {
                Cell cell = row.getCell(colIndex);
                String columnName = columnNames.get(colIndex);
                String cellValue = getCellValueAsString(cell);
                rowData.put(columnName, cellValue);
            }
            dataList.add(rowData);
        }
        
        System.out.println("Loaded " + dataList.size() + " test records from Excel");
        return dataList;
    }
    
    /**
     * Get cell value as String
     */
    private String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                double value = cell.getNumericCellValue();
                if (value == Math.floor(value)) {
                    return String.valueOf((long) value);
                }
                return String.valueOf(value);
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
    
    /**
     * Close workbook
     */
    public void close() {
        try {
            if (workbook != null) {
                workbook.close();
                System.out.println("Excel workbook closed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}