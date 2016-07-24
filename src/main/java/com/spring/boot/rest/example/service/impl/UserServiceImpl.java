package com.spring.boot.rest.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.spring.boot.rest.example.model.User;
import com.spring.boot.rest.example.repositories.UserRespository;
import com.spring.boot.rest.example.service.UserService;

/*
 * author srinath medala
 */
@Service("userService")
public class UserServiceImpl implements UserService {

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

    @Override
    public List<User> findAll() {

        return userRespository.findAll();
    }

    @Override
    public List<User> findAll(int pageSize, int pageNumber) {
        PageRequest page = new PageRequest(pageNumber - 1, pageSize);
        Page<User> results = userRespository.findAll(page);
        if (results != null && !CollectionUtils.isEmpty(results.getContent())) {
            return results.getContent();
        }
        return null;
    }

    @Override
    public User findUserById(Long userId) {
        return userRespository.findOne(userId);
    }

    @Override
    public User update(User user) {
        return userRespository.save(user);
    }

    @Override
    public void delete(Long userId) {
        userRespository.delete(userId);
    }

}
