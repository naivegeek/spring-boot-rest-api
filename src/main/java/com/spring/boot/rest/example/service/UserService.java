package com.spring.boot.rest.example.service;

import java.util.List;

import com.spring.boot.rest.example.model.User;

public interface UserService {

    User save(User user);

    User findByUsernameAndPassword(String username, String password);

    List<User> findAll();

    List<User> findAll(int pageSize, int pageNumber);

    User findUserById(Long userId);

    User update(User user);

    void delete(Long userId);
}
