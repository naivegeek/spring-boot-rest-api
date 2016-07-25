package com.spring.boot.rest.example.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.boot.rest.example.DemoApplication;
import com.spring.boot.rest.example.model.Event;
import com.spring.boot.rest.example.model.EventUser;
import com.spring.boot.rest.example.model.User;

/*
 * @author srinath medala
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DemoApplication.class})  
public class EventUserServiceIntegrationTest {
  
    @Autowired
    private EventUserService eventUserService;
    
    @Test
    public void testSave(){
        
        EventUser eu= new EventUser();
        eu.setEventId(1L);
        eu.setUserId(100L);
        eu = eventUserService.save(eu);
        Assert.assertTrue(eu.getId()>0);
    }
    
    @Test
    public void testRegisteredEventsForUser(){
        List<User> users = eventUserService.findAllUsersRegisteredInEvent(1L); 
        Assert.assertTrue(users!=null);
        
    }
    
    @Test
    public void testRegisteredUsersForEvent(){
        List<Event> events = eventUserService.findAllEventsRegisteredForUser(2L);
        Assert.assertTrue(events!=null);
    }
    
    
}
