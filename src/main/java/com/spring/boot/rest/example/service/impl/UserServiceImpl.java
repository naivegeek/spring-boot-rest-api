package com.spring.boot.rest.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.boot.rest.example.model.User;
import com.spring.boot.rest.example.repositories.UserRespository;
import com.spring.boot.rest.example.service.UserService;

/*
 * author srinath medala
 */
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRespository userRespository;
    
    @Override
    public User save(User user) {
        return userRespository.save(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRespository.findByUsernameAndPassword(username, password);
    }

}
