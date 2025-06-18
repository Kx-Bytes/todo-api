# Use a lightweight Java runtime image
FROM openjdk:17-jdk-slim

# Create a volume for temporary files
VOLUME /tmp

# Set a build-time variable for the JAR file name and path
ARG JAR_FILE=target/todo-api-1.0.0-SNAPSHOT.jar

# Copy the built JAR file into the image as app.jar
COPY ${JAR_FILE} app.jar

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "/app.jar"]