FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/Car-Rental-0.3.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]