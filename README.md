# Student Management System

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-REST%20API-brightgreen)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-ORM-success)
![Hibernate](https://img.shields.io/badge/Hibernate-JPA-orange)
![H2 Database](https://img.shields.io/badge/Database-H2-blue)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D)
![Jakarta Validation](https://img.shields.io/badge/Validation-Jakarta-red)
![Status](https://img.shields.io/badge/Status-Completed-success)

An **internship-level Spring Boot REST API project** built to manage student records efficiently using modern backend development practices.

This project demonstrates **CRUD operations, filtering, validation, global exception handling, API documentation, and clean layered architecture** using Spring Boot.

---

## Features

### Student CRUD Operations

* Create Student
* Get All Students
* Get Student By ID
* Update Student
* Delete Student

### Student Marks Filtering

Filter students using optional query parameters:

```http
GET /api/students?minMarks=60&maxMarks=90
```

### Jakarta Validation

Implemented request validation using:

* `@NotBlank`
* `@NotNull`
* `@Min`
* `@Max`

Ensures clean and validated request data before processing.

### Global Exception Handling

Implemented centralized exception handling using:

* `@RestControllerAdvice`
* Custom Exception Class
* Default Exception Handling

Handled scenarios:

* Validation exceptions
* Student not found exceptions
* Invalid request data
* Runtime exceptions

### Swagger/OpenAPI Documentation

Integrated Swagger UI for:

* API documentation
* Endpoint testing
* Request/response visualization
* Query parameter testing

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON:

```text
http://localhost:8080/v3/api-docs
```

---

## Tech Stack

| Technology         | Usage                 |
| ------------------ | --------------------- |
| Java               | Backend Language      |
| Spring Boot        | REST API Development  |
| Spring Data JPA    | Database Operations   |
| Hibernate          | ORM                   |
| H2 Database        | Database              |
| Maven              | Dependency Management |
| Swagger / OpenAPI  | API Documentation     |
| Jakarta Validation | Request Validation    |

---

## API Endpoints

| Method | Endpoint                                | Description              |
| ------ | --------------------------------------- | ------------------------ |
| POST   | `/api/students`                         | Create student           |
| GET    | `/api/students`                         | Get all students         |
| GET    | `/api/students/{id}`                    | Get student by ID        |
| PUT    | `/api/students/{id}`                    | Update student           |
| DELETE | `/api/students/{id}`                    | Delete student           |
| GET    | `/api/students?minMarks=50&maxMarks=90` | Filter students by marks |

---

## Project Structure

```text
src/main/java
└── com.chetan.student_management_system
    ├── controller
    ├── service
    ├── repository
    ├── model
    ├── dto
    ├── exception
    └── config
```

Project follows a **clean layered architecture**:

```text
Controller → Service → Repository → Database
```

---

## Running the Project

### Clone Repository

```bash
git clone <your-repository-url>
```

### Navigate to Project

```bash
cd student-management-system
```

### Run Application

```bash
mvn spring-boot:run
```

---

## Testing

All endpoints were tested successfully using **Swagger UI**.

Verified:

* CRUD operations
* Validation scenarios
* Exception handling
* Marks filtering endpoint

---

## Project Status

🟢 **Completed**

This project was built as an **internship-ready backend project** to demonstrate backend engineering skills using **Spring Boot, JPA, Validation, Exception Handling, and REST API development**.
