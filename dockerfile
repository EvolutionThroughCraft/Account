FROM maven:3.5-jdk-8 AS build  
COPY pom.xml /tmp
COPY src /tmp/src
WORKDIR /tmp
RUN mvn -f pom.xml package

FROM gcr.io/distroless/java
COPY --from=build /tmp/target/account-0.0.1-SNAPSHOT.jar /tmp/images/account-0.0.1-SNAPSHOT.jar
# EXPOSE 8080
# change the above line to match with port that the project is listening on  
ENTRYPOINT ["java","-jar","/tmp/images/account-0.0.1-SNAPSHOT.jar"]