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
