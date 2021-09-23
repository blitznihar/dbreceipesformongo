./mvnw install -Dmaven.test.skip=true
docker build -t blitznihar/dbreceipesformongo .
docker push blitznihar/dbreceipesformongo
docker run -p 7109:7109 -p 6109:6109 -t blitznihar/dbreceipesformongo:latest

docker-compose build

https://techsparx.com/software-development/docker/damp/mongodb.html

docker network create mnet