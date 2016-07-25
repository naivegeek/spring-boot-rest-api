package com.spring.boot.rest.example.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import com.spring.boot.rest.example.DemoApplication;
import com.spring.boot.rest.example.model.Event;
import com.spring.boot.rest.example.repositories.EventRepository;

/*
 * @author srinath medala
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { DemoApplication.class })
public class EventRespositoryIntegrationTest {

    @Autowired
    private EventRepository eventRepository;

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
        eventRepository.save(event);
        Assert.assertNotNull("Event Id should not be NULL", event.getId());
        Event fromDbEvent = eventRepository.findOne(event.getId());
        Assert.assertEquals(fromDbEvent.getEventType(), event.getEventType());
    }

    @Test
    public void testFindAll() {
        createEvents();
        List<Event> events = eventRepository.findAll();
        Assert.assertTrue("", events.size() > 20);
    }

    @Test
    public void testFindAllPagination() {
        createEvents();
        List<Event> events = null;
        int pageNumber = 1;
        int pageSize = 10;
        PageRequest page = new PageRequest(pageNumber - 1, pageSize);
        Page<Event> pages = eventRepository.findAll(page);
        if (pages != null && !CollectionUtils.isEmpty(pages.getContent())) {
            events = pages.getContent();
        }
        Assert.assertTrue("", events.size() == 10);

        pageNumber = 2;
        pageSize = 2;

        page = new PageRequest(pageNumber - 1, pageSize);
        pages = eventRepository.findAll(page);
        if (pages != null && !CollectionUtils.isEmpty(pages.getContent())) {
            events = pages.getContent();
        }
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
        event = eventRepository.save(event);
        Assert.assertNotNull("Event Id should not be NULL", event.getId());

        Event fromDbEvent = eventRepository.findOne(event.getId());
        Assert.assertEquals(fromDbEvent.getEventType(), event.getEventType());

        event.setEventDetails("Changing Event Details");
        event = eventRepository.save(event);

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
        event = eventRepository.save(event);
        Assert.assertNotNull("Event Id should not be NULL", event.getId());

        eventRepository.delete(event.getId());
        Event e = eventRepository.findOne(event.getId());
        Assert.assertNull(e);
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
            eventRepository.save(event);
        }
    }

}
