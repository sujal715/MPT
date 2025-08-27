# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the entire mpt-unified directory
COPY mpt-unified/ .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/mpt-0.0.1-SNAPSHOT.jar"]
