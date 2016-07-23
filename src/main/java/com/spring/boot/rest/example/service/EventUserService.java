package com.spring.boot.rest.example.service;

import java.util.List;

import com.spring.boot.rest.example.model.Event;
import com.spring.boot.rest.example.model.EventUser;
import com.spring.boot.rest.example.model.User;

/*
 * @author srinath medala
 */
public interface EventUserService {

    List<Event> findAllEventsRegisteredForUser(Long usernum);

    List<User> findAllUsersRegisteredInEvent(Long eventId);

    EventUser save(EventUser eventUser);
}
