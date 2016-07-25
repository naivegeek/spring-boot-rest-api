package com.spring.boot.rest.example.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.boot.rest.example.DemoApplication;
import com.spring.boot.rest.example.model.User;
import com.spring.boot.rest.example.repositories.UserRespository;


/*
 * @author srinath medala
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { DemoApplication.class })
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRespository userRespository;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setDateRegistered(new Date());
        user.setDateUpdated(new Date());
        user.setEmail("dummy1@email.com");  
        user.setLastName("Smith");
        user.setFirstName("Allyn");
        user.setPassword("password");
        user = userRespository.save(user);
        Assert.assertNotNull(user.getId());

    }
    
    @Test
    public void testUsernameAndPassword(){
        User user = new User();
        user.setDateRegistered(new Date());
        user.setDateUpdated(new Date());
        user.setEmail("dummy1@email.com");  
        user.setLastName("Smith");
        user.setFirstName("Allyn");
        user.setPassword("password");
        user.setUsername("allyn446");
        user = userRespository.save(user);
        
        User user2 = userRespository.findByUsernameAndPassword("allyn446", "password");
        Assert.assertNotNull(user2);
        
        Assert.assertEquals(user.getId(), user.getId());
    }
    
    
    
}
