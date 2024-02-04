# Use a lightweight base image with JDK 17
FROM openjdk:17-jdk

# Set working directory
WORKDIR /app

# Copy the application JAR file
COPY build/libs/lovelace-api-0.1.jar ageoflovelace.jar

# Expose the application port (8080 by default for Spring Boot)
EXPOSE 8080

# Start the application using the exec form of ENTRYPOINT for better signal handling
ENTRYPOINT ["java", "-jar", "/app/ageoflovelace.jar"]
