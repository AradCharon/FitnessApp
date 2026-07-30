# 🏋️ FitnessApp

A modern desktop fitness tracking application built with **Java**, **Swing**, **Maven**, and **MySQL**.

FitnessApp allows users to securely register, log in, manage their workout history, track exercise statistics, and monitor their fitness progress through a clean and intuitive desktop interface.

This project was developed as the final project for my **Advanced Programming** course during the **second semester** of my Bachelor's degree.

Beyond fulfilling the course requirements, the project was designed to strengthen my understanding of desktop application development, object-oriented programming, layered architecture, database integration, and clean software engineering practices.

---

# 📖 Overview

FitnessApp is a desktop application designed for recording and managing personal fitness activities.

Instead of placing all application logic inside the graphical interface, the project follows a layered architecture where each package has a single responsibility.

The application consists of several independent layers including:

* User Interface (Swing)
* Service Layer
* Data Access Layer (DAO)
* Database Layer
* Model Layer
* Utility Classes

This architecture improves:

* Readability
* Maintainability
* Scalability
* Reusability
* Testability

The goal of this project is not only to build a workout tracker but also to demonstrate professional software engineering practices in Java.

---

# ✨ Features

* 🔐 Secure user registration
* 🔒 Secure login using BCrypt password hashing
* 👤 User profile management
* ✏️ Edit user profile information
* 💪 Add strength exercises
* 🏃 Add cardio exercises
* 📊 Dashboard with workout statistics
* 🔥 Automatic calorie calculation
* 📅 Exercise history
* 🗑 Delete exercises
* 🗂 MySQL database integration
* 🎨 Modern Java Swing user interface
* 🧩 Object-Oriented Programming (OOP)
* 🏗 Layered architecture
* 📦 Maven project structure
* ⚖️ Separation of business logic from UI
* 📝 Clean and maintainable code
* 🔄 CardLayout-based navigation
* 🚪 Logout functionality
* ⚙️ Easily extensible architecture

---

# 🧠 Software Engineering Concepts

This project demonstrates the following concepts:

* Object-Oriented Programming (OOP)
* Encapsulation
* Inheritance
* Polymorphism
* Abstraction
* Layered Architecture
* DAO Design Pattern
* Service Layer Pattern
* MVC-inspired structure
* Separation of Concerns
* Single Responsibility Principle (SRP)
* Dependency Management with Maven
* Database Connectivity (JDBC)
* BCrypt Password Hashing
* Exception Handling
* Clean Code
* Refactoring
* Modular Programming
* Reusable Components

---

# 📂 Project Structure

```text
FitnessApp/
│
├── src/
│   ├── main/
│   │
│   ├── java/
│   │   └── com/
│   │       └── arad/
│   │           └── fitnessapp/
│   │
│   │               ├── Main.java
│   │               │
│   │               ├── dao/
│   │               │     ├── UserDAO.java
│   │               │     └── ExerciseDAO.java
│   │               │
│   │               ├── database/
│   │               │     └── DatabaseConnection.java
│   │               │
│   │               ├── model/
│   │               │     ├── User.java
│   │               │     ├── Exercise.java
│   │               │     ├── CardioExercise.java
│   │               │     └── StrengthExercise.java
│   │               │
│   │               ├── service/
│   │               │     └── AuthService.java
│   │               │
│   │               ├── ui/
│   │               │     ├── LoginFrame.java
│   │               │     ├── RegisterFrame.java
│   │               │     ├── MainFrame.java
│   │               │     ├── DashboardPanel.java
│   │               │     ├── ExercisePanel.java
│   │               │     ├── ProfilePanel.java
│   │               │     └── components/
│   │               │
│   │               └── util/
│   │                     └── PasswordUtil.java
│   │
│   └── resources/
│
├── pom.xml
├── .gitignore
└── README.md
```

---

# ⚙️ How It Works

## Authentication

The authentication module allows users to:

* Register a new account
* Log into the application
* Store passwords securely using BCrypt hashing

---

## Dashboard

The dashboard displays:

* Total number of exercises
* Total calories burned
* Recent workout history

The dashboard automatically refreshes whenever the user returns to it.

---

## Exercise Management

Users can add two different exercise types.

### Strength Exercises

* Exercise name
* Duration
* Weight
* Repetitions

### Cardio Exercises

* Exercise name
* Duration
* Distance

Calories are calculated automatically based on the exercise type.

---

## Database Layer

The application stores data inside a MySQL database.

Persistent data includes:

* User accounts
* Password hashes
* Exercise records
* Workout history

The application communicates with the database using JDBC and DAO classes.

---

# ▶ Installation

Clone the repository:

```bash
git clone https://github.com/AradCharon/FitnessApp.git
```

Move into the project directory:

```bash
cd FitnessApp
```

---

# 📦 Requirements

* Java 17 or newer
* Maven
* MySQL Server

---

# 🚀 Running the Project

Compile the project:

```bash
mvn clean install
```

Run the application:

```bash
mvn exec:java
```

Or simply run:

```text
Main.java
```

from your IDE.

---

# 🗄 Database

Create a MySQL database:

```sql
CREATE DATABASE fitness_app;
```

Update the database credentials inside:

```text
DatabaseConnection.java
```

Then run the application.

---

# 📚 Technologies Used

* Java 17
* Java Swing
* Maven
* JDBC
* MySQL
* BCrypt
* IntelliJ IDEA
* Git
* GitHub

---

# 🎯 What I Learned

Through this project, I practiced and improved my understanding of:

* Designing desktop applications with Java Swing
* Applying object-oriented programming principles
* Building a layered software architecture
* Separating business logic from the user interface
* Implementing the DAO design pattern
* Integrating Java applications with MySQL using JDBC
* Designing reusable model classes through inheritance and polymorphism
* Securing user authentication with BCrypt password hashing
* Managing application state across multiple GUI panels
* Organizing a professional Maven project
* Writing reusable and maintainable code
* Refactoring existing code
* Building scalable desktop software architecture

---

# 🚀 Future Improvements

Possible future enhancements include:

* Exercise editing
* Workout categories
* Personalized workout plans
* Goal tracking
* Weight and BMI progress charts
* Nutrition tracking
* Calendar integration
* Dark mode
* PDF report export
* Cloud synchronization
* Email notifications
* Unit testing with JUnit
* Statistics dashboard
* Configuration file support
---

# 👨‍💻 Author

Arad Shafiee

Mathematics & Computer Science Student

Interested in:

* Artificial Intelligence
* Machine Learning
* Data Mining
* Software Engineering
* Algorithms

GitHub: https://github.com/AradCharon

---

# ⭐ Repository

If you found this project useful or interesting, consider giving it a ⭐ on GitHub.
