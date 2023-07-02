# Quiz

## Description
Conducting a quiz, issuing a list of answers in a readable form and exporting to CSV. Spring Security implements
authorization in memory to view the quiz results.

## Used tools
* Platform: Spring Boot 2.6.1
* Builder: Gradle 7.2
* DBMS: PostgreSQL 14.1
* Languages: Java SE 8u311, HTML5, CSS3

## Important files
* Builder configuration: /build.gradle
* Application properties: /src/main/resources/application.properties
* Security configuration: /src/main/java/web/quiz/config/SecurityConfig.java

## Frontend and backend schema
![Relationships of elements](readme/front-back-schema.svg)

## Installation
1. Create quiz database in PostgreSQL
2. Run this project in a development environment
3. Open http://localhost:8080 in the browser

## Release notes
* Project type: Web application
* Date of release: 15 December 2021
* Date of last update: 2 July 2023
* Current version: 2.5
