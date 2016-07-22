package com.spring.boot.rest.example.service;

import java.util.List;

import com.spring.boot.rest.example.model.Event;

/*
 * @author srinath medala
 */
public interface EventService {

    List<Event> findAll();

    Event findEventById(Integer eventId);

    Event save(Event event);

    Event update(Event event);

    void delete(Integer eventId);
}
