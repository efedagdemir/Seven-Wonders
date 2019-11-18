package model;

import view.GameView;

import java.util.ArrayList;

public class ViewManipulator {
    private static ViewManipulator viewManipulator;
    GameView gameView;
    private ViewManipulator(){};
    public  static ViewManipulator getInstance() {
        if(viewManipulator == null){
            viewManipulator = new ViewManipulator();
        }
        return viewManipulator;
    }

    void notifyMainMenu(){
        gameView.showMainMenu();
    }

    void notifyNameScreen(){
        gameView.showNameScreen();
    }

    void notifyNextTurnScreen( Player current){
        gameView.nextTurnScreen(current);
    }

    void notifyConflictScreen( ArrayList<Player> playerList){
        gameView.showConflictScreen(playerList);
    }

    void notifyCredits(){

    }

    void notifyHowToPlay(){

    }

    void updateInfoPane( ArrayList<Item> itemList){

    }

    void notifyWonderPane( ArrayList<WonderBoard> wonders){

    }

    void notifyGameOverPane( ArrayList<Player> playerList){
        gameView.showGameOverPane(playerList);
    }

    void notifyGameBorderPane( ArrayList <Player> playerList, Card[][] cards){
        gameView.showGamePane(playerList, cards);
    }
}