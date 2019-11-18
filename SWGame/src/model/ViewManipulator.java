package model;

import view.GameView;

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

    }

    void notifyNameScreen(){

    }

    void notifyNextTurnScreen( Player current){

    }

    void notifyConflictScreen( Player [] playerList){

    }

    void notifyCredits(){

    }

    void notifyHowToPlay(){

    }

    void updateInfoPane( Item [] itemList){

    }

    void notifyWonderPane( WonderBoard [] wonders){

    }

    void notifyGameOverPane( Player [] playerList){

    }

    void notifyGameBorderPane( Player [] playerList, Card[][] cards){


    }
}