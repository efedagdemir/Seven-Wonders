package controller;

import Client.ClientController.ClientControllerFacade;
import Client.ClientManager;
import Client.view.DropBoard;
import Server.model.Resource;
import javafx.application.Platform;

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
        ClientManager client = ClientControllerFacade.getInstance().getClientManager();
        Platform.runLater(() -> db.takeCardAction(client.getPlayer(), client.getCards()));

    }
}