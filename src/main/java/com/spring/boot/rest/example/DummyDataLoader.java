package com.spring.boot.rest.example;

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
      //loadEvents();
      //loadUsers();
    }

    private void loadEvents(){
        int i=1;
        while(i<10){
            Event e = new Event();
            
        }
    }
    
    private void loadUsers(){
        
    }
}
