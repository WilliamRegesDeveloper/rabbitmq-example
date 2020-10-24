FROM adoptopenjdk/openjdk11:alpine-slim AS base
MAINTAINER "William Reges: https://github.com/WilliamRegesDeveloper"
WORKDIR /app


FROM adoptopenjdk/maven-openjdk11 AS build
MAINTAINER "William Reges: https://github.com/WilliamRegesDeveloper"
WORKDIR /build
COPY . .
RUN mvn -f ./pom.xml clean install -U -DskipTest=true
RUN cp target/consumer-payment-0.0.1.jar /app.jar


FROM base AS deploy
COPY --from=build /app.jar .
RUN ls -lt
CMD java -jar -Dserver.port=8080 app.jar

