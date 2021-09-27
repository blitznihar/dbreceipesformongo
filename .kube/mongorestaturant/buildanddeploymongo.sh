docker build -t blitznihar/mongorestaurant .
docker push blitznihar/mongorestaurant
docker run -p 27019:27017 blitznihar/mongorestaurant
