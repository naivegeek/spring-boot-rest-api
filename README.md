# spring-boot-rest-api
Developing REST Apis based on Spring Boot.

Demonstrates simple rest api based on spring boot, jpa . The rest app generates events and Users .
User can create a account and create a event.

Please Note: App when started creates dummy data for events,users and registers users with events.

To run the app please execute the following commands.

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


CURL examples

Creating a USER
$ curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/api/users/ -d '{"firstName":"Eric","lastName":"smith","username":"ericsmith","password":"password"}'
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
X-Application-Context: application
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Mon, 25 Jul 2016 07:35:35 GMT

{"id":3,"email":null,"username":"ericsmith","password":"password","firstName":"Eric","lastName":"smith","dateRegistered":null,"dateUpdated":null}

Creating a EVENT
$ curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/api/events/ -d '{"eventType":"privateEvent","eventDetails":"summer party","eventLocation":"pista house culver city ca 90230"}'
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
X-Application-Context: application
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Mon, 25 Jul 2016 07:41:44 GMT

{"id":26,"eventType":"privateEvent","eventDetails":"summer party","startDate":null,"endDate":null,"dateCreated":null,"dateUpdated":null,"eventLocation":"pista house culver city ca 90230"}






