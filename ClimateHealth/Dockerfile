# Use Maven to build the WAR file
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn clean package

# Use Tomcat to deploy the WAR file
FROM tomcat:10.1.18-jdk17
WORKDIR /usr/local/tomcat/webapps/ROOT/

# Copy WAR file
COPY --from=build /app/target/climate-health.war /usr/local/tomcat/webapps/ROOT.war

# ✅ Ensure `config.properties` is copied correctly
COPY --from=build /app/src/main/resources/config.properties /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/config.properties

# Expose Port
EXPOSE 8080
