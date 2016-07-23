package com.spring.boot.rest.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return eventRepository.findAll();
    }

    @Override
    public Event findEventById(Long eventId) {
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
    public void delete(Long eventId) {
        eventRepository.delete(eventId);
    }

    @Override
    public List<Event> findAll(Pageable pageable) {
        Page<Event> pages = eventRepository.findAll(pageable);
        return pages.getContent();
    }

    @Override
    public List<Event> findAll(Sort sort) {
        return eventRepository.findAll(sort);
        
    }

}
