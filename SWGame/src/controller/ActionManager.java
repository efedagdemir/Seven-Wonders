package controller;

import Client.view.DropBoard;
import Server.model.Resource;

/* A singleton controller class which is responsible for the actions of the game */
public class ActionManager {
    private static ActionManager actionManager;

    private ActionManager(){}

    public static ActionManager getInstance() {
        if(actionManager == null){
            actionManager = new ActionManager();
        }
        return actionManager;
    }

    void buyResource(Resource resource){
    }


    public void determineCardAction(DropBoard db) {

        db.takeCardAction();
    }
}