FROM maven:3.5-jdk-8 AS build  
COPY src /opt/apps/Account
COPY pom.xml /opt/apps/Account 
RUN mvn -f /opt/apps/Account/pom.xml clean package

FROM gcr.io/distroless/java  
COPY target/account-1.0.0-SNAPSHOT.jar /opt/images/account-1.0.0-SNAPSHOT.jar  
EXPOSE 8080  
CMD ["java","-jar","/opt/images/account-1.0.0-SNAPSHOT.jar"]  