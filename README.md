# JDBC Learning Journey

A hands-on record of my journey learning **JDBC (Java Database Connectivity)**: how Java applications connect to, query, and manage relational databases. The repository is split into two parts, and each part ends with a project that applies what I learned.

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-Database%20Connectivity-blue?style=flat)

---

## Table of Contents

- [Overview](#overview)
- [Part 1: JDBC Fundamentals](#part-1-jdbc-fundamentals)
- [Part 2: Advanced JDBC](#part-2-advanced-jdbc)
- [Project 1: Hotel Reservation System](#project-1-hotel-reservation-system)
- [Project 2: Hospital Management System](#project-2-hospital-management-system)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Database Setup](#database-setup)
- [Future Improvements](#future-improvements)
- [Author](#author)

---

## Overview

| Part | Focus | Project |
|------|-------|---------|
| **Part 1** | Core JDBC: driver, connection, `Statement`, CRUD | Hotel Reservation System |
| **Part 2** | `PreparedStatement`, `CallableStatement`, `ResultSet`, transactions, batch processing | Hospital Management System |

---

## Part 1: JDBC Fundamentals

- Loading the JDBC driver using `Class.forName()`
- Establishing a database connection using `DriverManager.getConnection()`
- Using the `Statement` interface to run SQL queries
- `executeQuery()` to fetch data into a `ResultSet`
- `executeUpdate()` to perform `INSERT`, `UPDATE`, and `DELETE` operations

---

## Part 2: Advanced JDBC

### PreparedStatement
- Placeholders (`?`) for dynamic, parameterized queries
- `prepareStatement(query)` and setting values with `setInt()`, `setString()`, etc.
- Safer than `Statement` (helps prevent SQL injection) and efficient for repeated queries

### Stored Procedures and CallableStatement
- Calling stored procedures from Java
- `prepareCall()` to create a `CallableStatement`

### ResultSet
- Fetching column values with `getInt()`, `getString()`, `getDouble()`, etc.
- Navigating rows with `next()` and `absolute()`
- Reading values by column name or column index

### Transaction Handling
- ACID properties (Atomicity, Consistency, Isolation, Durability)
- `setAutoCommit(false)` for manual transaction control
- `commit()` and `rollback()` to keep data consistent
- Savepoints for partial rollbacks

### Batch Processing
- `addBatch()` to queue multiple SQL statements
- `executeBatch()` to run them together
- `clearBatch()` to reset the queue
- Fewer database round trips, which means better performance

---

## Project 1: Hotel Reservation System

A **Java + MySQL console application** built with the Part 1 concepts.

### Features
- Add new reservations with guest and room details
- View all current bookings
- Edit existing reservation information
- Delete reservations

### Concepts Applied
- JDBC driver loading and connection handling
- `Statement` with `executeQuery()` and `executeUpdate()`
- Full CRUD operations on a relational database

---

## Project 2: Hospital Management System

A **Java + MySQL console application** built with the Part 2 concepts. It manages patients and doctors and handles appointment booking with availability checks.

### Features
- **Manage Patients and Doctors:** add new patients, and view patient and doctor records in a formatted table
- **Book Appointments:** schedule an appointment by linking a patient and a doctor on a chosen date
- **Check Doctor Availability:** verify that a doctor is free on a specific date before booking, which prevents double bookings
- **Input Validation:** confirms that both the patient and the doctor exist before an appointment is created

### Concepts Applied
- `PreparedStatement` with placeholders for every query
- `ResultSet` navigation and value retrieval
- Modular design with separate classes for each responsibility

### Project Structure

```
hospitalManagementSystem/
├── HospitalManagementSystem.java   # Entry point, menu, appointment booking
├── Patient.java                    # Add, view, and look up patients
└── Doctor.java                     # View and look up doctors
```

### Menu Options

```
HOSPITAL MANAGEMENT SYSTEM
1. Add Patient
2. View Patients
3. View Doctors
4. Book Appointment
5. Exit
```

### Workflow: Booking an Appointment

1. Enter the patient ID, doctor ID, and appointment date (`YYYY-MM-DD`)
2. The system checks that both the patient and the doctor exist
3. It checks whether the doctor already has an appointment on that date
4. If the doctor is free, the appointment is saved; otherwise the user is told the doctor is unavailable

---

## Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Core programming language |
| JDBC | Database connectivity API |
| MySQL | Relational database |
| MySQL Connector/J | JDBC driver for MySQL |

---

## Prerequisites

- JDK 8 or higher
- MySQL Server
- MySQL Connector/J added to your project's classpath
- An IDE such as IntelliJ IDEA or Eclipse

---

## Getting Started

1. **Clone the repository**
   ```bash
   git clone <your-repository-url>
   cd <repository-name>
   ```

2. **Set up the database** (see the next section).

3. **Configure the connection** in the main class of the project you want to run:
   ```java
   private static final String url = "jdbc:mysql://localhost:3306/hospital";
   private static final String username = "your_username";
   private static final String password = "your_password";
   ```

4. **Add MySQL Connector/J** to the classpath, then run the main class.

> **Note:** Never commit real database credentials. Replace them with placeholders before pushing, or load them from environment variables.

---

## Database Setup

Schema used by the Hospital Management System:

```sql
CREATE DATABASE hospital;
USE hospital;

CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(20) NOT NULL
);

CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100) NOT NULL
);

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);
```

Add a few sample doctors so there is something to book:

```sql
INSERT INTO doctors (name, specialization) VALUES
('Dr. Sharma', 'Cardiologist'),
('Dr. Mehta', 'Neurologist'),
('Dr. Iyer', 'Orthopedic');
```

---

## Future Improvements

- Use transactions (`commit` / `rollback`) around appointment booking
- Use batch processing for bulk patient inserts
- Add stored procedures for common operations
- Support doctor time slots instead of whole-day availability
- Add cancel and reschedule options for appointments
- Move credentials to environment variables or a properties file
- Build a GUI or REST API on top of the existing logic

---

## Author

**Prem Kumar Shaw**

[![GitHub](https://img.shields.io/badge/GitHub-premkumarshaw04-181717?style=flat&logo=github)](https://github.com/premkumarshaw04)

---

If you found this helpful, consider giving the repository a star.