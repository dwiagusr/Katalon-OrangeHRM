# 🍊 OrangeHRM Test Automation Framework

![Build Status](https://github.com/dwiagusr/Learn-Katalon-OrangeHRM/actions/workflows/katalon.yml/badge.svg)

## 📌 Project Overview
This repository contains a **professional-grade automated testing framework** for the OrangeHRM platform, developed using **Katalon Studio**. The primary objective of this project is to demonstrate a scalable and maintainable automation architecture, incorporating industry-standard practices such as Data-Driven Testing (DDT) and Continuous Integration (CI/CD).

---

## 👨‍💻 About the Author
* **Name:** Dwi Agus Rianto
* **Role:** QA Engineer
* **Experience:** Manual & Automation Testing (Postman, JMeter, HeidiSQL, Jira, Katalon).

---

## 🛠️ Technical Stack

| Category | Technology Used |
| :--- | :--- |
| **Automation Tool** | Katalon Studio (v10.4.3) |
| **Language** | Groovy / Java |
| **Architecture** | Modular Keyword-Driven & Data-Driven |
| **CI/CD Pipeline** | GitHub Actions (Automated Workflow) |
| **Version Control** | Git (Feature Branching Strategy) |

---

## 📂 Project Structure
The framework is organized into specific directories to ensure high **reusability** and clean code management.

```text
OrangeHRM-Project/
├── .github/
│   └── workflows/
│       └── katalon.yml       # 🤖 CI/CD Workflow configurations
├── Checkpoints/              # 🎯 Data verification points
├── Data Files/               # 📄 Test data source (Internal/Excel) for DDT
├── Keywords/                 # 🧩 Custom reusable methods (e.g., FormHelper)
├── Object Repository/        # 🔍 Centralized UI element selectors
├── Profiles/                 # 🌍 Environment-specific variables
├── Reports/                  # 📊 Execution logs and test reports
├── Scripts/                  # 📜 Modular Groovy scripts by feature
├── Test Cases/               # 🧪 Test logic definitions
│   ├── 01_Authentication
│   ├── 02_Dashboard
│   ├── 03_PIM
│   └── 04_Leave
└── Test Suites/              # 📦 Execution sets (End-to-End Scenarios)
```
## 🚀 Key Framework Features
### 1. Data-Driven Testing (DDT)
Implemented Internal Data Files to handle bulk data input for employee management. This allows the script to execute the same test logic multiple times with different datasets without hardcoding.

### 2. Custom Keywords (`@Keyword`)
Utilizes modular code structure. Complex or repetitive actions (like clearing fields before typing) are encapsulated in `Keywords/utils/FormHelper.groovy` to keep the main test scripts clean.

### 3. Continuous Integration (CI/CD)
Integrated with GitHub Actions to automatically trigger the test suite on every `push` or `pull` request. This ensures that every code change is validated against the test suite before being merged to the `master` branch.

### 4. Smart Synchronization
Uses `waitForElementVisible` and dynamic waits instead of hardcoded Delay, making the execution faster and more stable against network latency.

## 📝 How to Run
1. Clone this repository.

2. Open **Katalon Studio.**

3. Open project `KatalonOrangeHrm.prj.`

4. Navigate to **Test Suites > TS_EndToEnd_PIM.**

5. Click **Run.**