package Client.ClientController;

import Client.ClientManager;
import Client.view.DropBoard;
import Client.view.MainMenuPane;
import Client.view.PlayerInfoPane;
import Server.model.Card;
import Server.model.Player;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ClientControllerFacade {

    ClientManager clientManager;
    private Card selectedCard;
    private String dropBoard;
    /*TODO() include player as well*/
    private Player selectedPlayer;
    private static ClientControllerFacade facade = new ClientControllerFacade();

    public static ClientControllerFacade getInstance() {
        return facade;
    }

    public void commandView(ActionEvent event) throws IOException {
        if (event.getTarget() == MainMenuPane.creditsButton) {
            ViewCommander.getInstance().showCredits();
        }

        if (event.getTarget() == PlayerInfoPane.readyButton) {
            ViewCommander.getInstance().showWaitScreen();
            ClientRequest request = new ClientRequest(selectedCard, dropBoard);
            clientManager.sendRequest(request);

        }

        if (event.getTarget() == MainMenuPane.howToPlayButton) {
            ViewCommander.getInstance().showHowToPlay();

        }

        if (event.getTarget() == PlayerInfoPane.howToPlayButton) {
            ViewCommander.getInstance().showHowToPlay();
        }

    }

    public void initializeView(DropBoard dropBoard, String backgroundColor, String hoveredColor) {
        ViewInitializer.initializeDropListener(dropBoard, backgroundColor, hoveredColor);
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }


    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public void setDropBoard(String dropBoard) {
        this.dropBoard = dropBoard;
    }

}
