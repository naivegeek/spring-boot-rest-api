# spring-boot-rest-api
Developing REST Apis based on Spring Boot.

Demonstrates simple rest api based on spring boot, jpa .

to run the app

mvn clean install

mvn spring-boot:run

to sell the list of all events
GET http://localhost:8080/events/


To pull a event based on a eventId
GET http://localhost:8080/events/event/{eventId}

To create a event 

PUT http://localhost:8080/events/event


To update a event 

POST http://localhost:8080/events/event

TO delete a event record by eventId

DELETE GET http://localhost:8080/events/event/{eventId}




