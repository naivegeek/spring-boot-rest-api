package com.spring.boot.rest.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.rest.example.model.Event;

/*
 * @author srinath medala
 */
public interface EventRepository extends JpaRepository<Event, Long> {

    
}
