FROM openjdk:8
MAINTAINER Mingming Li  "21374618@qq.com"

WORKDIR /app
COPY target/api-0.0.3.jar /app

ENTRYPOINT ["java", "-jar", "/app/api-0.0.3.jar"]