package com.spring.boot.rest.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.boot.rest.example.model.User;

/*
 * @author srinath medala
 */
public interface UserRespository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
    
   @Query("select u from User u, EventUser eu where eu.userId = u.id and eu.eventId = :eventId")
   public  List<User> findByEventId(@Param("eventId") Long eventId);


}
