package model;

import view.GameView;

import java.util.ArrayList;

public class ViewManipulator {
    private static ViewManipulator viewManipulator;
    GameView gameView = GameView.getInstance();
    private ViewManipulator(){}

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
        gameView.nextTurnScreenA(current);
    }

    void notifyConflictScreen( ArrayList<Player> playerList){
        gameView.showConflictScreen(playerList);
    }

    void notifyCredits(){
        gameView.showCredits();
    }

    void notifyHowToPlay(){
        gameView.showHowToPlay();
    }

    void updateInfoPane( ArrayList<Item> itemList){
        gameView.shopUpdatedInfoPane(itemList);
    }

    void notifyWonderPane( ArrayList<WonderBoard> wonders){
        gameView.showUpdatedWonderPane(wonders);
    }

    void notifyGameOverPane( ArrayList<Player> playerList){
        gameView.showGameOverPane(playerList);
    }

    void notifyGameBorderPane( ArrayList <Player> playerList, Card[][] cards){
        gameView.showGamePane(playerList, cards);
    }
}