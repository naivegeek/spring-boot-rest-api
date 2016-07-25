package com.spring.boot.rest.example.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.boot.rest.example.DemoApplication;
import com.spring.boot.rest.example.model.EventUser;
import com.spring.boot.rest.example.repositories.EventUserRepository;

/*
 * @author srinath medala
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { DemoApplication.class })
public class EventUserRespositoryIntegrationTest {

    @Autowired
    private EventUserRepository eventUserRepository;

    @Test
    public void testSave() {

        EventUser eu = new EventUser();
        eu.setEventId(1L);
        eu.setUserId(100L);
        eu = eventUserRepository.save(eu);
        Assert.assertTrue(eu.getId() > 0);
    }

}
