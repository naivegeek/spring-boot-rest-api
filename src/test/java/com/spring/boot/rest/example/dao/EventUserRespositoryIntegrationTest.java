package com.spring.boot.rest.example.dao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.boot.rest.example.DemoApplication;
import com.spring.boot.rest.example.repositories.EventUserRepository;

/*
 * @author srinath medala
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { DemoApplication.class })
public class EventUserRespositoryIntegrationTest {

    @Autowired
    private EventUserRepository eventUserRepository;

}
