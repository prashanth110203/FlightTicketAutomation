# ✈️ BlazeDemo Flight Booking Automation

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)]()
[![Java](https://img.shields.io/badge/Java-11-orange.svg)]()
[![Selenium](https://img.shields.io/badge/Selenium-4.15.0-green.svg)]()
[![TestNG](https://img.shields.io/badge/TestNG-7.8.0-red.svg)]()
[![Maven](https://img.shields.io/badge/Maven-3.x-blue.svg)]()
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)]()

> **Complete end-to-end test automation framework for BlazeDemo flight booking application using Selenium WebDriver, Java, TestNG, and Data-Driven Testing approach.**

---

## 📋 Table of Contents

- [About the Project](#-about-the-project)
- [Features](#-features)
- [Technologies Used](#-technologies-used)
- [Project Architecture](#-project-architecture)
- [Getting Started](#-getting-started)
- [Running Tests](#-running-tests)
- [Test Scenarios](#-test-scenarios)
- [Flight Selection Strategies](#-flight-selection-strategies)
- [Test Reports](#-test-reports)
- [Screenshots](#-screenshots)
- [Jenkins CI/CD Integration](#-jenkins-cicd-integration)
- [Project Structure](#-project-structure)
- [Troubleshooting](#-troubleshooting)
- [Author](#-author)

---

## 🎯 About the Project

This is a **comprehensive test automation framework** developed as part of the **Wipro Pre-Skilling Capstone Project**. The framework automates the complete flight booking workflow on the [BlazeDemo](https://blazedemo.com/) application.

### What This Project Does:

- ✈️ Automates end-to-end flight booking process
- 📊 Reads test data from Excel files (Data-Driven Testing)
- 🎯 Implements multiple flight selection strategies
- 📸 Captures screenshots on both test pass and failure
- 📈 Generates detailed test reports with TestNG
- 🔄 Integrates seamlessly with Jenkins for CI/CD
- 🏗️ Follows Page Object Model (POM) design pattern

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| 🎨 **Page Object Model** | Clean, maintainable code structure |
| 📊 **Data-Driven Testing** | Excel-based test data management |
| 🎯 **Multiple Selection Strategies** | 7+ ways to select flights |
| 📸 **Smart Screenshots** | Automatic capture on pass/fail |
| 📈 **Detailed Reporting** | TestNG HTML & Surefire reports |
| 🔄 **CI/CD Ready** | Jenkins pipeline integration |
| 🛡️ **Robust Wait Strategies** | Explicit & implicit waits |
| 📝 **Comprehensive Logging** | Step-by-step console output |
| 🔧 **Easy Configuration** | Centralized config management |
| 🚀 **Maven Build** | Dependency & lifecycle management |

---

## 🛠️ Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 11 | Programming Language |
| **Selenium WebDriver** | 4.15.0 | Browser Automation |
| **TestNG** | 7.8.0 | Testing Framework |
| **Maven** | 3.9.x | Build Management |
| **Apache POI** | 5.2.4 | Excel File Handling |
| **WebDriverManager** | 5.6.2 | Driver Management |
| **Jenkins** | Latest | CI/CD Automation |
| **Git** | Latest | Version Control |

---

## 🏗️ Project Architecture

### High-Level Architecture
+------------------------------------------------------------------+
| TEST AUTOMATION FRAMEWORK |
+------------------------------------------------------------------+
| |
| +--------------+ +--------------+ +--------------+ |
| | TestNG | --> | Test Class | --> | Page | |
| | Suite | | | | Objects | |
| +--------------+ +--------------+ +--------------+ |
| | | | |
| v v v |
| +--------------+ +--------------+ +--------------+ |
| | Excel | | Utilities | | WebDriver | |
| | Data Reader | | Manager | | Manager | |
| +--------------+ +--------------+ +--------------+ |
| | | | |
| +--------------------+--------------------+ |
| | |
| v |
| +--------------+ |
| | BlazeDemo | |
| | Application | |
| +--------------+ |
| |
+------------------------------------------------------------------+

text


### Layered Architecture
+------------------------------------------------------------------+
| PRESENTATION LAYER |
| (TestNG Test Suite) |
| - testng.xml |
| - Test Listeners |
| - Test Annotations |
+------------------------------------------------------------------+
|
v
+------------------------------------------------------------------+
| TEST EXECUTION LAYER |
| (FlightBookingTest.java) |
| - Test Methods |
| - Data Provider |
| - Assertions |
+------------------------------------------------------------------+
|
v
+------------------------------------------------------------------+
| PAGE OBJECT LAYER |
| |
| +----------------+ +----------------+ +----------------+ |
| | HomePage | | FlightListPage | | PurchasePage | |
| +----------------+ +----------------+ +----------------+ |
| +----------------+ |
| |ConfirmationPage| |
| +----------------+ |
+------------------------------------------------------------------+
|
v
+------------------------------------------------------------------+
| UTILITY LAYER |
| |
| +----------------+ +----------------+ +----------------+ |
| | DriverManager | | ExcelReader | | ScreenshotUtil | |
| +----------------+ +----------------+ +----------------+ |
| +----------------+ +----------------+ +----------------+ |
| | TestListener | | DataGenerator | |ExcelFileCreator| |
| +----------------+ +----------------+ +----------------+ |
+------------------------------------------------------------------+
|
v
+------------------------------------------------------------------+
| CONFIGURATION LAYER |
| (TestConfig.java) |
| - Base URL |
| - Browser Settings |
| - Timeout Configuration |
| - File Paths |
+------------------------------------------------------------------+
|
v
+------------------------------------------------------------------+
| WEB APPLICATION LAYER |
| (BlazeDemo Website) |
| https://blazedemo.com/ |
+------------------------------------------------------------------+

text


### Page Object Model Design
+------------------------------------------------------------------+
| PAGE OBJECT MODEL (POM) |
+------------------------------------------------------------------+
| |
| FlightBookingTest.java |
| | |
| | uses |
| v |
| +--------------------------------------------------------------+|
| | PAGE OBJECT CLASSES ||
| | ||
| | +------------------------+ ||
| | | HomePage.java | ||
| | | - @FindBy elements | ||
| | | - navigateToHome() | ||
| | | - selectDeparture() | ||
| | | - selectDestination()| ||
| | | - clickFindFlights()| ||
| | +------------------------+ ||
| | ||
| | +------------------------+ ||
| | | FlightListPage.java | ||
| | | - @FindBy elements | ||
| | | - isFlightDisplayed()| ||
| | | - selectByIndex() | ||
| | | - selectRandom() | ||
| | | - selectCheapest() | ||
| | +------------------------+ ||
| | ||
| | +------------------------+ ||
| | | PurchasePage.java | ||
| | | - @FindBy elements | ||
| | | - enterPersonalInfo()| ||
| | | - enterPaymentInfo()| ||
| | | - clickPurchase() | ||
| | +------------------------+ ||
| | ||
| | +------------------------+ ||
| | | ConfirmationPage.java | ||
| | | - @FindBy elements | ||
| | | - isConfirmed() | ||
| | | - getConfirmationId()| ||
| | +------------------------+ ||
| +--------------------------------------------------------------+|
| | |
| | interacts with |
| v |
| +------------------------+ |
| | WebDriver (Chrome) | |
| +------------------------+ |
| | |
| v |
| +------------------------+ |
| | BlazeDemo Website | |
| +------------------------+ |
| |
+------------------------------------------------------------------+

Benefits:

Code Reusability
Easy Maintenance
Separation of Concerns
Reduced Code Duplication
Better Readability
text


### Test Execution Flow
+------------------------------------------------------------------+
| TEST EXECUTION FLOW |
+------------------------------------------------------------------+

START
|
+--> [1] Load TestNG Suite (testng.xml)
|
+--> [2] Execute @BeforeSuite
| |
| +--> Load Excel file (flightdata.xlsx)
|
+--> [3] FOR EACH TEST DATA ROW (5 iterations)
| |
| +--> [4] Execute @BeforeMethod
| | |
| | +--> Initialize Chrome WebDriver
| | +--> Initialize Page Objects
| |
| +--> [5] Execute @Test Method
| | |
| | +--> STEP 1: Navigate to BlazeDemo
| | +--> STEP 2: Select departure city
| | +--> STEP 3: Select destination city
| | +--> STEP 4: Click Find Flights
| | +--> STEP 5: Verify flight list
| | +--> STEP 6: Select flight
| | +--> STEP 7: Verify purchase page
| | +--> STEP 8: Enter personal details
| | +--> STEP 9: Enter payment details
| | +--> STEP 10: Click Purchase
| | +--> STEP 11: Verify confirmation
| |
| +--> [6] Execute @AfterMethod
| |
| +--> Capture screenshot (PASS/FAIL)
| +--> Quit WebDriver
|
+--> [7] Execute @AfterSuite
| |
| +--> Close Excel workbook
| +--> Display statistics
|
+--> [8] Generate Reports
|
+--> TestNG HTML Report
+--> Surefire XML Report
+--> Screenshots

END

text


---

## 🚀 Getting Started

### Prerequisites

| Software | Version | Download |
|----------|---------|----------|
| Java JDK | 11+ | [Download](https://adoptium.net/) |
| Maven | 3.6+ | [Download](https://maven.apache.org/) |
| Git | Latest | [Download](https://git-scm.com/) |
| Chrome | Latest | [Download](https://google.com/chrome/) |

**Verify Installation:**

```bash
java -version
mvn -version
git --version
Installation
Step 1: Clone Repository

Bash

git clone https://github.com/prashanth110203/FlightTicketAutomation.git
cd FlightTicketAutomation
Step 2: Install Dependencies

Bash

mvn clean install
Step 3: Create Test Data

Bash

mvn exec:java -Dexec.mainClass="com.blazedemo.utils.ExcelFileCreator"
▶️ Running Tests
Using Maven
Bash

# Run all tests
mvn clean test

# Run specific test
mvn -Dtest=FlightBookingTest test
Using Eclipse IDE
Right-click on FlightBookingTest.java
Select Run As → TestNG Test
Using TestNG XML
Right-click on testng.xml
Select Run As → TestNG Suite
🧪 Test Scenarios
Test Flow (11 Steps)
Step	Action	Description
1	Navigate	Open BlazeDemo website
2	Select Departure	Choose departure city
3	Select Destination	Choose destination city
4	Find Flights	Click Find Flights button
5	Verify List	Confirm flights displayed
6	Select Flight	Choose flight by strategy
7	Verify Purchase	Confirm purchase page
8	Personal Details	Enter passenger info
9	Payment Details	Enter card info
10	Purchase	Click Purchase button
11	Confirm	Verify booking success
Test Data (Excel)
Departure	Destination	Passenger	Selection
Paris	Buenos Aires	John Smith	1
Boston	London	Jane Doe	2
Portland	Dublin	Michael Johnson	RANDOM
Philadelphia	Rome	Sarah Williams	CHEAPEST
San Diego	Cairo	David Brown	3
🎯 Flight Selection Strategies
Strategy	Keyword	Description
Index	1, 2, 3, 4, 5	Select by position
Random	RANDOM	Random selection
Cheapest	CHEAPEST	Lowest price
Expensive	EXPENSIVE	Highest price
Sequential	SEQUENTIAL	Rotate through
First	FIRST	Always first
Named	SECOND, THIRD	By name
📊 Test Reports
TestNG Report
Location: test-output/index.html

Bash

# Open report
start test-output/index.html
Surefire Report
Location: target/surefire-reports/

Bash

# Generate report
mvn surefire-report:report
Console Output Example
text

================================================================================
TEST EXECUTION #1
================================================================================
Test Scenario:
  Departure: Paris
  Destination: Buenos Aires
  Passenger: John Smith
  Flight Selection Method: 1
--------------------------------------------------------------------------------

STEP 1: Navigated to BlazeDemo
STEP 2: Selected Departure City: Paris
STEP 3: Selected Destination City: Buenos Aires
STEP 4: Clicked 'Find Flights' button
STEP 5: Flight list displayed (5 flights available)

        --------------------------------------------------
        | # | Airline            | Price     |
        --------------------------------------------------
        | 1 | Virgin America     | $472.56   |
        | 2 | United Airlines    | $432.98   |
        | 3 | Aer Lingus         | $200.98   |
        | 4 | Virgin America     | $765.32   |
        | 5 | Lufthansa          | $233.98   |
        --------------------------------------------------

STEP 6: Selected Flight #1
        Airline: Virgin America | Price: $472.56
STEP 7: Purchase page displayed
STEP 8: Entered personal details
STEP 9: Entered payment details
STEP 10: Clicked 'Purchase Flight'
STEP 11: Booking Confirmation Received

        ==================================================
        BOOKING CONFIRMATION DETAILS
        ==================================================
        Confirmation ID: 1773142719291
        Status: PendingCapture
        Total Amount: 555 USD
        ==================================================

================================================================================
TEST #1 COMPLETED SUCCESSFULLY
Flight booked: Paris -> Buenos Aires for John Smith
================================================================================
📸 Screenshots
Screenshot Capture
Event	Naming	Location
Pass	PASSED_1_testName_timestamp.png	screenshots/
Fail	FAILED_1_testName_timestamp.png	screenshots/
Example Files
text

screenshots/
├── PASSED_1_testFlightBooking_20260310_165328.png
├── PASSED_2_testFlightBooking_20260310_165333.png
├── PASSED_3_testFlightBooking_20260310_165338.png
├── PASSED_4_testFlightBooking_20260310_165344.png
└── PASSED_5_testFlightBooking_20260310_165349.png
🔄 Jenkins CI/CD Integration
Pipeline Stages
text

+-------------+
|  Checkout   |  <-- Clone from GitHub
+------+------+
       |
+------v------+
|    Clean    |  <-- Clean workspace
+------+------+
       |
+------v------+
|   Compile   |  <-- Compile code
+------+------+
       |
+------v------+
|Create Excel |  <-- Generate test data
+------+------+
       |
+------v------+
|  Run Tests  |  <-- Execute tests
+------+------+
       |
+------v------+
|   Publish   |  <-- Archive results
+-------------+
Jenkins Setup
Install Jenkins from https://jenkins.io
Install plugins: Maven, Git, TestNG Results
Create Pipeline job
Configure SCM: https://github.com/prashanth110203/FlightTicketAutomation.git
Set Script Path: Jenkinsfile
Click Build Now
Build Output
text

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
Total time: 42.68 s
📁 Project Structure
text

FlightTicketAutomation/
|
+-- src/
|   +-- main/java/com/blazedemo/
|   |   +-- config/
|   |   |   +-- TestConfig.java
|   |   +-- pages/
|   |   |   +-- HomePage.java
|   |   |   +-- FlightListPage.java
|   |   |   +-- PurchasePage.java
|   |   |   +-- ConfirmationPage.java
|   |   +-- utils/
|   |       +-- DriverManager.java
|   |       +-- ExcelReader.java
|   |       +-- ExcelFileCreator.java
|   |       +-- TestDataGenerator.java
|   |       +-- ScreenshotUtil.java
|   |       +-- TestListener.java
|   |
|   +-- test/java/com/blazedemo/
|       +-- tests/
|           +-- FlightBookingTest.java
|
+-- test-data/
|   +-- flightdata.xlsx
|
+-- screenshots/
|
+-- test-output/
|
+-- pom.xml
+-- testng.xml
+-- Jenkinsfile
+-- README.md
📊 Test Statistics
Metric	Value
Total Tests	5
Passed	5 (100%)
Failed	0
Skipped	0
Execution Time	~42 seconds
Screenshots	5 captured
🐛 Troubleshooting
Issue	Solution
Excel not found	Run ExcelFileCreator
ChromeDriver error	WebDriverManager handles it
Tests not running	Check testng.xml
Dependencies fail	Run mvn clean install -U
🚀 Quick Start
Bash

# Clone
git clone https://github.com/prashanth110203/FlightTicketAutomation.git
cd FlightTicketAutomation

# Install
mvn clean install

# Create test data
mvn exec:java -Dexec.mainClass="com.blazedemo.utils.ExcelFileCreator"

# Run tests
mvn test

# View report
start test-output/index.html
👨‍💻 Author
Prashanth

GitHub: @prashanth110203
Project: FlightTicketAutomation
📜 License
This project is licensed under the MIT License.

🙏 Acknowledgments
Wipro - Training opportunity
BlazeDemo - Test application
Selenium - Automation tools
TestNG - Testing framework
🎓 Learning Outcomes
✅ Selenium WebDriver automation
✅ Page Object Model design
✅ Data-Driven Testing
✅ TestNG framework
✅ Maven project management
✅ CI/CD with Jenkins
✅ Screenshot capture
✅ Test reporting
<p align="center"> <b>⭐ Star this repository if you found it helpful!</b> <br><br> <b>Made with ❤️ by Prashanth</b> <br> <b>Wipro Pre-Skilling Program - Capstone Project</b> </p> ```

