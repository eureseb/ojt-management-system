# Use a base image with Java and Gradle installed
FROM gradle:latest AS builder

# Set the working directory in the container
WORKDIR /app

# Copy everything from the current directory to the working directory in the container
COPY . .

# Build the application
RUN gradle clean build --no-daemon -x test

# Use a smaller base image for the runtime environment
FROM openjdk:latest AS runtime

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built in the previous stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port that the application runs on
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]
