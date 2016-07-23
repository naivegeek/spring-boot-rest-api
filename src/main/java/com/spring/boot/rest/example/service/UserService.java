package com.spring.boot.rest.example.service;

import com.spring.boot.rest.example.model.User;

public interface UserService {

    User save (User user);
    
    User findByUsernameAndPassword(String username, String password);

}
