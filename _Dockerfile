FROM openjdk:11-jdk-oracle
WORKDIR /docker-research
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} docker-research-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/docker-research-0.0.1-SNAPSHOT.jar"]

