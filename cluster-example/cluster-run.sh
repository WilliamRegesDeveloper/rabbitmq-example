#!/bin/bash
docker rm -f some-rabbit
docker rmi -f producer-payment:0.0.1
docker rmi -f consumer-payment:0.0.1
mvn -f ../producer-payment/pom.xml clean package
mvn -f ../consumer-payment/pom.xml clean package
docker-compose up -d


