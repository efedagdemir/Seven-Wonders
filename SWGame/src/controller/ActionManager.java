package controller;

import model.Card;
import model.Resource;

/* A singleton controller class which is responsible for the actions of the game */
class ActionManager {
    private static ActionManager actionManager;

    private ActionManager(){}

    static ActionManager getInstance() {
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