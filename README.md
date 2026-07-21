# Geek Text Bookstore API

A RESTful API service for an online bookstore built with Java and Spring Boot.

## Tech Stack
- Java 17
- Spring Boot 3.5.14
- Spring Data JPA
- PostgreSQL 17

## Getting Started

### Prerequisites
- Java 17
- PostgreSQL 17
- Maven (included via Maven wrapper)

### Setup
1. Clone the repo: `git clone https://github.com/N3l-son/CEN4010.git`
2. Install PostgreSQL and create a database named `geektext`
3. Copy `src/main/resources/application.properties.template` and rename it to `application.properties`
4. Fill in your PostgreSQL password in `application.properties`
5. Run the app through IntelliJ or with `./mvnw spring-boot:run`

### Important
- Never push `application.properties` — it contains your local database credentials
- Always create your own branch before writing code: `git checkout -b feature[number]-[featurename]`
- Never push directly to master