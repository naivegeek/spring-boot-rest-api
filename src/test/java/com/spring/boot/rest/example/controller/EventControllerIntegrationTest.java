package com.spring.boot.rest.example.controller;

import java.util.Date;

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

    @Test
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
