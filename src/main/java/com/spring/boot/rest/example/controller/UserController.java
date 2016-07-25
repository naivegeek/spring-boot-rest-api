package com.spring.boot.rest.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.rest.example.model.User;
import com.spring.boot.rest.example.service.EventUserService;
import com.spring.boot.rest.example.service.UserService;

/*
 * @author srinathm
 */
@RequestMapping("/api/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private EventUserService eventUserService;

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id) {
        log.info("Get User information by id: {}", id);
        User user = userService.findUserById(id);
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "ok";
    }
    
    @RequestMapping(value = "/event/{eventId}", method = RequestMethod.GET)
    public List<User> findAllUsersRegisteredForEvent(@PathVariable("eventId") Long eventId) {
        return eventUserService.findAllUsersRegisteredInEvent(eventId);
    }
}
