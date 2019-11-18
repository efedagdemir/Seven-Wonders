package model;

import view.GameView;

import java.util.ArrayList;

public class ViewManipulator {
    private static ViewManipulator viewManipulator;
    GameView gameView;
    private ViewManipulator(){}

    public  static ViewManipulator getInstance() {
        if(viewManipulator == null){
            viewManipulator = new ViewManipulator();
        }
        return viewManipulator;
    }

    void notifyMainMenu(){

    }

    void notifyNameScreen(){

    }

    void notifyNextTurnScreen( Player current){

    }

    void notifyConflictScreen( ArrayList<Player> playerList){

    }

    void notifyCredits(){
        gameView.showCredits();
    }

    void notifyHowToPlay(){
        gameView.showHowToPlaye();
    }

    void updateInfoPane( ArrayList<Item> itemList){
        gameView.shopUpdatedInfoPane(itemList);
    }

    void notifyWonderPane( ArrayList<WonderBoard> wonders){
        gameView.showUpdatedWonderPane(wonders);
    }

    void notifyGameOverPane( ArrayList<Player> playerList){

    }

    void notifyGameBorderPane( ArrayList <Player> playerList, Card[][] cards){
        gameView.showGamePnae(playerList, cards);

    }
}