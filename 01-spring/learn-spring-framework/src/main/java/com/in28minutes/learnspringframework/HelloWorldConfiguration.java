package com.in28minutes.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    @Bean
    public Person person2(){
        var person = new Person("Praksha",23, new Address("Mahamaham Tank","Kum"));
        return person;
    }

    @Bean(name ="address2") // Configure a custom bean name
    @Primary
    public Address address(){
        return new Address("2/91 Kaman Kovil Street", "Thanjavur");
    }

    @Bean
    @Qualifier("address3Qualifier")
    public Address address3(){
        return new Address("Hi","Bye");
    }

    // Create a bean that has a relationship to some other bean, use existing beans(managed by spring) to create new
    // beans
    // Two ways
    // 1) Method call
    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address()); //name, age
    }
    // 2) Parameters
    @Bean
    public Person person3Parameters(String name, int age, Address address2){ // Beans are injected
        return new Person(name, age, address2); // Use the bean name instead of the function call
    }
    @Bean
    public Person person4Parameters(String name, int age, Address address){ // There is no bean with name address, so it gets confused and throws exception
        return new Person(name, age, address); // If you don't declare one of the addresses as primary, this exception will not go
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3Qualifier") Address address){ // Autowire with the Qualifier
        return new Person(name, age, address);
    }



}
