package com.spring.boot.rest.example.service;

import java.util.List;

import com.spring.boot.rest.example.model.Event;

/*
 * @author srinath medala
 */
public interface EventService {

    List<Event> findAll();

    List<Event> findAll(int pageNumber, int pageSize);

    Event findEventById(Long eventId);

    Event save(Event event);

    Event update(Event event);

    void delete(Long eventId);
}
