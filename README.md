📘 Spring Boot Workshop – Order Management API

This project was developed as part of a learning workshop following a Spring Boot course.
It implements a simple Order Management REST API, including users, products, categories, orders, order items, and payment entities.

🚀 Technologies Used
Java 17+
Spring Boot
Spring Web
Spring Data JPA
H2 Database (for testing)
Maven

📦 Features
User registration and management
Category and product management
Order creation with order items
Payment association
Exception handling with custom error responses
RESTful resource organization

📁 Project Structure
entities/ — domain model (User, Order, Product, etc.)
resources/ — REST controllers
services/ — business logic
repositories/ — JPA repositories
exceptions/ — custom exceptions & handlers

▶️ Running the Project
Clone the repository: git clone https://github.com/wCarvalhoDev/task-manager-api
Navigate to the project folder: cd your-project
Run the application: mvn spring-boot:run
Access the H2 console (optional): http://localhost:8080/h2-console

🎯 Purpose
This project was created for study purposes, allowing practice with:
Building REST APIs with Spring Boot
Implementing CRUD operations
Using DTOs
Handling exceptions properly
Structuring a clean and maintainable codebase
