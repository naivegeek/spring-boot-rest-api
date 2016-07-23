package com.spring.boot.rest.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.rest.example.model.User;

/*
 * @author srinath medala
 */
public interface UserRespository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

}
