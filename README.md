OrangeHRM Test Automation Framework
📌 Project Overview
This repository contains a professional-grade automated testing framework for the OrangeHRM platform, developed using Katalon Studio. The primary objective of this project is to demonstrate a scalable and maintainable automation architecture, incorporating industry-standard practices such as Data-Driven Testing (DDT) and Continuous Integration (CI/CD).

👤 About the Author
Name: Dwi Agus Rianto

Role: QA Engineer


🛠️ Technical Stack
Automation Tool: Katalon Studio v10.3.0.

Programming Language: Groovy / Java.

Architecture: Modular Keyword-Driven & Data-Driven.

CI/CD Pipeline: GitHub Actions with dynamic branch tracking.

Version Control: Git (using Feature Branching Strategy).

📂 Project Structure
The framework is organized into specific directories to ensure high reusability and clean code management:

Plaintext

TestProject/
├── .github/                # CI/CD Workflow configurations
│   └── workflows/
│       └── katalon.yml
├── Checkpoints             # Data verification points
├── Data Files/             # Test data (Internal/Excel) for DDT
├── Keywords/               # Custom reusable methods (utils)
├── Object Repository/      # Centralized UI element selectors
├── Profiles/               # Environment-specific variables
├── Reports/                # Execution logs and test reports
├── Scripts/                # Modular Groovy scripts by feature
│   ├── 01_Authentication
│   ├── 03_PIM
│   └── 04_Leave
├── Test Cases/             # Test logic definitions
│   ├── 01_Authentication
│   ├── 02_Dashboard
│   ├── 03_PIM
│   └── 04_Leave
├── Test Suites/            # Execution sets (End-to-End scenarios)
└── settings/               # Project-level configurations
🚀 Key Framework Features
1. Data-Driven Testing (DDT)
Implemented Internal Data (New_Employee) to handle bulk data input for employee management.

Utilized Variable Binding in Test Suites to map data columns to script variables (var_firstName, var_lastName), allowing for multiple iterations in a single test run.

2. Custom Keywords (Helper Library)
Developed a dedicated FormHelper class within the utils package.

Encapsulated complex UI interactions, such as clearAndType, to ensure reliable form handling and reduce script redundancy.

3. CI/CD Pipeline
Integrated with GitHub Actions via katalon.yml.

Configured Dynamic Branch Tracking using wildcards ('**') to automatically trigger test executions on any feature branch push or pull request.

4. Professional Branching Strategy
Maintains a stable master branch while performing active development on specific feature branches, such as feature/ddt-implementation.

🚦 Getting Started
Prerequisites
Katalon Studio installed (Enterprise or Platform Edition).

Valid Katalon Runtime Engine (KRE) license for CI/CD execution.

Execution Steps
Clone this repository: git clone <repository-url>.

Open the project in Katalon Studio.

Navigate to Test Suites/TS_EndToEnd_PIM.

Run the test suite using the Chrome browser.