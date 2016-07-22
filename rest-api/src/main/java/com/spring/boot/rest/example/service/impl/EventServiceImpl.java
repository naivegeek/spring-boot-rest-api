package com.spring.boot.rest.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.rest.example.model.Event;
import com.spring.boot.rest.example.repositories.EventRepository;
import com.spring.boot.rest.example.service.EventService;

/*
 * @author srinath medala
 */
@Service("eventService")
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findAll() {
        return transform(eventRepository.findAll());
    }
    
    

    @Override
    public Event findEventById(Integer eventId) {
        return eventRepository.findOne(eventId);
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event update(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void delete(Integer eventId) {
        eventRepository.delete(eventId);

    }

    private List<Event> transform(Iterable<Event> iterable) {
        List<Event> events = new ArrayList<Event>();
        iterable.forEach((event) -> {
            events.add(event);
        });
        return events;
    }

}
