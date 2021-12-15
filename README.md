# Quiz

## Description
Conducting a quiz and issuing a list of answers in a readable form. Spring Security implements in memory authorization
to view poll results.

## Used tools
* Platform: Spring Boot 2.6.1
* Builder: Gradle
* Database: PostgreSQL 14
* Languages: Java 8 (SDK 1.8), HTML5, CSS3
* Dependencies: Spring Data JPA, Spring Security, Thymeleaf, Validation, Spring Web, Lombok, PostgreSQL Driver

## Important files
* Builder configuration: \build.gradle
* Application properties: \src\main\resources\application.properties
* Security configuration: \src\main\java\web\quiz\config\WebSecurityConfig.java

## Backend schema
* MainController <- CombineService <- AnswerRepository <- quiz (database) <- Answer

## Installation
1. Create quiz database in PostgreSQL
2. Run this project in development environment
3. Open http://localhost:8081 in browser

## Release Notes
* Project type: Web application
* Date of release: 15 December 2021
* Current version: 1.0
