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

- [About the Project](#about-the-project)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Architecture](#project-architecture)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Scenarios](#test-scenarios)
- [Flight Selection Strategies](#flight-selection-strategies)
- [Test Reports](#test-reports)
- [Screenshots](#screenshots)
- [Jenkins CI/CD Integration](#jenkins-cicd-integration)
- [Project Structure](#project-structure)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [Author](#author)
- [License](#license)

---

## 🎯 About the Project

This is a **comprehensive test automation framework** developed as part of the **Wipro Pre-Skilling Capstone Project**. The framework automates the complete flight booking workflow on the [BlazeDemo](https://blazedemo.com/) application, demonstrating industry-standard automation practices.

### **What This Project Does:**

1. ✈️ Automates end-to-end flight booking process
2. 📊 Reads test data from Excel files (Data-Driven Testing)
3. 🎯 Implements multiple flight selection strategies (Index, Random, Cheapest, etc.)
4. 📸 Captures screenshots on both test pass and failure
5. 📈 Generates detailed test reports with TestNG
6. 🔄 Integrates seamlessly with Jenkins for CI/CD
7. 🏗️ Follows Page Object Model (POM) design pattern

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| **🎨 Page Object Model** | Clean, maintainable code structure |
| **📊 Data-Driven Testing** | Excel-based test data management |
| **🎯 Multiple Selection Strategies** | 7+ ways to select flights |
| **📸 Smart Screenshots** | Automatic capture on pass/fail |
| **📈 Detailed Reporting** | TestNG HTML & Surefire reports |
| **🔄 CI/CD Ready** | Jenkins pipeline integration |
| **🛡️ Robust Wait Strategies** | Explicit & implicit waits |
| **📝 Comprehensive Logging** | Step-by-step console output |
| **🔧 Easy Configuration** | Centralized config management |
| **🚀 Maven Build** | Dependency & lifecycle management |

---

## 🛠️ Technologies Used

### **Core Technologies:**

| Technology | Version | Purpose |
|------------|---------|---------|
| ![Java](https://img.shields.io/badge/Java-11-orange?logo=java) | 11 | Programming Language |
| ![Selenium](https://img.shields.io/badge/Selenium-4.15.0-green?logo=selenium) | 4.15.0 | Browser Automation |
| ![TestNG](https://img.shields.io/badge/TestNG-7.8.0-red) | 7.8.0 | Testing Framework |
| ![Maven](https://img.shields.io/badge/Maven-3.x-blue?logo=apachemaven) | 3.9.x | Build & Dependency Management |
| ![Apache POI](https://img.shields.io/badge/Apache_POI-5.2.4-yellow) | 5.2.4 | Excel File Handling |

### **Additional Tools:**

- **WebDriverManager** (5.6.2) - Automatic driver management
- **Apache Commons IO** (2.15.0) - File operations
- **Git** - Version control
- **Jenkins** - CI/CD automation

---

## 🏗️ Project Architecture

### **High-Level Architecture**
╔═══════════════════════════════════════════════════════════════╗
║ Test Automation Framework Architecture ║
╠═══════════════════════════════════════════════════════════════╣
║ ║
║ ┌─────────────┐ ┌─────────────┐ ┌────────────┐ ║
║ │ TestNG │ ───▶ │ Test Class │ ───▶ │ Page │ ║
║ │ Suite │ │ │ │ Objects │ ║
║ └─────────────┘ └─────────────┘ └────────────┘ ║
║ │ │ │ ║
║ │ │ │ ║
║ ▼ ▼ ▼ ║
║ ┌─────────────┐ ┌─────────────┐ ┌────────────┐ ║
║ │ Excel │ │ Utilities │ │ WebDriver │ ║
║ │ Data Reader │ │ Manager │ │ Manager │ ║
║ └─────────────┘ └─────────────┘ └────────────┘ ║
║ │ │ │ ║
║ └─────────────────────┼─────────────────────┘ ║
║ │ ║
║ ▼ ║
║ ┌─────────────┐ ║
║ │ BlazeDemo │ ║
║ │ Application │ ║
║ └─────────────┘ ║
║ ║
╚═══════════════════════════════════════════════════════════════╝

text


### **Layered Architecture**
┌───────────────────────────────────────────────────────────────┐
│ PRESENTATION LAYER │
│ (TestNG Test Suite) │
│ • testng.xml │
│ • Test Listeners │
│ • Test Annotations │
└────────────────────────┬──────────────────────────────────────┘
│
┌────────────────────────▼──────────────────────────────────────┐
│ TEST EXECUTION LAYER │
│ (FlightBookingTest.java) │
│ • Test Methods │
│ • Data Provider (@DataProvider) │
│ • Test Lifecycle Management │
│ • Assertions & Validations │
└────────────────────────┬──────────────────────────────────────┘
│
┌────────────────────────▼──────────────────────────────────────┐
│ PAGE OBJECT LAYER │
│ ┌──────────────┐ ┌──────────────┐ ┌──────────────┐ │
│ │ HomePage │ │ FlightList │ │ Purchase │ │
│ │ │ │ Page │ │ Page │ │
│ │ • Elements │ │ • Elements │ │ • Elements │ │
│ │ • Methods │ │ • Methods │ │ • Methods │ │
│ └──────────────┘ └──────────────┘ └──────────────┘ │
│ ┌──────────────┐ │
│ │ Confirmation │ │
│ │ Page │ │
│ │ • Elements │ │
│ │ • Methods │ │
│ └──────────────┘ │
└────────────────────────┬──────────────────────────────────────┘
│
┌────────────────────────▼──────────────────────────────────────┐
│ UTILITY LAYER │
│ ┌──────────────┐ ┌──────────────┐ ┌──────────────┐ │
│ │ Driver │ │ Excel │ │ Screenshot │ │
│ │ Manager │ │ Reader │ │ Util │ │
│ └──────────────┘ └──────────────┘ └──────────────┘ │
│ ┌──────────────┐ ┌──────────────┐ ┌──────────────┐ │
│ │ Test │ │ Data │ │ Excel │ │
│ │ Listener │ │ Generator │ │ File Creator │ │
│ └──────────────┘ └──────────────┘ └──────────────┘ │
└────────────────────────┬──────────────────────────────────────┘
│
┌────────────────────────▼──────────────────────────────────────┐
│ CONFIGURATION LAYER │
│ (TestConfig.java) │
│ • Base URL • Browser Settings │
│ • Timeout Configuration • File Paths │
│ • Screenshot Settings • Excel Configuration │
└────────────────────────┬──────────────────────────────────────┘
│
┌────────────────────────▼──────────────────────────────────────┐
│ WEB APPLICATION LAYER │
│ (BlazeDemo Website) │
│ • https://blazedemo.com/ │
│ • Flight Booking Application │
└───────────────────────────────────────────────────────────────┘

text


### **Page Object Model Design**
┌─────────────────────────────────────────────────────────────┐
│ PAGE OBJECT MODEL STRUCTURE │
└─────────────────────────────────────────────────────────────┘

text

FlightBookingTest.java
        │
        │ creates & uses
        │
        ▼
┌───────────────────────────────────────┐
│       Page Object Classes             │
│                                       │
│  ┌─────────────────────────────────┐ │
│  │  HomePage.java                  │ │
│  │  • @FindBy elements             │ │
│  │  • navigateToHomePage()         │ │
│  │  • selectDepartureCity()        │ │
│  │  • selectDestinationCity()      │ │
│  │  • clickFindFlights()           │ │
│  └─────────────────────────────────┘ │
│                                       │
│  ┌─────────────────────────────────┐ │
│  │  FlightListPage.java            │ │
│  │  • @FindBy elements             │ │
│  │  • isFlightListDisplayed()      │ │
│  │  • selectFlightByIndex()        │ │
│  │  • selectRandomFlight()         │ │
│  │  • selectCheapestFlight()       │ │
│  │  • selectMostExpensiveFlight()  │ │
│  │  • displayFlightTable()         │ │
│  └─────────────────────────────────┘ │
│                                       │
│  ┌─────────────────────────────────┐ │
│  │  PurchasePage.java              │ │
│  │  • @FindBy elements             │ │
│  │  • isPurchasePageDisplayed()    │ │
│  │  • enterPersonalDetails()       │ │
│  │  • enterPaymentDetails()        │ │
│  │  • clickPurchaseFlight()        │ │
│  └─────────────────────────────────┘ │
│                                       │
│  ┌─────────────────────────────────┐ │
│  │  ConfirmationPage.java          │ │
│  │  • @FindBy elements             │ │
│  │  • isBookingConfirmed()         │ │
│  │  • getConfirmationId()          │ │
│  │  • displayConfirmationDetails() │ │
│  └─────────────────────────────────┘ │
└───────────────────────────────────────┘
        │
        │ interacts with
        │
        ▼
┌───────────────────────────────────────┐
│     WebDriver (ChromeDriver)          │
└───────────┬───────────────────────────┘
            │
            ▼
┌───────────────────────────────────────┐
│    BlazeDemo Web Application          │
│    https://blazedemo.com/             │
└───────────────────────────────────────┘
Benefits of POM:
✓ Code Reusability
✓ Easy Maintenance
✓ Separation of Concerns
✓ Reduced Code Duplication
✓ Better Readability

text


---

## 🚀 Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

| Software | Version | Download Link |
|----------|---------|---------------|
| **Java JDK** | 11 or higher | [Download](https://adoptium.net/) |
| **Maven** | 3.6 or higher | [Download](https://maven.apache.org/download.cgi) |
| **Git** | Latest | [Download](https://git-scm.com/downloads) |
| **Google Chrome** | Latest | [Download](https://www.google.com/chrome/) |
| **IDE** | Eclipse/IntelliJ | [Eclipse](https://www.eclipse.org/downloads/) |

**Verify Installation:**

```bash
java -version      # Should show Java 11 or higher
mvn -version       # Should show Maven 3.6 or higher
git --version      # Should show Git version
Installation
Step 1: Clone the Repository
Bash

git clone https://github.com/prashanth110203/FlightTicketAutomation.git
cd FlightTicketAutomation
Step 2: Install Dependencies
Bash

mvn clean install
This will download all required dependencies (~200MB).

Step 3: Create Test Data
Bash

mvn exec:java -Dexec.mainClass="com.blazedemo.utils.ExcelFileCreator"
Expected Output:

text

================================================================================
SUCCESS: Excel file created!
Location: test-data/flightdata.xlsx
Sheet Name: BookingData
Total records: 5
================================================================================
Configuration
Default Configuration (src/main/java/com/blazedemo/config/TestConfig.java):

Java

BASE_URL = "https://blazedemo.com/"
BROWSER = "chrome"
HEADLESS = false
EXCEL_FILE_PATH = "test-data/flightdata.xlsx"
SCREENSHOT_FOLDER = "screenshots"
To Modify:

Change browser: Edit BROWSER constant
Enable headless: Set HEADLESS = true
Change timeouts: Modify IMPLICIT_WAIT, EXPLICIT_WAIT
▶️ Running Tests
Method 1: Maven Command Line
Bash

# Run all tests
mvn clean test

# Run with TestNG suite
mvn test -DsuiteXmlFile=testng.xml

# Run specific test
mvn -Dtest=FlightBookingTest#testFlightBooking test

# Clean, compile and test
mvn clean compile test
Method 2: Eclipse IDE
Right-click on FlightBookingTest.java
Run As → TestNG Test
Method 3: TestNG XML
Right-click on testng.xml
Run As → TestNG Suite
Method 4: Jenkins
Bash

# Build automatically via Jenkins Pipeline
# See Jenkins CI/CD Integration section
🧪 Test Scenarios
Test Flow (11 Steps):
text

1. Navigate to BlazeDemo
2. Select Departure City
3. Select Destination City
4. Click Find Flights
5. Verify Flight List Displayed
6. Select Flight (Based on Strategy)
7. Verify Purchase Page
8. Enter Personal Details
9. Enter Payment Details
10. Purchase Flight
11. Verify Booking Confirmation
Test Data (Excel):
Departure	Destination	Passenger	Selection Method
Paris	Buenos Aires	John Smith	1
Boston	London	Jane Doe	2
Portland	Dublin	Michael Johnson	RANDOM
Philadelphia	Rome	Sarah Williams	CHEAPEST
San Diego	Cairo	David Brown	3
Location: test-data/flightdata.xlsx

🎯 Flight Selection Strategies
The framework supports 7 intelligent flight selection strategies:

Strategy	Keyword	Description	Example
Index Selection	1, 2, 3, 4, 5	Select flight by position	Select 1st flight
Random Selection	RANDOM	Randomly pick any flight	Random from 5 flights
Cheapest Flight	CHEAPEST	Select lowest price	$200.98 flight
Most Expensive	EXPENSIVE	Select highest price	$765.32 flight
Sequential	SEQUENTIAL	Rotate through flights	1→2→3→4→5→1...
First Flight	FIRST	Always select first	Flight #1
Named Index	SECOND, THIRD, etc.	Select by name	THIRD = Flight #3
Usage in Excel:

text

FlightSelection Column:
- 1, 2, 3, 4, 5      → Select specific flight
- RANDOM             → Select random flight
- CHEAPEST           → Select lowest price
- EXPENSIVE          → Select highest price
- SEQUENTIAL         → Rotate through flights
📊 Test Reports
TestNG HTML Report
Location: test-output/index.html

Features:

✅ Pass/Fail status
⏱️ Execution time
📊 Test statistics
📝 Error stack traces
🔗 Suite configuration
View Report:

Bash

# Open after test execution
open test-output/index.html  # Mac/Linux
start test-output/index.html # Windows
Maven Surefire Report
Location: target/surefire-reports/

Generate:

Bash

mvn surefire-report:report
View:

Bash

open target/site/surefire-report.html
Console Output
Detailed step-by-step execution logs:

text

================================================================================
TEST EXECUTION #1
================================================================================
Test Scenario:
  Departure: Paris
  Destination: Buenos Aires
  Passenger: John Smith
  Flight Selection Method: 1

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
...
================================================================================
TEST #1 COMPLETED SUCCESSFULLY
Flight booked: Paris -> Buenos Aires for John Smith
================================================================================
📸 Screenshots
Automatic Screenshot Capture:
Event	Naming Convention	Location
Test Pass	PASSED_{count}_{testname}_{timestamp}.png	screenshots/
Test Fail	FAILED_{count}_{testname}_{timestamp}.png	screenshots/
Example Screenshots:
text

screenshots/
├── PASSED_1_testFlightBooking_20260310_165328.png
├── PASSED_2_testFlightBooking_20260310_165333.png
├── PASSED_3_testFlightBooking_20260310_165338.png
├── PASSED_4_testFlightBooking_20260310_165344.png
└── PASSED_5_testFlightBooking_20260310_165349.png
Screenshot Features:
✅ Captures final confirmation page on PASS
❌ Captures error state on FAIL
🕐 Timestamp in filename for uniqueness
📊 Counter for easy tracking
🧹 Auto-cleanup of old screenshots (7+ days)
📈 Statistics: Screenshots - Passed: 5 | Failed: 0
🔄 Jenkins CI/CD Integration
Pipeline Configuration
Jenkinsfile is included in the repository root.

Jenkins Setup Steps:
Install Jenkins

text

Download from: https://www.jenkins.io/download/
Install Required Plugins:

Maven Integration
Git
TestNG Results
HTML Publisher
Create Jenkins Job:

text

New Item → Pipeline
Name: BlazeDemo-Flight-Automation
Pipeline script from SCM
SCM: Git
Repository URL: https://github.com/prashanth110203/FlightTicketAutomation.git
Script Path: Jenkinsfile
Build:

text

Click "Build Now"
Pipeline Stages:
text

┌─────────────┐
│  Checkout   │ ← Clone from GitHub
└──────┬──────┘
       │
┌──────▼──────┐
│    Clean    │ ← Clean workspace
└──────┬──────┘
       │
┌──────▼──────┐
│   Compile   │ ← Compile Java code
└──────┬──────┘
       │
┌──────▼──────┐
│Create Excel │ ← Generate test data
└──────┬──────┘
       │
┌──────▼──────┐
│  Run Tests  │ ← Execute TestNG tests
└──────┬──────┘
       │
┌──────▼──────┐
│   Publish   │ ← Archive artifacts & reports
└─────────────┘
Jenkins Build Output:
text

✅ Checkout: SUCCESS
✅ Clean: SUCCESS (0.78s)
✅ Compile: SUCCESS (21.1s)
✅ Create Excel: SUCCESS (3.9s)
✅ Run Tests: SUCCESS (42.7s)
✅ Publish: SUCCESS

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
Artifacts Archived:
📸 Screenshots (5 files)
📊 TestNG reports
📄 Excel test data
🗂️ Surefire reports
📁 Project Structure
text

FlightTicketAutomation/
│
├── 📂 src/
│   ├── 📂 main/java/com/blazedemo/
│   │   ├── 📂 config/
│   │   │   └── TestConfig.java           # Configuration constants
│   │   ├── 📂 pages/
│   │   │   ├── HomePage.java             # Home page objects
│   │   │   ├── FlightListPage.java       # Flight list page objects
│   │   │   ├── PurchasePage.java         # Purchase page objects
│   │   │   └── ConfirmationPage.java     # Confirmation page objects
│   │   └── 📂 utils/
│   │       ├── DriverManager.java        # WebDriver management
│   │       ├── ExcelReader.java          # Excel file reader
│   │       ├── ExcelFileCreator.java     # Excel file generator
│   │       ├── TestDataGenerator.java    # Random data generator
│   │       ├── ScreenshotUtil.java       # Screenshot capture
│   │       └── TestListener.java         # TestNG listener
│   │
│   └── 📂 test/java/com/blazedemo/
│       └── 📂 tests/
│           └── FlightBookingTest.java    # Main test class
│
├── 📂 test-data/
│   └── flightdata.xlsx                   # Test data Excel file
│
├── 📂 screenshots/                        # Test screenshots (auto-generated)
│
├── 📂 test-output/                        # TestNG reports (auto-generated)
│
├── 📂 target/                             # Maven build output
│
├── 📄 pom.xml                             # Maven configuration
├── 📄 testng.xml                          # TestNG suite configuration
├── 📄 Jenkinsfile                         # Jenkins pipeline script
├── 📄 README.md                           # This file
└── 📄 .gitignore                          # Git ignore rules
Total Files:

✅ 14 Java source files
✅ 1 Excel data file
✅ 3 Configuration files (pom.xml, testng.xml, Jenkinsfile)
📊 Test Execution Statistics
Latest Build Results:
Metric	Value
Total Tests	5
Passed	5 (100%) ✅
Failed	0 (0%)
Skipped	0 (0%)
Success Rate	100% 🎯
Execution Time	~42 seconds
Screenshots	5 captured
Bookings Completed	5/5
Performance Metrics:
text

Average Test Duration: 4.4 seconds
Fastest Test: 4 seconds
Slowest Test: 5 seconds
🐛 Troubleshooting
Common Issues & Solutions:
Issue	Solution
Excel file not found	Run mvn exec:java -Dexec.mainClass="com.blazedemo.utils.ExcelFileCreator"
ChromeDriver error	WebDriverManager handles it automatically
Tests not running	Ensure testng.xml is present
Screenshots not saving	Check screenshots/ folder exists
Maven dependencies failing	Run mvn clean install -U
Port 8080 already in use	Stop Jenkins or change port
🤝 Contributing
Contributions are welcome! Please follow these steps:

Fork the repository
Create your feature branch
Bash

git checkout -b feature/AmazingFeature
Commit your changes
Bash

git commit -m 'Add some AmazingFeature'
Push to the branch
Bash

git push origin feature/AmazingFeature
Open a Pull Request
📞 Contact & Support
Author: Prashanth
GitHub: @prashanth110203
Project Link: FlightTicketAutomation

For Issues:

🐛 Report Bug
💡 Request Feature
📜 License
This project is licensed under the MIT License.

text

MIT License

Copyright (c) 2026 Prashanth

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
🙏 Acknowledgments
Wipro - For the training opportunity and capstone project
BlazeDemo - For providing the test application
Selenium Community - For the excellent automation tools
TestNG Team - For the robust testing framework
🎓 Learning Outcomes
Through this project, you will learn:

✅ Selenium WebDriver automation
✅ Page Object Model design pattern
✅ Data-Driven Testing with Excel
✅ TestNG framework & annotations
✅ Maven project management
✅ CI/CD with Jenkins
✅ Screenshot capture strategies
✅ Test reporting & documentation
✅ Git version control
✅ Industry-standard automation practices

📈 Project Statistics
GitHub repo size
GitHub language count
GitHub top language
GitHub last commit

Code Statistics:

Total Lines of Code: ~2,500+
Java Classes: 14
Test Cases: 5
Page Objects: 4
Utility Classes: 6
Configuration Files: 3
🚀 Quick Start Commands
Bash

# Clone repository
git clone https://github.com/prashanth110203/FlightTicketAutomation.git
cd FlightTicketAutomation

# Install dependencies
mvn clean install

# Create test data
mvn exec:java -Dexec.mainClass="com.blazedemo.utils.ExcelFileCreator"

# Run tests
mvn test

# View report
start test-output/index.html
<div align="center">
⭐ Star this repository if you found it helpful!
Made with ❤️ by Prashanth

Wipro Pre-Skilling Program - Capstone Project

© 2026 FlightTicketAutomation. All Rights Reserved.

</div> ```
