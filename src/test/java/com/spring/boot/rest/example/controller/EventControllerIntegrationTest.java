package com.spring.boot.rest.example.controller;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.spring.boot.rest.example.DemoApplication;
import com.spring.boot.rest.example.model.Event;
import com.spring.boot.rest.example.service.EventService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { DemoApplication.class })
@WebIntegrationTest(randomPort = true)
public class EventControllerIntegrationTest {

    @Autowired
    private EventsController eventsController;

    @Autowired
    private EventService eventService;

    final String BASE_URL = "http://localhost:8080/api/events/";
    /*
     * Not able to start the embedded tomcat server while running the test, therefore I had to run the 
     * server manually from outside. using
     * mvn spring-boot:run
     * 
     * And I tested the application with following CURL test URLS
     * 
     * Creating a EVENT. 
        curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/api/events/ -d '{"eventType":"privateEvent","eventDetails":"summer party","eventLocation":"pista house, #309, culver city, ca 90230"}' 
        
        curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/api/events/ -d '{"eventType":"publicEvent","eventDetails":"summer party","eventLocation":"1100 gelndon,westwood, ca 90024"}'
        
        Register a User with userId=1 to a new Event
        curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/api/events/register/1 -d '{"eventType":"publicEvent","eventDetails":"code meetup","eventLocation":"1100 gelndon,westwood, ca 90024"}'
        
        Update and existing Event with eventId=22
        curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/api/events/ -d '{"id":"22","eventType":"privateChangedEvent","eventDetails":"summer party","eventLocation":"1100 gelndon westwood ca 90024"}'
        
        Delete a Event.
        curl -i -X DELETE -H "Content-Type:application/json" http://localhost:8080/api/events/3/
        
        Get list of Events
        curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/events/
        
        Get Event with id=1
        curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/events/1/
        
        Get list of all Events with pagenation
        curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/events/1/10
        
        Get list of Events registered for User with userId=1
        curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/events/user/1
        
     */
    @Test
    @Ignore
    public void testCreateEvent() {

        Event e = new Event();
        e.setDateCreated(new Date());
        e.setDateUpdated(new Date());
        e.setEventDetails("Dinner Party");
        e.setEventLocation("90230");
        e.setEventType("PRIVATE");

        RestTemplate rest = new TestRestTemplate();
        rest.put(BASE_URL, e);

    }
    
    
}
