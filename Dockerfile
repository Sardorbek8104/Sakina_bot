# Dockerfile
FROM eclipse-temurin:17-jdk-alpine

# App faylni konteynerga nusxalash
COPY target/BotService-1.0-SNAPSHOT.jar app.jar

# Jar faylni ishga tushirish
ENTRYPOINT ["java", "-jar", "app.jar"]
