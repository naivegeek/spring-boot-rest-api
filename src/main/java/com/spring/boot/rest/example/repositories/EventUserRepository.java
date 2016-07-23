package com.spring.boot.rest.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.rest.example.model.EventUser;

/*
 * @author srinathm
 */
public interface EventUserRepository extends JpaRepository<EventUser, Long>, EventUserRespositoryCustom {

}
