package com.spring.boot.rest.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.boot.rest.example.model.Event;

/*
 * @author srinath medala
 */
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select e from Event e, EventUser u where e.id = u.eventId and u.userId = :userId ")
    List<Event> findByUserId(@Param("userId")Long userId);
}
