package Server.ServerController;

import Client.view.GamePane;
import Server.model.Card;
import Server.model.ModelService;
import Server.model.Player;

import java.io.IOException;
import java.util.List;

/* A singleton controller class which is responsible for the progression of the game */
public class ProgressManager {
    private static ProgressManager progressManager;

    private ProgressManager() {
    }

    public static ProgressManager getInstance() {
        if (progressManager == null) {
            progressManager = new ProgressManager();
        }
        return progressManager;
    }

    void nextTurn() {

    }

    public void nextCycle(List<ClientHandler> clientHandlers) throws IOException, InterruptedException {

            for (ClientHandler c : clientHandlers) {
                if(ModelService.getInstance().getCardLength() > 5){
                    c.openGamePage();
                }
                else{
                    nextAge(c);
                }
            }
    }

    void nextAge(ClientHandler client) throws IOException, InterruptedException {
        ModelService.getInstance().updateCurrentAge();
        client.openConflictPage();
    }
}