package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age){ }
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return "Sriram";
    }

    @Bean
    public int age(){
        return 22;
    }

    @Bean
    public Person person(){
        var person = new Person("Radhika",23);
        return person;
    }
}
