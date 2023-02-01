FROM gradle

WORKDIR /app

COPY /build/libs/docker-research-0.0.1-SNAPSHOT.jar /app/docker-research-0.0.1-SNAPSHOT.jar
#COPY . .

#RUN gradle clean build

EXPOSE 80

#RUN mkdir joke_vol - also works - but is not a container/docker way of doing things

#VOLUME [ "/app/joke_vol" ] - annonymous volumes

#CMD ["gradle", "bootRun"]
CMD ["java", "-jar", "/app/docker-research-0.0.1-SNAPSHOT.jar"]
