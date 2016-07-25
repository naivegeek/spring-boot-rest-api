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
    /*
     * Not able to start the embedded tomcat server while running the test, therefore I had to run the 
     * server manually from outside. using
     * mvn spring-boot:run
     * 
     * And I tested the application with following CURL test URLS
     * 
     *  Creating a USER.
        curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/api/users/ -d '{"firstName":"Eric","lastName":"smith","username":"ericsmith","password":"password"}'
        
        Updating the USER.
        curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/api/users/ -d '{"id":"1","firstName":"John","lastName":"Boarding","username":"john446","password":"password"}'
        
        Delete a User.
        curl -i -X DELETE -H "Content-Type:application/json" http://localhost:8080/api/users/3/
      
        Get list of all Users
        curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/users/
        
        Get User with id=1
        curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/users/1/
        
        Get list of all Users with pagenation
        curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/users/1/10
        
        Get list of Users registered for the event with eventId=10
        curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/users/event/10
        
      */

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
