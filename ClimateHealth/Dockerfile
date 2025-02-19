# Use Tomcat 10 with JDK 17
FROM tomcat:10.1.0-jdk21

# Remove default ROOT application
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy WAR file into Tomcat webapps directory
COPY target/climate-health.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080 for web traffic
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
