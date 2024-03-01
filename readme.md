# <div align="center">Statistics API</div>

Welcome to the Statistics API project! This project aims to create a Spring Boot RESTful API that updates statistics in the database and caches responses that we retrieve.  
This README.md file provides an overview of the project.

## Get Started

To run the project, follow this instruction:

1. Clone the repository:
   ```bash
   git clone https://github.com/vadymhrnk/statistics-api.git
   ```
2. Download [JDK](https://www.oracle.com/java/technologies/downloads/), [Apache Maven](https://maven.apache.org/download.cgi) and [Docker](https://docs.docker.com/get-docker/)
3. Use Docker to build and run MongoDB:
   ```bash
   docker-compose -f docker-compose.yaml -p statistics-api up -d
   ```
4. Build and run the project using:
   ```bash
   mvn clean spring-boot:run 
   ```

### Backend Technologies
- **Java 17**: the primary programming language for backend development.
- **Spring Boot**: the framework for building and deploying Java-based applications with ease.
- **Spring Security**: ensures secure authentication and authorization within the application.
- **Spring Data MongoDB**: provides easy integration with MongoDB for data access.
- **Spring Boot Starter Web**: starter for building web applications, including RESTful APIs.
- **Spring Boot Starter Cache**: starter for using Spring Framework’s caching support.
- **Spring Boot Starter Validation**: starter for using JSR-380 Bean Validation with Hibernate Validator.
- **MapStruct**: simplifies the implementation of bean mappings, reducing manual coding effort.
- **Lombok**: a tool to reduce boilerplate code, enhancing code readability and conciseness.
- **MongoDB Driver**: driver for MongoDB integration.

### API Documentation
- **Springdoc OpenAPI**: an OpenAPI for generating documentation.

### Security
- **JWT (JSON Web Token)**: used for secure communication and authorization between client and server.

### Database Migration
- **Mongock**: enables MongoDB database migration management.

### Application Endpoints

- **Authentication controller:**
    - `POST: /auth/registration` -> Sign in to the app.
    - `POST: /auth/login` -> Log in to get token for further interactions.

- **Report controller:**
    - `GET: /reports/dates` -> Get list of all reports by dates.
    - `GET: /reports/dates?firstDate=2024-02-15&secondDate=2024-02-16` -> Get list of all reports by selected dates
    - `GET: /reports/ASIN` -> Get all reports by ASINs.
    - `GET: /reports/ASIN?asinList=B07JWCZKSJ&asinList=B09ZDDDS1X` -> Get all reports by specific ASINs.