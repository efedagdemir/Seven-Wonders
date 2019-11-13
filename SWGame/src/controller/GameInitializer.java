package controller;

import java.util.List;

/* A singleton controller class which is responsible for the initialization of the game */
class GameInitializer {
    GameInitializer gameInitializer;

    private GameInitializer(){}

    GameInitializer getInstance(){
        if(gameInitializer == null){
            gameInitializer = new GameInitializer();
        }
        return gameInitializer;
    }

    void arrangeGame(List<String> names){

    }

    void initializeGame(){

    }
}