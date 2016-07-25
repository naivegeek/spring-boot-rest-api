# spring-boot-rest-api
Developing REST Apis based on Spring Boot.

Demonstrates simple rest api based on spring boot, jpa . The rest app generates events and Users .
User can create a account and create a event.

Please Note: App when started creates dummy data for events,users and registers users with events.

To run the app please execute the following commands

mvn clean install

mvn spring-boot:run

Get all the events
GET http://localhost:8080/api/events 

Get paginated events
GET http://localhost:8080/api/events/{pageNumber}/{pageSize}

Get event by id
GET http://localhost:8080/api/events/{eventId}

Create event
PUT http://localhost:8080/api/events/

Update event
POST http://localhost:8080/api/events/

Delete event
DELETE http://localhost:8080/api/events/{eventId}

Register Event for User for userId
PUT http://localhost:8080/api/events/register/{userid} 

To get List of Events for a given userId

GET http://localhost:8080/api/events/user/{userId}

ex: http://localhost:8080/api/events/user/1


Get all Users

GET http://localhost:8080/api/users/

Get paginated users
GET http://localhost:8080/api/users/{pageNumber}/{pageSize}

Get User by id
GET http://localhost:8080/api/users/{userId}

Create User
PUT http://localhost:8080/api/users/

Update User
POST http://localhost:8080/api/users/

Delete User by userId
DELETE http://localhost:8080/api/users/{userId}

To get the List of Users registered for a particular event

GET http://localhost:8080/api/users/event/{eventId}

example
http://localhost:8080/api/users/event/1


CURL examples

sudo mvn clean install
sudo mvn spring-boot:run

Testing the application using  CURL

Creating a USER.
curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/api/users/ -d '{"firstName":"Eric","lastName":"smith","username":"ericsmith","password":"password"}'

Updating the USER with userId=1.
curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/api/users/ -d '{"id":"1","firstName":"John","lastName":"Boarding","username":"john446","password":"password"}'

Delete a User.
curl -i -X DELETE -H "Content-Type:application/json" http://localhost:8080/api/users/3/

Get list of all Users
curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/users/

Get User with id=1
curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/users/user/1/

Get list of all Users with pagenation
curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/users/1/10

Get list of Users registered for the event with eventId=10
curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/users/event/10


Creating a EVENT. 
curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/api/events/ -d '{"eventType":"privateEvent","eventDetails":"summer party","eventLocation":"pista house, #309, culver city, ca 90230"}' 

curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/api/events/ -d '{"eventType":"publicEvent","eventDetails":"summer party","eventLocation":"1100 gelndon,westwood, ca 90024"}'

curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/api/events/register/1 -d '{"eventType":"publicEvent","eventDetails":"code meetup","eventLocation":"1100 gelndon,westwood, ca 90024"}'

Updating a existing event with eventId=22.
curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/api/events/ -d '{"id":"22","eventType":"privateChangedEvent","eventDetails":"summer party","eventLocation":"1100 gelndon,westwood, ca 90024"}'

Delete a Event.
curl -i -X DELETE -H "Content-Type:application/json" http://localhost:8080/api/events/3/

Get list of Events
curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/events/

Get Event with id=1
curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/events/1/

Get list of all Events with pagenation
curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/events/1/10

















