package com.spring.boot.rest.example.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.spring.boot.rest.example.model.Event;

/*
 * @author srinath medala
 */
public interface EventService {

    List<Event> findAll();
    
    List<Event> findAll(Pageable page);
    
    List<Event> findAll(Sort sort);

    Event findEventById(Long eventId);

    Event save(Event event);

    Event update(Event event);

    void delete(Long eventId);
}
