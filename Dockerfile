FROM openjdk:8
EXPOSE 8080

# Set the working directory in the container
WORKDIR /easyShop

# Copy the executable JAR file to the container
COPY target/easyShop.jar easyShop.jar

# Run the JAR file
ENTRYPOINT ["java","-jar","/easyShop.jar"]




