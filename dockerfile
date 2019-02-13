FROM maven:3.5-jdk-8 AS build  
COPY src /opt/apps/Account
COPY src /opt/apps/Account
WORKDIR /opt/apps/Account
RUN mvn -f pom.xml clean package

FROM gcr.io/distroless/java  
COPY /target/account-0.0.1-SNAPSHOT.jar /opt/images/account-0.0.1-SNAPSHOT.jar  
WORKDIR /opt/images

# EXPOSE 8080
# change the above line to match with port that the project is listening on  
ENTRYPOINT ["java","-jar","account-0.0.1-SNAPSHOT.jar"]  