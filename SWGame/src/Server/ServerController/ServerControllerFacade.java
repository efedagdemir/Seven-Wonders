package Server.ServerController;

import Client.ClientController.ClientControllerFacade;
import Client.ClientManager;
import Client.view.DropBoard;
import Server.ServerManager;
import Server.model.ModelService;
import Server.model.Player;
import javafx.application.Platform;
import javafx.scene.Node;

public class ServerControllerFacade {
    private static ServerControllerFacade serverControllerFacade = new ServerControllerFacade();

    private ServerManager serverManager;

    public static ServerControllerFacade getInstance(){
        return serverControllerFacade;
    }

    public ServerManager getServerManager() {
        return serverManager;
    }

    public void setServerManager(ServerManager serverManager) {
        this.serverManager = serverManager;
    }

    public void startGame(){
        GameInitializer.getInstance().initializeGame();
        GameInitializer.getInstance().arrangeGame();
        ModelService.getInstance().showGameScreen();
    }
    public void initializeDADListeners(Node node, String backgroundColor, String hoveredColor){
        GameInitializer.getInstance().initializeDADListeners(node, backgroundColor, hoveredColor);
    }

    public void initializeDADListeners(Node node, String backgroundColor, String hoveredColor, Player chosenP, Player currentP) {
        GameInitializer.getInstance().initializeDADListeners(node, backgroundColor, hoveredColor, chosenP, currentP);
    }

    public void determineCardAction(DropBoard db) {
        ClientManager client = ClientControllerFacade.getInstance().getClientManager();
        Platform.runLater(() -> db.takeCardAction(client.getPlayer(), client.getCards()));
    }


}
