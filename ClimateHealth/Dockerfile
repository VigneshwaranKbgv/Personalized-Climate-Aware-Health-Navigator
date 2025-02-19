# Use Maven to build the WAR file inside the container
FROM maven:3.8.8-eclipse-temurin-17 AS build

# Set working directory inside the container
WORKDIR /app

# Copy only the pom.xml first to leverage Docker cache
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the entire project
COPY . .

# Build the WAR file
RUN mvn clean package

# Use Tomcat to deploy the WAR file
FROM tomcat:10.1.18-jdk17

# Copy the generated WAR file to Tomcat's webapps directory
COPY --from=build /app/target/climate-health.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080 for web traffic
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
