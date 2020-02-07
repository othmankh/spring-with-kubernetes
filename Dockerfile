# Start with a base image containing Java runtime (mine java 8)
FROM openjdk:latest
VOLUME /tmp
# The application's jar file (when packaged)
ARG JAR_FILE=build/libs/demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
# Add the application's jar to the container
ADD ${JAR_FILE} demo.jar
# Run the jar file 
ENTRYPOINT ["java","-jar","demo.jar"]