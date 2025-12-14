🏦 Simple Banking System
Java Console Application (OOP + File Handling)
<p align="center"> <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge"/> <img src="https://img.shields.io/badge/Architecture-OOP-blue?style=for-the-badge"/> <img src="https://img.shields.io/badge/Storage-Text%20Files-green?style=for-the-badge"/> </p>
📌 Project Overview

The Simple Banking System is a Java-based console application that simulates real-world banking operations such as:

Customer management

Banking transactions

Loan processing

The project is implemented using Object-Oriented Programming (OOP) principles and file handling, without using a database, making it suitable for academic learning and demonstrations.
<p align="center"> <img src="https://img.icons8.com/color/96/bank.png" alt="Bank" /> <img src="https://img.icons8.com/color/96/money-transfer.png" alt="Transaction" /> <img src="https://img.icons8.com/color/96/loan.png" alt="Loan" /> <img src="https://img.icons8.com/color/96/user-group-man-man.png" alt="Customers" /> <img src="https://img.icons8.com/color/96/security-checked.png" alt="Security" /> </p> <p align="center"> <b>Customer Management • Transactions • Loans • Security • File-Based Storage</b> </p>

🧠 How the System Works (Visual Flow)
graph TD
    A[User] --> B[Login]
    B --> C{Role Check}
    C -->|Customer| D[Customer Operations]
    C -->|Manager| E[Manager Operations]
    D --> F[Text Files]
    E --> F[Text Files]


Flow Explanation:

User logs in

Role is verified

Operations are executed

Data is stored in .txt files

👥 User Roles
graph LR
    Customer --> Deposit
    Customer --> Withdraw
    Customer --> Transfer
    Customer --> CheckBalance
    Customer --> ViewHistory

    Manager --> CreateCustomer
    Manager --> ApproveLoan
    Manager --> ViewAccounts

👤 Customer

Deposit money

Withdraw money

Transfer funds

Check balance

View transaction history

Apply for loans

🧑‍💼 Manager

Create customers

View all accounts

Approve or reject loan requests

Manage customer records

🧩 High-Level Architecture
graph TD
    UI[Console Interface] --> BL[Business Logic]
    BL --> DM[Data Management]
    DM --> FS[Text File Storage]

📐 Class Diagram
classDiagram
    class Customer {
        +String id
        +String name
        +login()
    }

    class Manager {
        +String id
        +login()
        +approveLoan()
    }

    class Account {
        +String accountNo
        +double balance
        +deposit()
        +withdraw()
    }

    class Transaction {
        +amount
        +type
        +date
    }

    Customer --> Account
    Account --> Transaction
    Manager --> Customer

🛠️ Technologies Used
Technology	Purpose
Java	Core programming
OOP	System design
File Handling	Data persistence
Console I/O	User interaction
📂 Project Structure
Simple-Banking-System/
│
├── src/
│   ├── ProjectMain.java
│   ├── DataManagement.java
│   ├── Customer.java
│   ├── Manager.java
│   ├── Account.java
│   └── Transaction.java
│
├── user.txt
├── transaction.txt
├── loan.txt
└── README.md

🚀 Future Enhancements

GUI using JavaFX or Swing

Database integration (MySQL)

Password encryption

Interest calculation for loans

Report generation

🎓 Academic Use

This project is suitable for:

Java Mini Projects

OOP Lab Submissions

File Handling Practice
<img src="https://img.icons8.com/color/96/bank.png" width="64"/>
