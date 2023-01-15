FROM gradle

WORKDIR /docker-research-build-own-image

COPY . /docker-research-build-own-image

RUN gradle clean build

EXPOSE 80

#CMD ["gradle", "bootRun"]
CMD ["java", "-jar", "/docker-research-build-own-image/build/libs/docker-research-0.0.1-SNAPSHOT.jar"]
