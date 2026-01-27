# CRM Mini Application

## Description
CRM Mini is a learning project built with Spring Boot.  
Initially, the idea was to create a booking application, but during development it evolved into a lightweight CRM system for managing client data.

The main goal of this project is to practice core Spring concepts such as:
- layered architecture
- Spring Data JPA
- working with a database
- Docker-based setup

---

## ⚙️ Functionality
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

## 🛠️ Technologies
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

### 1️⃣ Clone the repository
```bash
git clone https://github.com/olegberz/mini-crm.git
cd mini-crm
```
### 2️⃣ Build the project
#### You can use Maven Wrapper (recommended) or local Maven.
```bash
mvn clean package -DskipTests
```

### 3️⃣ Run with Docker
```bash
docker-compose build
docker-compose up -d
```
### 4️⃣ Open the application

#### Frontend is available at:
```bash
http://localhost:3000
```



