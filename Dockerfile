# Build bosqichi
FROM maven:3.9.3-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Run bosqichi
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# 'jar-with-dependencies' faylni nusxa olish kerak
COPY --from=build /app/target/Sakina_bot-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
