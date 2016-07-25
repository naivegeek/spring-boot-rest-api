package com.spring.boot.rest.example.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.boot.rest.example.DemoApplication;
import com.spring.boot.rest.example.model.User;

/*
 * @author srinath medala
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { DemoApplication.class })
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setDateRegistered(new Date());
        user.setDateUpdated(new Date());
        user.setEmail("dummy1@email.com");
        user.setLastName("Smith");
        user.setFirstName("Allyn");
        user.setPassword("password");
        user = userService.save(user);
        Assert.assertNotNull(user.getId());

    }

    @Test
    public void testUsernameAndPassword() {
        User user = new User();
        user.setDateRegistered(new Date());
        user.setDateUpdated(new Date());
        user.setEmail("dummy1@email.com");
        user.setLastName("Smith");
        user.setFirstName("Allyn");
        user.setPassword("password");
        user.setUsername("allyn446");
        user = userService.save(user);

        User user2 = userService.findByUsernameAndPassword("allyn446", "password");
        Assert.assertNotNull(user2);

        Assert.assertEquals(user.getId(), user.getId());
    }

}
