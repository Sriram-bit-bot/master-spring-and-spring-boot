package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age, Address address){}
record Address (String firstLine, String city){}
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
        var person = new Person("Radhika",23, new Address("Agraharam","Kum"));
        return person;
    }

    @Bean(name ="address2") // Configure a custom bean name
    public Address address(){
        return new Address("2/91 Kaman Kovil Street", "Thanjavur");
    }

//    @Bean
//    public Address address3(){
//        return new Address("Hi","Bye");
//    }

    // Create a bean that has a relationship to some other bean
    // Two ways
    // 1) Method call
    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address()); //name, age
    }
}
