#!/bin/bash
docker rm -f some-rabbit
docker rmi -f producer-payment:0.0.1
docker rmi -f consumer-payment:0.0.1
docker-compose up -d


