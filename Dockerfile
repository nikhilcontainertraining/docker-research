FROM gradle

WORKDIR /app

#COPY /build/libs/docker-research-0.0.1-SNAPSHOT.jar /app/docker-research-0.0.1-SNAPSHOT.jar
COPY . .

RUN gradle clean build

EXPOSE 80

VOLUME [ "/app/joke_vol" ]

CMD ["gradle", "bootRun"]
#CMD ["java", "-jar", "/app/docker-research-0.0.1-SNAPSHOT.jar"]
