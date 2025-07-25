# Use Tomcat as the base image
FROM tomcat:9.0

# Remove default Tomcat ROOT app
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy all your project files to the Tomcat webapps folder
COPY . /usr/local/tomcat/webapps/LibraryApp

# Expose port 8080
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
