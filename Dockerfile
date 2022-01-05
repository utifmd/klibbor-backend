FROM openjdk:8-jdk-alpine

RUN mkdir -p ./var/www/html/who-knows-backend

WORKDIR ./var/www/html/who-knows-backend

COPY . .

ENTRYPOINT ["java", "-jar", "build/libs/who-knows-backend-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
