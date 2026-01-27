# CRM Mini Application

## Description
CRM Mini is a learning project built with Spring Boot.  
Initially, the idea was to create a booking application, but during development I made it into a light version od CRM system for managing client data.

The main goal of this project is to practice core Spring concepts such as:
- layered architecture
- Spring Data JPA
- working with a database
- Docker-based setup

---

##  Functionality
- Create a client
- Edit/update client data
- Delete a client
- Download client data

---

##  Architecture
The application follows a classic layered architecture:

- **Controller** – handles HTTP requests
- **Service** – contains business logic
- **Repository** – interacts with the database
- **Entity** – represents the data model

---

## Tools used
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- React
- Docker

---

##  Quick Start

### 1️⃣ Clone the repository in IDE
```bash
git clone https://github.com/olegberz/mini-crm.git
cd mini-crm
```
### 2️⃣ Build the project
#### You can use [Maven Wrapper](https://maven.apache.org/tools/wrapper/) (recommended) or local [Maven](https://maven.apache.org/download.cgi).
```bash
mvn clean package -DskipTests
```

### 3️⃣ Run with Docker
```bash
docker-compose build
docker-compose up -d
```
### 4️⃣ Open the application

##### Frontend is available at:
```bash
http://localhost:3000
```
## Notes

This project is created for learning purposes and may be extended in the future.


