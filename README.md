# 🚗 Smart Parking System (Java + MySQL)

A modular **Smart Parking Management System** built using **Java**, **MySQL**, and **JavaFX**.  
This project provides a console-based and scalable architecture to manage **parking slots**, **user registrations**, and **admin operations** with database integration.

---

## 📘 Overview

The **Smart Parking System** automates the process of managing parking slots and user data in real time.  
It enables **users** to register and receive parking receipts while **admins** manage users and monitor system performance.

---

## 🏗️ Project Architecture

The project follows a **3-layer modular architecture**:

smart_parking_system/
│
├── lib/
│ ├── openjfx/ # JavaFX library
│ └── mysql-connector-j-9.4.0.jar # JDBC driver
│
├── src/
│ ├── database/ # Handles DB connections and queries
│ │ └── DatabaseConnection.java
│ │
│ ├── models/ # Contains data models
│ │ ├── admin/ # Admin data model
│ │ │ └── AdminModel.java
│ │ └── user/ # User data model
│ │ └── UserModel.java
│ │
│ ├── services/ # Business logic layer
│ │ ├── AdminServices.java
│ │ └── UserServices.java
│ │
│ ├── ui/ # UI layer for user and admin interaction
│ │ ├── admin/
│ │ │ └── admin_backend_ui.java
│ │ └── user/
│ │ └── user_backend_ui.java
│ │
│ └── Main.java # Entry point
│
└── bin/ # Compiled .class files


---

## 🔧 System Workflow

### 1️⃣ User Flow

**Modules involved:**  
`UserModel.java` → `UserServices.java` → `DatabaseConnection.java` → `user_backend_ui.java`

**Process:**
1. User registers by entering **name**, **mobile number**, and **car number**.  
2. The data is passed to `UserModel` and then stored in the database via `DatabaseConnection.Insertion()`.  
3. The system generates and displays a parking receipt with the allocated slot number.

---

### 2️⃣ Admin Flow

**Modules involved:**  
`AdminModel.java` → `AdminServices.java` → `DatabaseConnection.java` → `admin_backend_ui.java`

**Process:**
1. Admin logs in using credentials from the `admin_info` table.  
2. Admin can:
   - View all registered users
   - Add or remove other admins
   - Manage user data directly in the system  
3. Every admin operation reflects in the connected MySQL database in real time.

---

## 🧩 Key Features

### ✅ User Module
- Register with **Name**, **Mobile**, and **Car Number**
- Automatically assigned parking slot
- Retrieve receipt by car number
- Console-based clean interaction

### ✅ Admin Module
- Add, view, or delete admins
- Access complete user information
- Manage database entries dynamically
- Error-handled input validation

### ✅ Database Layer
- MySQL integration using JDBC
- Secure database access via `DatabaseConnection` class
- Centralized configuration for credentials

---

## 🧠 Core Logic Pipelines

### 🔹 Registration Pipeline

Each new user object is created in `UserModel`, validated, and inserted into the `user_info` table.

### 🔹 Receipt Generation Pipeline


Fetches user details via car number and prints a custom thank-you receipt.

### 🔹 Admin Management Pipeline


Handles admin CRUD operations using parameterized SQL queries to ensure safety and reliability.

---

## 🗄️ Database Structure (MySQL)

### Table: `user_info`
| Column        | Type         | Description                     |
|---------------|--------------|----------------------------     |
| id            | INT (AUTO_INCREMENT) | Unique ID for each user |
| name          | VARCHAR(255) | User's name                     |
| mobile_no     | VARCHAR(15)  | User's mobile number            |
| car_no        | VARCHAR(20)  | User's car number               |

### Table: `admin_info`
| Column       | Type         | Description                       |
|---------------|--------------|----------------------------      |
| id            | INT (AUTO_INCREMENT) | Unique ID for each admin |
| username      | VARCHAR(255) | Admin username                   |
| password      | VARCHAR(255) | Admin password                   |
| role          | VARCHAR(50)  | Role (e.g., admin, superadmin)   |

---

## 🧰 Technologies Used

| Layer     | Technology                          |
|-------    |-------------                        |
| Language  | Java 17+                            |
| Database  | MySQL 8+                            |
| UI        | JavaFX (for future GUI integration) |
| Libraries | MySQL Connector/J                   |
| Build Tool| Manual / CLI Compilation            |
| IDE       | IntelliJ IDEA / VS Code / Eclipse   |

---

## ⚙️ Setup Instructions

### Step 1: Clone the Project
```bash
git clone https://github.com/yourusername/smart_parking_system.git
cd smart_parking_system


Step 2: Configure MySQL

Open MySQL terminal and create a new database:

CREATE DATABASE smart_parking_system;
USE smart_parking_system;


Create required tables:

CREATE TABLE user_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    mobile_no VARCHAR(15),
    car_no VARCHAR(20)
);

CREATE TABLE admin_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(50)
);


Insert a default admin:

INSERT INTO admin_info (username, password, role)
VALUES ('admin', '1234', 'superadmin');

Step 3: Compile and Run
javac -cp "lib/mysql-connector-j-9.4.0.jar;src" -d bin src/Main.java
java -cp "bin;lib/mysql-connector-j-9.4.0.jar" Main


🌐 Future Enhancements

JavaFX GUI Integration

Slot Visualization Dashboard

Automated slot allocation algorithm

License plate image recognition system

Admin analytics dashboard

👥 Contributors


Name	            Roll Number	        Role
Abhinav Ban	        RA2411026030209	    Project Lead and System Architect
Sachin Thuwal	    RA2411026030189	    Developer
Ribhav Shrivastav	RA2411026030184	    Developer
Shivang Singh	    RA2411026030189	    Developer
