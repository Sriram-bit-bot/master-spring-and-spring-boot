package com.in28minutes.learnspringframework.game;

public class GameRunner {
    private GamingConsole game;
//    SuperContraGame game;
//    public GameRunner(MarioGame game){
//        this.game =game;
//    }
    public GameRunner(GamingConsole game){
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

