package com.in28minutes.learnspringframework.examples.a1;


// Field Annotation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// Business Class
// Dependency 1
// Dependency 2

@Component
class YourBusinessClass{
    @Autowired // Using Autowired annotation to autowire, remove this and you will print null
    Dependency1 dependency1; // Injecting these fields
    @Autowired
    Dependency2 dependency2;

    public String toString(){
        return "Using " + dependency1 +" and "+dependency2;
    }
}
@Component
class Dependency1{

}
@Component
class Dependency2{

}
@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {
    public static void main(String[] args){

        // Steps:
        // 1) Launch the spring context
        try(var context =new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(YourBusinessClass.class));
        };


    }
}
