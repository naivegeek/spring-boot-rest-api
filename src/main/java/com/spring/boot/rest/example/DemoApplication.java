package com.spring.boot.rest.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 * @author srinath medala
 */
@SpringBootApplication
@EnableJpaRepositories("com.spring.boot.rest.example.repositories")
@EnableTransactionManagement
@EnableAutoConfiguration
@EntityScan("com.spring.boot.rest.example..model")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
