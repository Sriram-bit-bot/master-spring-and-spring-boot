package com.in28minutes.learnspringframework.game;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole{
    public void up(){
        System.out.println("Go up");
    }
    public void down(){
        System.out.println("Go down");
    }
    public void left(){
        System.out.println("Go back");
    }
    public void right(){
        System.out.println("Accelerate");
    }
}
