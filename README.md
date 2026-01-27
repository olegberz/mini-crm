# CRM-mini Applicaation

## Description
It's a learning project developed on Spring Boot. At first there was idea to make Booking application, but in process I decided to make lite version of CRM to manipulate with client data. I wanted to try touch some basics in Spring data.

## Functionality

1. Create client
2. Update/Edit client
3. Delete client
4. Download client data

## Architecture
#### Here it's in classical way, laayer type:

1. Controller - HTTP request handler
2. Service - buisness-logic
3. Reository - work with databse
4. Entitty - data model

## Tools

Java 17
Spring Boot
Spring Web
Spring Data JPA
Hibernate
MYSQL
React
Docker

## Quickstart

### 1. **Clone repository**
```bash
$ git clone https://github.com/olegberz/mini-crm.git
$ cd mini-crm
```
### 2. **Setup Maven Apache**

 Download Apache Maven latest community version from [here](https://maven.apache.org/download.cgi).
 (Or you can just use Maven wrapepr)

## 3. Run project
 ```md
 $ mvn clean package -DskipTests
 $ docker=compose build
 $ docker-compose up -d
 ```
#### Now you can look your application on [localhost:3000](http://localhost:3000)

