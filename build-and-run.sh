#!/bin/bash

echo "=== Spring Boot 3.5.5 Application Build and Run Script ==="

# Build the JAR file
echo "Building Spring Boot JAR..."
mvn clean package -DskipTests

if [ $? -eq 0 ]; then
    echo "Build successful!"
    
    # Run the application
    echo "Starting Spring Boot application..."
    java -jar target/docker-demo-spring-boot-1.0.0.jar
else
    echo "Build failed!"
    exit 1
fi