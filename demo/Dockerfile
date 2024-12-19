# Step 1: Use a base image with OpenJDK 21
FROM openjdk:21-jdk-slim as build

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the pom.xml and other necessary files to the container
COPY pom.xml ./

# Step 4: Download dependencies (you can avoid downloading on every build if dependencies are unchanged)
RUN mvn clean install -DskipTests

# Step 5: Copy the rest of the application code
COPY src ./src

# Step 6: Build the application
RUN mvn clean package -DskipTests

# Step 7: Use a smaller base image to run the application
FROM openjdk:21-jdk-slim

# Step 8: Set the working directory inside the container
WORKDIR /app

# Step 9: Copy the built jar file from the build stage to the runtime image
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

# Step 10: Expose the port your app will run on (8080 is default for Spring Boot)
EXPOSE 8080

# Step 11: Run the application
ENTRYPOINT ["java", "-jar", "/app/demo.jar"]
