package com.spring.boot.rest.example.repositories;

import java.util.List;

import com.spring.boot.rest.example.model.Event;
import com.spring.boot.rest.example.model.User;

/*
 * @author srinath medala
 */
public interface EventUserRespositoryCustom {

    List<User> findByEventId(Long eventId);

    List<Event> findByUserId(Long userId);
}
