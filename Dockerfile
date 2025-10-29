# Step 1: Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the JAR file from the target folder to the container
COPY target/*.jar app.jar

# Step 4: Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
