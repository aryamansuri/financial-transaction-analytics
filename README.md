# Financial Transaction Analytics Service

A backend system built using **Spring Boot** that analyzes financial transaction data and generates insights such as **cashflow trends, spending patterns, and financial risk signals**.

This project focuses on the **analytics layer of financial systems**, simulating how fintech platforms process structured transaction data to derive meaningful insights.

---

## Features

- **Cashflow Analysis**  
  Computes total credits, debits, and net cashflow.

- **Spending Categorization**  
  Automatically classifies transactions into categories such as Food, Shopping, Transport, and Subscriptions.

- **Monthly Spending Trends**  
  Aggregates spending data by month to identify patterns over time.

- **Top Merchant Detection**  
  Identifies merchants with the highest spend and ranks them.

- **Risk Analysis Engine**  
  Generates financial signals such as:
  - High spending categories
  - Negative cashflow detection
  - Dependency on a single merchant

---

## Tech Stack

- **Java**
- **Spring Boot**
- **PostgreSQL**
- **JPA / Hibernate**
- **REST APIs**

---

## System Architecture

Transaction Data (JSON)
↓
Validation & Normalization
↓
Categorization Engine
↓
PostgreSQL Database
↓
Analytics Layer
↓
REST APIs → Financial Insights

---

## API Endpoints

### Transaction APIs

POST /transactions
POST /transactions/bulk
GET  /transactions

### Analytics APIs

GET /analysis/cashflow
GET /analysis/categories
GET /analysis/monthly
GET /analysis/top-merchants
GET /analysis/risk

---

## 📌 Example Outputs

### Cashflow

```json
{
  "totalDebits": 3600.0,
  "totalCredits": 50000.0,
  "netCashflow": 46400.0
}
```

### Category Breakdown

```json
{
  "Food": 2000,
  "Shopping": 15000,
  "Transport": 800
}
```

### Monthly Trends

```json
{
  "2025-01": 15000,
  "2025-02": 20000
}
```

### Risk Analysis

```json
{
  "highSpendingCategories": ["Shopping"],
  "negativeCashflow": false,
  "topMerchantDependency": true
}
```

## Project Motivation

This project was built to simulate the analytics layer of fintech systems, focusing on generating insights from structured transaction data rather than raw data ingestion.

It demonstrates how financial platforms:
	•	Analyze user spending behavior
	•	Detect financial risk patterns
	•	Generate actionable insights from transaction data

Here you go — clean and ready to copy-paste:

## Running the Project

1. Clone the repository

git clone https://github.com/YOUR_USERNAME/financial-transaction-analytics.git

2. Navigate to the project directory

cd financial-transaction-analytics

3. Configure PostgreSQL in `src/main/resources/application.properties`

spring.datasource.url=jdbc:postgresql://localhost:5432/bank_analysis
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

4. Run the application

./mvnw spring-boot:run

5. Access APIs

http://localhost:8080