# 🏦 Core Banking Application
+ A Monolithic Spring Boot Banking App with MySQL +

✨ Features
Key Features:
  ✔ Entity Management (Customer, Account, Transaction)
  ✔ Layered Architecture (Controller → Service → Repository)
  ✔ Spring Security (Basic Authentication)
  ✔ Validation (JSR-303 Bean Validation)
  ✔ Global Exception Handling
  ✔ MySQL Integration 

💳 Core Banking Operations
# Customer Management
- Create, Read, Update, Delete Customers  

# Account Management
- Savings, Current, FD, RD Accounts  

# Transactions
- Deposit, Withdraw, Transfer  
- Balance Validation & Audit Trails  

# Security
- Block / Unblock Accounts

🛠 Tech Stack
Java Version     : 17
Framework        : Spring Boot 3.2.0
Database         : MySQL 8.0
ORM              : Hibernate / JPA
Security         : Spring Security (Basic Auth)
Build Tool       : Maven

📡 API Endpoints
# Customer APIs
POST   /api/v1/customers
GET    /api/v1/customers/{id}
PUT    /api/v1/customers/{id}
DELETE /api/v1/customers/{id}

# Account APIs
POST   /api/v1/accounts
GET    /api/v1/accounts/{id}
PUT    /api/v1/accounts/{id}
DELETE /api/v1/accounts/{id}

# Transaction APIs
POST   /api/v1/transactions/deposit
POST   /api/v1/transactions/withdraw
POST   /api/v1/transactions/transfer



👨‍💻 Author
Name     : Mohammad Dilnawaj
Skills   : Java | Spring Boot | React.js | SQL

