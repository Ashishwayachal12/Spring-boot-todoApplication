# ===============================
# Stage 1: Build the application
# ===============================
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy pom.xml and download dependencies (cached layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build application
COPY src ./src
RUN mvn clean package -DskipTests

# ===============================
# Stage 2: Run the application
# ===============================
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy JAR file from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (default Spring Boot port)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","app.jar"]
