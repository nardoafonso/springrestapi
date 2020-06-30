
call mvn clean install -f ../pom.xml
call docker-compose run --build
