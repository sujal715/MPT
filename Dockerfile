FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Copy source code
COPY src/ src/

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean install -DskipTests

# Expose port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/mpt-0.0.1-SNAPSHOT.jar"]
