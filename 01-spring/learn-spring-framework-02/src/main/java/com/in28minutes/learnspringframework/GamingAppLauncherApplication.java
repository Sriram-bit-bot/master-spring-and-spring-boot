    package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

    @Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {
//    @Bean // Spring will create the beans for us
//    public GamingConsole game(){
//        var game = new PacManGame();
//        return game;
//    }

//    @Bean
//    public GameRunner gameRunner(GamingConsole game){
//        var gameRunner =new GameRunner(game);
//        return gameRunner;
//    }
    public static void main(String[] args){

        // Steps:
        // 1) Launch the spring context
        try(var context =new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)){
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        };


    }
}
