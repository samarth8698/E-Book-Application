# 📚 Ebook-App
A full-featured Java Web Application for online book management and purchasing. The application provides separate modules for users and administrators, enabling efficient book inventory management, secure user authentication, shopping cart functionality, and order processing.


# 🚀 Overview
Ebook-App is designed to simplify the process of browsing, purchasing, and managing books online. The system follows a layered architecture using Java, JSP, Servlets, JDBC, and MySQL, ensuring maintainability and scalability.


# ✨ Key Features

## 👤 User Module

* User Registration and Authentication
* Secure Login and Logout
* Browse Available Books
* Search Books by Category
* Add Books to Cart
* Place Orders
* Order History Management
* Profile Update
* Password Recovery
* Submit Feedback
* Sell Old Books

## 🔧 Admin Module

* Admin Authentication
* Add New Books
* Edit Book Information
* Delete Books
* Manage Inventory
* View and Manage Orders
* Monitor User Activities


# 🏗️ System Architecture

The application follows a multi-layer architecture:

* Presentation Layer (JSP, HTML, CSS, Bootstrap)
* Controller Layer (Servlets)
* Business Logic Layer
* Data Access Layer (DAO Pattern)
* Database Layer (MySQL)



# 🛠️ Technology Stack

| Category        | Technology                  |
| --------------- | --------------------------- |
| Language        | Java                        |
| Frontend        | HTML5, CSS3, Bootstrap, JSP |
| Backend         | Java Servlet                |
| Database        | MySQL                       |
| Data Access     | JDBC                        |
| Server          | Apache Tomcat               |
| IDE             | Eclipse IDE                 |
| Version Control | Git & GitHub                |



# 📂 Project Structure
E-Book-Application/
│
├── Backend/
│   └── Ebook-App/
│       └── Ebook-App/
│
├── Database/
│   └── ebook.sql
│
└── README.md


# 📂 Project Modules

## DAO Layer

* BookDAO
* BookDAOImpl
* UserDAO
* UserDAOImpl
* CartDAO
* CartDAOImpl
* BookOrderDAO
* BookOrderImpl

## Entity Layer

* Book Details
* User
* Cart
* Order
* Feedback
* Category

## Functional Modules

* Authentication System
* Book Management
* Shopping Cart
* Order Processing
* Feedback Management



# 🗄️ Database Design

The system stores:

* User Information
* Book Inventory
* Shopping Cart Data
* Order Records
* Feedback Records
* Category Information



# 📸 Application Screens

* Home Page
* Login Page
* Registration Page
* Admin Dashboard
* Book Management Page
* Shopping Cart
* Order Confirmation Page

> **Screenshots will be added soon.**



# ⚙️ Installation Guide

## Prerequisites

* Java JDK 8 or Above
* Eclipse IDE
* Apache Tomcat
* MySQL Server

## Clone Repository

bash
git clone https://github.com/samarth8698/E-Book-Application.git


## Setup Steps

1. Clone the repository.
2. Import the project into Eclipse.
3. Configure Apache Tomcat Server.
4. Create the MySQL database.
5. Import the "Database/ebook.sql" file.
6. Update database credentials in "DBConnect.java".
7. Run the project on Apache Tomcat Server.



# 🗄️ Database Setup

sql:-
CREATE DATABASE ebook;


Import:-

text:-
Database/ebook.sql


Update the database configuration inside:-

text:-
DBConnect.java


Example:-

java:-
jdbc:mysql://localhost:3306/ebook



# 🎯 Learning Outcomes

* Java Web Development
* MVC Architecture
* JDBC Connectivity
* Session Management
* DAO Design Pattern
* CRUD Operations
* Git & GitHub Workflow
* Database Integration
* Web Application Development



# 👨‍💻 Developer

**Samarth Adhao**

GitHub:-
     https://github.com/samarth8698
