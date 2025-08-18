🏦 Core Banking Application

A Spring Boot Monolithic Banking Application that manages customers, accounts, and transactions with secure authentication, MySQL database integration, and industry-standard validations.

🚀 Features
🔑 Key Features

Entity Management: Customer, Account, and Transaction entities with JPA relationships

Layered Architecture: Controller → Service → Repository pattern

Security: Spring Security with Basic Authentication

Validation: Bean Validation (JSR-303) for inputs

Exception Handling: Global exception handler with custom exceptions

Database: MySQL integration with schema & sample data

💳 Core Banking Operations

Customer Management: Create, Read, Update, Delete customers with validations

Account Management: Support for multiple account types (Savings, Current, FD, RD)

Transaction Processing: Deposit, Withdrawal, Transfer with balance validation

Account Security: Block/Unblock account functionality

Audit Trails: Track and validate transactions

🛠️ Tech Stack

Framework: Spring Boot 3.2.0

Database: MySQL 8.0 with JPA/Hibernate

Security: Spring Security (Basic Auth)

Validation: Bean Validation (JSR-303)

Build Tool: Maven

Java Version: 17

📡 API Endpoints
Customer APIs
POST   /api/v1/customers  
GET    /api/v1/customers/{id}  
PUT    /api/v1/customers/{id}  
DELETE /api/v1/customers/{id}  

Account APIs
POST   /api/v1/accounts  
GET    /api/v1/accounts/{id}  
PUT    /api/v1/accounts/{id}  
DELETE /api/v1/accounts/{id}  

Transaction APIs
POST   /api/v1/transactions/deposit  
POST   /api/v1/transactions/withdraw  
POST   /api/v1/transactions/transfer  

⚙️ Setup & Installation

Clone the repository

git clone https://github.com/your-username/banking-app.git
cd banking-app


Configure MySQL database
Update application.yml or application.properties with your MySQL credentials:

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/banking_db
    username: root
    password: your_password


Build and run the project

mvn clean install
mvn spring-boot:run


Access the app

Base URL: http://localhost:8080/api/v1

🔐 Authentication

Uses Basic Authentication

Configure users in application.yml or via database

📌 Future Enhancements

JWT-based authentication

Microservices architecture refactor

Role-based access control (Admin, Customer)

Frontend integration with React.js

👨‍💻 Author

Mohammad Dilnawaj
Java | Spring Boot | React.js | SQL
