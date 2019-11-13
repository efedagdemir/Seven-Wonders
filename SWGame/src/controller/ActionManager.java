package controller;

import model.*;

/* A singleton controller class which is responsible for the actions of the game */
class ActionManager {
    ActionManager actionManager;

    private ActionManager(){}

    ActionManager getInstance(){
        if(actionManager == null){
            actionManager = new ActionManager();
        }
        return actionManager;
    }

    void buyResource(Resource resource){

    }

    void removeFromRotatingCards(Card card){

    }

    void determineCardAction(Card card){

    }
}