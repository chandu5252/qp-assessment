FROM openjdk:8
EXPOSE 8080

# Set the working directory in the container
WORKDIR /springboot-crud-k8s

# Copy the executable JAR file to the container
COPY target/springboot-crud-k8s.jar springboot-crud-k8s.jar

# Run the JAR file
ENTRYPOINT ["java","-jar","/springboot-crud-k8s.jar"]




