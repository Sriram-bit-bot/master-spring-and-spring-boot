package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorld {
    public static void main(String[] args){

        // Steps:
        // 1) Launch the spring context
        var context =new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        // 2) Configure the things we want Spring to manage - @Configuration - HelloWorldConfiguration.java
        // @Bean -> name

        // 3) Retrieve the beans managed by spring
        System.out.println(context.getBean("name")); //Pass the name of the bean
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));

    }
}
