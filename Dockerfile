FROM openjdk:11-jdk-alpine
VOLUME /tmp
ADD target/digtask-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]