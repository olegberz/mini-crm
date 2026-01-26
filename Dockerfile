FROM eclipse-temurin:17
ADD target/mini-crm-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]