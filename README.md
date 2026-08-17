# StudentRegistrationApp

A Full Stack Java web application for registering and managing student records using JSP, Servlets, JDBC, MySQL, Maven, and Apache Tomcat.

## Features

* Student registration
* View all registered students
* Edit student details
* Update student details
* Delete student records
* MySQL database integration
* CRUD operations using JDBC
* Maven-based project structure

## Technologies Used

* Java 21
* JSP
* HTML5
* CSS3
* Jakarta Servlets
* JDBC
* MySQL
* Maven
* Apache Tomcat 10.1

## Project Structure

```text
StudentRegistrationApp
│
├── pom.xml
│
├── src
│   └── main
│       ├── java
│       │   └── com.student
│       │       ├── controller
│       │       │   ├── RegisterServlet.java
│       │       │   ├── ViewStudentsServlet.java
│       │       │   ├── EditStudentServlet.java
│       │       │   ├── UpdateStudentServlet.java
│       │       │   └── DeleteStudentServlet.java
│       │       │
│       │       └── dao
│       │           ├── DBConnection.java
│       │           └── StudentDAO.java
│       │
│       └── webapp
│           ├── index.jsp
│           ├── css
│           │   └── style.css
│           └── WEB-INF
│               └── web.xml
│
└── .gitignore
```

## Architecture

```text
Browser
   ↓
JSP / HTML / CSS
   ↓
HTTP Request
   ↓
Apache Tomcat
   ↓
Servlet
   ↓
StudentDAO
   ↓
JDBC
   ↓
MySQL
```

## CRUD Operations

### Create

Student registration stores a new student in MySQL using an `INSERT` query.

### Read

The `ViewStudentsServlet` retrieves student records using a `SELECT` query and displays them in an HTML table.

### Update

The edit and update Servlets modify an existing student's details using an `UPDATE` query.

### Delete

The delete Servlet removes a student using a `DELETE` query.

## Database

Create a MySQL database named:

```sql
CREATE DATABASE student_registration;
```

Create the students table:

```sql
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(100)
);
```

## Configuration

The application uses environment variables for database credentials.

```text
DB_USER
DB_PASSWORD
```

The database password is not stored in the source code.

## How to Run

1. Install Java 21.
2. Install Maven.
3. Install MySQL.
4. Install Apache Tomcat 10.1.
5. Create the `student_registration` database and `students` table.
6. Configure `DB_USER` and `DB_PASSWORD` in the environment.
7. Import the project into Eclipse as a Maven project.
8. Run Maven:

```text
clean package
```

9. Deploy the generated WAR file to Apache Tomcat.
10. Start Tomcat.
11. Open:

```text
http://localhost:8080/StudentRegistrationApp/
```

## Author

Ashish Bedrey
