#!/bin/bash
docker rm -f some-rabbit
docker rmi -f instant-payment:0.0.1
docker rmi -f instant-credit:0.0.1
mvn -f ../instant-payment/pom.xml clean package
mvn -f ../instant-credit/pom.xml clean package
docker-compose up -d


