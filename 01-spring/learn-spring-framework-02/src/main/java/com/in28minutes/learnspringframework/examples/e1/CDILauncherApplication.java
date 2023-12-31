package com.in28minutes.learnspringframework.examples.e1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
@Named // Named is the counterpart in CDI
class BusinessService{
    DataService dataService;
    public DataService getDataService() {
        return dataService;
    }

//    @Autowired
    @Inject // Inject is the counterpart for Autowired
    public void setDataService(DataService dataService) {
        System.out.println("Setter injection");
        this.dataService = dataService;
    }
}

//@Component
@Named
class DataService{

}
@Configuration
@ComponentScan
public class CDILauncherApplication {
    public static void main(String[] args){
        try(var context =new AnnotationConfigApplicationContext(CDILauncherApplication.class)){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessService.class).getDataService());
        };


    }
}
