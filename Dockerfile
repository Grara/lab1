FROM openjdk:21-jdk
LABEL maintainer="test"
ARG JAR_FILE=build/libs/lab1-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} docker-test.jar
ENTRYPOINT ["java","-jar","/docker-test.jar"]