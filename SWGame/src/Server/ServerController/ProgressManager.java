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
            int endAge = 0;
            for (ClientHandler c : clientHandlers) {
                if(ModelService.getInstance().getCardLength() > 6){
                    c.openGamePage();
                }

                else{
                    System.out.print("------For player " + c.playerIndex + ":" );
                    nextAge(c);
                    ModelService.getInstance().changeAge((ModelService.getInstance().getPlayerList().get(c.playerIndex)), (ModelService.getInstance().getPlayerList().get(c.playerIndex)).currentAge);
                    System.out.println((ModelService.getInstance().getPlayerList().get(c.playerIndex)).currentAge.name);
                    endAge++;
                }

            }
            if (endAge == 1){
                System.out.println("endage==3'e geldi mi");
                ModelService.getInstance().createRotatingCardList();
                if (ModelService.getInstance().getRotatingCardList() == null)
                    System.out.println("Prograss Ma --- endAge==3--- null geldi");
            }



    }

    void nextAge(ClientHandler client) throws IOException, InterruptedException {
        ModelService.getInstance().updateCurrentAge((ModelService.getInstance().getPlayerList().get(client.playerIndex)), (ModelService.getInstance().getPlayerList().get(client.playerIndex)).currentAge);
        System.out.println((ModelService.getInstance().getPlayerList().get(client.playerIndex)).getConflictPoints().getNoOfItems());
        client.openConflictPage();
    }
}