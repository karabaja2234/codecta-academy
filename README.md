# Selman Patković - Codecta Full Stack Academy repository 

## Main description

```
This repository will be used to store all exercises, homeworks and other 
programming related files regarding the Codecta's Full Stack Academy.
```

## Main project: The Orb of Quarkus Game

```
In case you want to test and play the mentioned game, follow the instructions below.
```

## The Orb of Quarkus (Web version)

- The frontend part of the game is located in the folder called "orb-of-quarkus-frontend" and it is made in React.js
- The backend part of the game is located in the folder called "Midterm-JavaGame" and it is made in Java, Docker, Quarkus and PostreSQL

###### How to start the game?

- First you need to bring up the docker container by running the command below:

```
docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 
--name quarkus_test -e POSTGRES_USER=quarkus_test -e 
POSTGRES_PASSWORD=quarkus_test -e POSTGRES_DB=quarkus_test -p 5432:5432 postgres:10.5
```

- After that, go into the backend folder of the game and run the command below:

```
mvn compile quarkus:dev
```

- Previously mentioned steps will bring up the backend and create the "codecta" schema in the PostreSQL database
- Next step is to add the data into the database. You can do this step with a Postman/Insomnia, by sending the api requests that I will list below:

:heavy_check_mark: Create the game by sending a POST request to: http://localhost:8080/game/newgame (body: {})

:heavy_check_mark: Create the level by sending a POST request to: http://localhost:8080/game/newlevel (body: {
    "difficulty": 1
})

:heavy_check_mark: Create the map by sending a POST request to: http://localhost:8080/game/newmap (body: {
    "gameId": 1,
    "levelId": 1
})

:heavy_check_mark: Create a dungeon by sending a POST request to http://localhost:8080/game/newdungeon (body: {
    "mapId": 1
}) - You should send this same request 3 times, so the map has 3 dungeons that you can test the game with

:heavy_check_mark: Create a healing potion by sending a POST request to http://localhost:8080/game/newitem (body: {
    "name": "Healing potion",
    "value": 50
})

:heavy_check_mark: Create a damage increasing potion by sending a POST request to http://localhost:8080/game/newitem (body: )

## Homework 1

A simple java console application which implements the following:

:heavy_check_mark: Maven

:heavy_check_mark: Java classes

:heavy_check_mark: Log4j

:heavy_check_mark: Command line arguments

:heavy_check_mark: Reading data from text files


To start the application you need to be inside the target folder and use one of the two options:

:heavy_check_mark: java -jar Homework1-1.0-SNAPSHOT.jar -i disneyland

:heavy_check_mark: java -jar Homework1-1.0-SNAPSHOT.jar -i netflix


