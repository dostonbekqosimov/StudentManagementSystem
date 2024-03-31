# Student Management System

## Description

This project is a simple student management system built with Spring Boot. It allows users to perform CRUD (Create, Read, Update, Delete) operations on student records stored in a database.

## Features

- **CRUD Operations**: Allows users to create, read, update, and delete student records.
- **RESTful API**: Provides endpoints for interacting with student data over HTTP.
- **Spring Boot**: Java-based framework used for backend development.
- **H2 Database**: In-memory relational database used for storing student records during development.

## Installation

1. Clone the repository to your local machine.
2. Set up your development environment with Java and Maven.
3. Configure the database settings in `application.properties`.
4. Run the Spring Boot application.

## Usage

1. Use Postman or any HTTP client to interact with the API endpoints.
2. Use the following endpoints to perform operations:
   - `GET /api/v1/student`: Fetch all students.
   - `GET /api/v1/student/{id}`: Fetch details of a specific student by ID.
   - `POST /api/v1/student`: Add a new student record.
   - `PUT /api/v1/student/{id}`: Update an existing student record.
   - `DELETE /api/v1/student/{id}`: Delete a student record by ID.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, feel free to fork the repository and submit a pull request with your changes.

## License

This project is licensed under the [Doston Sulaymon]().

