FROM openjdk:11-jre-slim
MAINTAINER "William Reges: https://github.com/WilliamRegesDeveloper"

RUN mkdir app
WORKDIR /app

ARG JAR_FILE
ADD /target/${JAR_FILE} app.jar
CMD java -jar -Dserver.port=8080 app.jar

