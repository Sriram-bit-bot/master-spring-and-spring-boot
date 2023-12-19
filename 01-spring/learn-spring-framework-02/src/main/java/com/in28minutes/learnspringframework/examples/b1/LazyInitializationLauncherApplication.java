package com.in28minutes.learnspringframework.examples.b1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    @Component
    class ClassA{

    }
    @Component
    @Lazy // Remove this annotation
    class ClassB{
        private ClassA classA;
        public ClassB(ClassA classA){
            // Logic
            System.out.println("Some Initialization logic");
            this.classA =classA;
        }
        public void doSomething(){
            System.out.println("Doing Something");
        }
    }
    public static void main(String[] args){

        // Steps:
        // 1) Launch the spring context
        try(var context =new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)){
            System.out.println("Initialization of context is completed");
            context.getBean(ClassB.class).doSomething();
        };


    }
}
