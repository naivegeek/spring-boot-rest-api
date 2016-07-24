# spring-boot-rest-api
Developing REST Apis based on Spring Boot.

Demonstrates simple rest api based on spring boot, jpa . The rest app generates events and Users .
User can create a account and create a event.

to run the app

mvn clean install

mvn spring-boot:run

Get all the events
GET http://localhost:8080/api/events

Get paginated events
GET http://localhost:8080/api/events/{pageNumber}/{pageSize}

Get event by id
GET http://localhost:8080/api/events/{eventId}

Create event
POST http://localhost:8080/api/events

Update event
PUT http://localhost:8080/api/events/{eventId}

Delete event
DELETE http://localhost:8080/api/events/{eventId}

Register Event for User for userId
PUT http://localhost:8080/api/events/register/{userid} 

Get all Users

GET http://localhost:8080/api/users

Get paginated users
GET http://localhost:8080/api/users/{pageNumber}/{pageSize}

Get User by id
GET http://localhost:8080/api/users/{userId}

Create User
POST http://localhost:8080/api/users

Update User
PUT http://localhost:8080/api/users/{userId}

Delete User by userId
DELETE http://localhost:8080/api/users/{userId}







