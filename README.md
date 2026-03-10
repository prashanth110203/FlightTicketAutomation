# ✈️ BlazeDemo Flight Booking Automation

![Build](https://img.shields.io/badge/build-passing-brightgreen)
![Java](https://img.shields.io/badge/Java-11-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.15.0-green)
![TestNG](https://img.shields.io/badge/TestNG-7.8.0-red)
![Maven](https://img.shields.io/badge/Maven-3.x-blue)

**Complete end-to-end test automation framework for BlazeDemo flight booking application using Selenium WebDriver, Java, TestNG, and Data-Driven Testing approach.**

---

## 🎯 About the Project

This is a **comprehensive test automation framework** developed as part of the **Wipro Pre-Skilling Capstone Project**. The framework automates the complete flight booking workflow on the [BlazeDemo](https://blazedemo.com/) application.

### What This Project Does

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
| 🎨 Page Object Model | Clean, maintainable code structure |
| 📊 Data-Driven Testing | Excel-based test data management |
| 🎯 Multiple Selection Strategies | 7+ ways to select flights |
| 📸 Smart Screenshots | Automatic capture on pass/fail |
| 📈 Detailed Reporting | TestNG HTML & Surefire reports |
| 🔄 CI/CD Ready | Jenkins pipeline integration |
| 🛡️ Robust Wait Strategies | Explicit & implicit waits |
| 📝 Comprehensive Logging | Step-by-step console output |

---

## 🛠️ Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 11 | Programming Language |
| Selenium WebDriver | 4.15.0 | Browser Automation |
| TestNG | 7.8.0 | Testing Framework |
| Maven | 3.9.x | Build Management |
| Apache POI | 5.2.4 | Excel File Handling |
| WebDriverManager | 5.6.2 | Driver Management |
| Jenkins | Latest | CI/CD Automation |

---

## 🚀 Getting Started

### Prerequisites

| Software | Version | Download |
|----------|---------|----------|
| Java JDK | 11+ | [Download](https://adoptium.net/) |
| Maven | 3.6+ | [Download](https://maven.apache.org/) |
| Git | Latest | [Download](https://git-scm.com/) |
| Chrome | Latest | [Download](https://google.com/chrome/) |

### Installation

**Step 1: Clone Repository**

```bash
git clone https://github.com/prashanth110203/FlightTicketAutomation.git
cd FlightTicketAutomation
Step 2: Install Dependencies

Bash

mvn clean install
Step 3: Create Test Data

Bash

mvn exec:java -Dexec.mainClass="com.blazedemo.utils.ExcelFileCreator"
▶️ Running Tests
Bash

# Run all tests
mvn clean test

# Run specific test
mvn -Dtest=FlightBookingTest test
Using Eclipse:

Right-click on FlightBookingTest.java
Select Run As → TestNG Test
🧪 Test Scenarios
Test Flow (11 Steps)
Step	Action
1	Navigate to BlazeDemo
2	Select departure city
3	Select destination city
4	Click Find Flights
5	Verify flight list
6	Select flight
7	Verify purchase page
8	Enter personal details
9	Enter payment details
10	Click Purchase
11	Verify confirmation
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
📸 Screenshots
Screenshots are automatically captured on test pass/fail.

Location: screenshots/

Event	Naming
Pass	PASSED_1_testName_timestamp.png
Fail	FAILED_1_testName_timestamp.png
📊 Test Reports
TestNG Report: test-output/index.html

Bash

start test-output/index.html
🔄 Jenkins CI/CD
Setup Steps
Install Jenkins
Install plugins: Maven, Git, TestNG Results
Create Pipeline job
Configure SCM with repository URL
Set Script Path: Jenkinsfile
Build Now
Build Output
text

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
📁 Project Structure
text

FlightTicketAutomation/
├── src/main/java/com/blazedemo/
│   ├── config/TestConfig.java
│   ├── pages/
│   │   ├── HomePage.java
│   │   ├── FlightListPage.java
│   │   ├── PurchasePage.java
│   │   └── ConfirmationPage.java
│   └── utils/
│       ├── DriverManager.java
│       ├── ExcelReader.java
│       ├── ScreenshotUtil.java
│       └── TestListener.java
├── src/test/java/com/blazedemo/tests/
│   └── FlightBookingTest.java
├── test-data/flightdata.xlsx
├── screenshots/
├── pom.xml
├── testng.xml
└── Jenkinsfile
📊 Test Statistics
Metric	Value
Total Tests	5
Passed	5 (100%)
Failed	0
Execution Time	~42 seconds
🚀 Quick Start
Bash

git clone https://github.com/prashanth110203/FlightTicketAutomation.git
cd FlightTicketAutomation
mvn clean install
mvn exec:java -Dexec.mainClass="com.blazedemo.utils.ExcelFileCreator"
mvn test
👨‍💻 Author
Prashanth

GitHub: @prashanth110203
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
<p align="center"> <b>⭐ Star this repository if you found it helpful!</b> <br><br> Made with ❤️ by Prashanth <br> Wipro Pre-Skilling Program - Capstone Project </p>
