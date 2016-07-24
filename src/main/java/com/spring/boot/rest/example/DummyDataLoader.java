package com.spring.boot.rest.example;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.rest.example.model.Event;
import com.spring.boot.rest.example.repositories.EventRepository;
import com.spring.boot.rest.example.repositories.UserRespository;

/*
 * @author srinathm medala
 */
@Component("dummyDataLoader")
public class DummyDataLoader implements InitializingBean {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRespository userRespository;

    @Override
    public void afterPropertiesSet() throws Exception {
        loadEvents();
        // loadUsers();
    }

    private void loadEvents() {
        for (int i = 1; i <= 20; i++) {
            Event event = new Event();
            event.setDateCreated(new Date());
            event.setDateUpdated(new Date());
            event.setEventDetails("Test Event" + UUID.randomUUID().toString());
            event.setEndDate(new Date());
            event.setStartDate(new Date());
            event.setEventType("Private" + i);
            event.setEventLocation("144 East Stree, CulverCity, CA, 90230");
            eventRepository.save(event);
        }
    }

    private void loadUsers() {

    }
}
