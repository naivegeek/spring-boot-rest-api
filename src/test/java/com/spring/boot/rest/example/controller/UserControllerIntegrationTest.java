package com.spring.boot.rest.example.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.spring.boot.rest.example.DemoApplication;
import com.spring.boot.rest.example.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DemoApplication.class}) 
@WebIntegrationTest(randomPort = true)
public class UserControllerIntegrationTest {
    
    final String BASE_URL = "http://localhost:8080/api/users/";

    @Test
    @Ignore
    public void testNewUser() {
        
        User user = new User();
        user.setFirstName("firstname");
        user.setLastName("lastname");
        user.setUsername("allyn3874");
        user.setPassword("pass");

        RestTemplate rest = new TestRestTemplate();
        rest.put(BASE_URL, user);
        
    }
    
   
}
