FROM openjdk:8-jdk-alpine

RUN mkdir -p ./var/www/html/who-knows-backend

WORKDIR ./var/www/html/who-knows-backend

COPY build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]