🏦 Simple Banking System (Java Console Application)
<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Type-Console%20Application-blue?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Data%20Storage-File%20Handling-green?style=for-the-badge"/>
</p>
📌 Project Overview

The Simple Banking System is a Java-based console application that simulates core banking operations such as customer management, account transactions, and loan handling.
This project is developed using Object-Oriented Programming (OOP) concepts and file handling, without using a database, making it suitable for academic learning and demonstrations.

The system supports two roles:

Customer

Manager

Each role has its own set of functionalities and access controls.

🎯 Objectives of the Project

To understand OOP concepts like classes, objects, encapsulation, and modular design

To implement file-based data storage using .txt files

To simulate real-world banking workflows

To build a menu-driven application using Java

To handle authentication, transactions, and loan processing

🧠 Technologies Used

Language: Java

Concepts:

Object-Oriented Programming (OOP)

File Handling (BufferedReader, BufferedWriter)

Exception Handling

Menu-driven Console UI

Data Storage: Text files (.txt)

📁 Project Structure
Simple-Banking-System/
│
├── ProjectMain.java        # Main entry point (menu & navigation)
├── DataManagement.java    # Core logic and business operations
├── user.java              # Customer model
├── manager.java           # Manager model
├── loan.java              # Loan model
│
├── user.txt               # Stores customer data
├── mgr.txt                # Stores manager data
├── loan.txt               # Stores loan data
│
└── README.md              # Project documentation

👥 User Roles & Functionalities
👤 Customer Functions

After logging in, a customer can:

Check Account Balance

Deposit Money

Withdraw Money

Apply for a Loan

Pay Loan Amount

Change Password

Logout

All customer data is stored persistently in user.txt.

👨‍💼 Manager Functions

After logging in, a manager can:

View All Customers

Deactivate Customer Account

Deactivate Manager Account

Logout

Manager credentials are stored in mgr.txt.

🔐 Authentication System

Customers and managers must sign up before logging in

Login credentials are verified from text files

Session control is handled using boolean flags:

isUserLoggedIn

isManagerLoggedIn

💾 Data Storage Format
📄 user.txt
FirstName|LastName|AccountNo|Balance|UserID|Password

📄 mgr.txt
FirstName|LastName|ManagerID|Password

📄 loan.txt
UserID|Mobile|Address|RequestedAmount|Tenure|Interest|DisposedAmount|PendingAmount|Status|SNo|ApplicationNo

Loan Status Values:

-1 → Loan Requested

-2 → Loan Approved (future scope)

1,2,3... → Installment payments

💳 Banking Operations Explained
✔ Deposit

User enters an amount

Balance is updated in user.txt

File is rewritten with updated balance

✔ Withdraw

Checks if sufficient balance exists

Deducts amount if valid

Prevents overdraft

✔ Balance Check

Reads user balance from file

Displays current balance

🏦 Loan System Workflow
📌 Apply Loan

Customer provides mobile, address, amount, tenure, and interest

Unique application number is auto-generated (e.g., AP001)

Loan request is saved in loan.txt

💸 Pay Loan

Customer pays partial or full loan amount

Pending amount is recalculated

System prevents overpayment

🧱 Class Responsibilities
ProjectMain.java

Entry point of the application

Displays menus

Routes user actions to DataManagement

DataManagement.java

Core logic of the system

Handles:

Login & signup

File reading/writing

Transactions

Loan processing

Account deletion

user.java

Represents customer details

Stores account-related information

manager.java

Represents manager credentials

loan.java

Encapsulates loan data

Used for structured loan record handling

▶️ How to Run the Project
1️⃣ Clone the Repository
git clone https://github.com/logicCrafter320/Simple-Banking-System.git

2️⃣ Compile the Program
javac BProj/*.java

3️⃣ Run the Application
java BProj.ProjectMain

✅ Key Highlights

No database required

Clean separation of roles

Persistent data storage

Menu-driven and user-friendly

Real-world banking logic simulation

🚀 Future Enhancements

GUI using JavaFX or Swing

Database integration (MySQL / SQLite)

Transaction history logs

Loan approval by manager

Interest calculation automation

Password encryption

📚 Academic Relevance

This project is ideal for:

Java Mini Projects

OOP Demonstrations

File Handling Assignments

Banking System Case Studies

🙌 Final Note

This project reflects practical understanding, not just theory.
You’ve implemented authentication, transactions, loan handling, and role-based access, which is more than enough for a strong academic submission.

If you want, I can also help you with:

Poster content

Viva explanation

Architecture diagram

Class diagram

CO-wise mapping
