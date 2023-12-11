package com.in28minutes.learnspringframework;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

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
        System.out.println(context.getBean("address2"));
        System.out.println(context.getBean(Address.class)); // Use the type of bean to retrieve the bean
        // If there are multiple beans with the same type, then an excpetion is thrown

        System.out.println(context.getBean("person2MethodCall"));
        System.out.println(context.getBean("person3Parameters"));

        // Get all Spring bean names
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        // Even the configuration is referred as a bean

         // If there are multiple matching candidates -> make one of the candidates primary -> @Primary
        System.out.println(context.getBean(Address.class));

        // Or @Qualifier("address3Qualifier ")
        System.out.println(context.getBean("person5Qualifier"));
    }
}
