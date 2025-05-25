# 1. Build bosqichi (agar Docker ichida build qilishni xohlasangiz)
FROM maven:3.9.3-eclipse-temurin-21 AS build

WORKDIR /app

# pom.xml va src ni konteynerga nusxalash
COPY pom.xml .
COPY src ./src

# Maven bilan build qilish
RUN mvn clean package -DskipTests

# 2. Run bosqichi
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Build bosqichidan .jar faylni olish
COPY --from=build /app/target/Sakina_bot-1.0-SNAPSHOT.jar app.jar

# Java jarni ishga tushirish
ENTRYPOINT ["java", "-jar", "app.jar"]
