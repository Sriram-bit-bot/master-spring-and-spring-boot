package com.in28minutes.learnspringframework.game;

public class PacManGame implements GamingConsole {
    public void up(){
        System.out.println("Change direction to up");
    }
    public void down(){
        System.out.println("Change direction to down");
    }
    public void left(){
        System.out.println("Reverse/Move Slower");
    }
    public void right() {
        System.out.println("Move Faster");
    }
}
