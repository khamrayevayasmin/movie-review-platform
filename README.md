# 🎬 Movie Review Platform

Backend application built with Spring Boot by **Yasmin**

## 📋 Description
A RESTful API for managing movies, actors, genres and reviews with authentication.

## 🛠 Tech Stack
- Java 17
- Spring Boot 3.5.14
- Spring Security + JWT
- PostgreSQL
- Docker & Docker Compose
- Swagger UI

## 📦 Entities
- User
- Movie
- Genre
- Actor
- Review

## 🚀 How to Run

### With Docker:
```bash
docker-compose up --build
```

### Without Docker:
```bash
mvn spring-boot:run
```

## 📖 API Documentation
After running, open:
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- Health Check: http://localhost:8080/actuator/health

## 🔐 Authentication
1. Register: `POST /api/auth/register`
2. Login: `POST /api/auth/login`
3. Use the JWT token in header: `Authorization: Bearer <token>`