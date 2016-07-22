package com.spring.boot.rest.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.rest.example.model.Event;
import com.spring.boot.rest.example.service.EventService;

/*
 * @author srinath medala
 */

@RequestMapping("/api/events")
@RestController
public class EventsController {

    @Autowired
    private EventService eventService;

    private static Logger logger = LoggerFactory.getLogger(EventsController.class);

    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable("id") Integer id) {
        logger.info("Get Event information by id: {}", id);
        Event event = eventService.findEventById(id);
        return event;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Event> findAll() {
        return eventService.findAll();
    }
    
    
    @RequestMapping(value = "/event", method = RequestMethod.PUT)
    public Event create(@RequestBody Event event) {
        return eventService.save(event);
    }
    
    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public Event update(@RequestBody Event event) {
        return eventService.update(event);
    }
    
    @RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
         eventService.delete(id);
         return "ok";
    }
}