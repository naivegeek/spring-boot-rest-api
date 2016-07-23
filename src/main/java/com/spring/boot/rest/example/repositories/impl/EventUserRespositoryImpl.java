package com.spring.boot.rest.example.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.boot.rest.example.model.Event;
import com.spring.boot.rest.example.model.User;
import com.spring.boot.rest.example.repositories.EventUserRespositoryCustom;

/*
 * @author srinath medala
 */
public class EventUserRespositoryImpl implements EventUserRespositoryCustom {

    private final String FIND_BY_EVENTID = " select e from Event e, EventUser u where e.eventId = u.eventId and e.eventId = :eventId";
    private final String FIND_BY_USERID = " select u from User u, EventUser eu where eu.userId = u.userId and eu.userId = :userId";
    
    @Autowired
    private EntityManager entity;
    
    @Override
    public List<User> findByEventId(Long eventId) {
      Query query = entity.createNamedQuery(FIND_BY_EVENTID).setParameter("eventId", eventId);
      List<User> users =query.getResultList();
      return users;
    }

    @Override
    public List<Event> findByUserId(Long userId) {
        Query query = entity.createNamedQuery(FIND_BY_USERID).setParameter("userId", userId);
        List<Event> events =query.getResultList();
        return events   ;
    }

}
