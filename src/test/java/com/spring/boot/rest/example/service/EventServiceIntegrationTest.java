package com.spring.boot.rest.example.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.boot.rest.example.DemoApplication;
import com.spring.boot.rest.example.model.Event;

/*
 * @author srinath medala
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { DemoApplication.class })
public class EventServiceIntegrationTest {

    @Autowired
    private EventService eventService;

    @Test
    public void testSaveEvent() {
        Event event = new Event();
        event.setDateCreated(new Date());
        event.setDateUpdated(new Date());
        event.setEventDetails("Test Event");
        event.setEndDate(new Date());
        event.setStartDate(new Date());
        event.setEventType("Private");
        Assert.assertNull(event.getId());
        eventService.save(event);
        Assert.assertNotNull("Event Id should not be NULL", event.getId());
        Event fromDbEvent = eventService.findEventById(event.getId());
        Assert.assertEquals(fromDbEvent.getEventType(), event.getEventType());
    }

    @Test
    public void testFindAll() {
        createEvents();
        List<Event> events = eventService.findAll();
        Assert.assertTrue(events.size() == 40);
    }

    @Test
    public void testFindAllPagination() {
        createEvents();
        List<Event> events = eventService.findAll(1, 10);
        Assert.assertTrue("", events.size() == 10);

        events = eventService.findAll(2, 2);
        Assert.assertTrue("", events.size() == 2);
    }

    @Test
    public void updateEvent() {

        Event event = new Event();
        event.setDateCreated(new Date());
        event.setDateUpdated(new Date());
        event.setEventDetails("Test Event");
        event.setEndDate(new Date());
        event.setStartDate(new Date());
        event.setEventType("Private");
        Assert.assertNull(event.getId());
        event = eventService.save(event);
        Assert.assertNotNull("Event Id should not be NULL", event.getId());

        Event fromDbEvent = eventService.findEventById(event.getId());
        Assert.assertEquals(fromDbEvent.getEventType(), event.getEventType());

        event.setEventDetails("Changing Event Details");
        event = eventService.save(event);

        Assert.assertEquals("Changing Event Details", event.getEventDetails());

    }

    @Test
    public void deleteEvent() {
        Event event = new Event();
        event.setDateCreated(new Date());
        event.setDateUpdated(new Date());
        event.setEventDetails("Test Event");
        event.setEndDate(new Date());
        event.setStartDate(new Date());
        event.setEventType("Private");
        Assert.assertNull(event.getId());
        event = eventService.save(event);
        Assert.assertNotNull("Event Id should not be NULL", event.getId());

        eventService.delete(event.getId());
    }

    private void createEvents() {
        for (int i = 1; i <= 20; i++) {
            Event event = new Event();
            event.setDateCreated(new Date());
            event.setDateUpdated(new Date());
            event.setEventDetails("Test Event" + UUID.randomUUID().toString());
            event.setEndDate(new Date());
            event.setStartDate(new Date());
            event.setEventType("Private" + i);
            Assert.assertNull(event.getId());
            eventService.save(event);
        }
    }

}
