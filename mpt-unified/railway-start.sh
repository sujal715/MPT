#!/bin/bash

echo "🚀 Starting MPT Spring Boot Application on Railway..."

# Set Java options for Railway
export JAVA_OPTS="-Xmx512m -Xms256m"

# Start the Spring Boot application
echo "Starting with Java options: $JAVA_OPTS"
java $JAVA_OPTS -jar target/mpt-0.0.1-SNAPSHOT.jar
