package com.spring.boot.rest.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.rest.example.model.Event;
import com.spring.boot.rest.example.model.EventUser;
import com.spring.boot.rest.example.model.User;
import com.spring.boot.rest.example.repositories.EventRepository;
import com.spring.boot.rest.example.repositories.EventUserRepository;
import com.spring.boot.rest.example.repositories.UserRespository;
import com.spring.boot.rest.example.service.EventUserService;

/*
 * @author srinathm
 */
@Service("eventUserService")
public class EventUserServiceImpl implements EventUserService {

    @Autowired
    private EventUserRepository eventUserRepository;
    
    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private UserRespository userRespository;

    @Override
    public List<Event> findAllEventsRegisteredForUser(Long usernum) {
        return eventRepository.findByUserId(usernum);
    }

    @Override
    public List<User> findAllUsersRegisteredInEvent(Long eventId) {
        return userRespository.findByEventId(eventId);
       
    }

    @Override
    public EventUser save(EventUser eventUser) {
        return eventUserRepository.save(eventUser);
    }
}
