FROM openjdk:11.0.4-jre-slim

RUN mkdir /app

WORKDIR /app

ADD ./api/target/login-api-1.0.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "login-api-1.0.0-SNAPSHOT.jar"]