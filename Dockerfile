# Use the official OpenJDK 17 image as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/calc.jar /app/calculator.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "calculator.jar"]
