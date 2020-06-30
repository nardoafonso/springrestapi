#!/bin/bash

mvn clean install -f ../pom.xml
docker-compose run --build