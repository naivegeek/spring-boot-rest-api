package com.spring.boot.rest.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.rest.example.model.Event;
import com.spring.boot.rest.example.model.EventUser;
import com.spring.boot.rest.example.service.EventService;
import com.spring.boot.rest.example.service.EventUserService;

/*
 * @author srinath medala
 */

@RequestMapping("/api/events")
@RestController
public class EventsController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventUserService eventUserService;

    private static Logger log = LoggerFactory.getLogger(EventsController.class);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable("id") Long id) {
        log.info("Get Event information by id: {}", id);
        Event event = eventService.findEventById(id);
        return event;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Event> findAll() {
        return eventService.findAll();
    }
    
    @RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
    public List<Event> findAllEventsForUser(@PathVariable("userid") Long userId) {
        return eventUserService.findAllEventsRegisteredForUser(userId);
    }
    
    @RequestMapping(value = "/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public List<Event> findAll(@PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize) {
        return eventService.findAll(pageNumber,pageSize);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Event create(@RequestBody Event event) {
        return eventService.save(event);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Event update(@RequestBody Event event) {
        Assert.notNull(event);
        Assert.notNull(event.getId());
        return eventService.update(event);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        eventService.delete(id);
        return "ok";
    }

    @RequestMapping(value = "/register/{userid}", method = RequestMethod.PUT)
    public EventUser registerUser(@RequestBody Event event, @PathVariable("userid") Long userId) {
        event = eventService.save(event);
        EventUser eventUser = new EventUser();
        eventUser.setEventId(event.getId());
        eventUser.setUserId(userId);
        eventUserService.save(eventUser);
        return eventUser;
    }
    
    
}