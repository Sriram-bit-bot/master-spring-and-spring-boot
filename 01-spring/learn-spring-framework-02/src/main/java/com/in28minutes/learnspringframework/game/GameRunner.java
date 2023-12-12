package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private GamingConsole game;
//    SuperContraGame game;
//    public GameRunner(MarioGame game){
//        this.game =game;
//    }
    public GameRunner(@Qualifier("superContra") GamingConsole game){
        this.game =game;
    }
    public void run(){
        System.out.println("Running Game: "+ this.game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}

