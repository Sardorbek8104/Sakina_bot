
# Build stage
FROM maven:3.8.6-openjdk-17 AS build

WORKDIR /app

COPY BotService/pom.xml ./pom.xml
COPY BotService/src ./src

RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/BotService-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

