#FROM eclipse-temurin:17-jdk-alpine
#WORKDIR /app
#COPY target/demo.jar demo.jar
#EXPOSE 8080
#CMD ["java","-jar","demo.jar"]

# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

# Stage 2: Run the application
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/Vip-Sp-0.0.1-SNAPSHOT.jar ./Vip-Sp.jar
EXPOSE 8080
CMD ["java", "-jar", "Vip-Sp.jar"]