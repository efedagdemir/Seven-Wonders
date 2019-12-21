package Server.ServerController;

import Client.ClientController.ClientRequest;
import Client.ClientManager;
import Client.view.BuildWonderDropBoard;
import Client.view.ConstructCardDropBoard;
import Client.view.DropBoard;
import Client.view.SellCardDropBoard;
import Server.ServerManager;
import Server.model.Card;
import Server.model.ModelService;
import com.google.gson.Gson;
import javafx.application.Platform;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {
    //    private ObjectInputStream inputObject;
//    private ObjectOutputStream outputObject;
    Socket socket;
    int playerIndex;
    private DataInputStream input;
    private DataOutputStream output;
    int numOfPlayers;


    boolean ready = false;


    public ClientHandler(DataInputStream input,
                         DataOutputStream output,
//                         ObjectInputStream inputObject,
//                         ObjectOutputStream outputObject,
                         Socket socket,
                         int playerIndex, int numOfPlayers) {
        this.input = input;
        this.output = output;
//        this.inputObject = inputObject;
//        this.outputObject = outputObject;
        this.socket = socket;
        this.playerIndex = playerIndex;
        this.numOfPlayers = numOfPlayers;
    }

    public ClientRequest getRequest() throws IOException {
        Gson gson = ClientManager.setGsonTypes();
        String s;
        if ((s = input.readUTF()) != null) {
            return gson.fromJson(s, ClientRequest.class);
        }
        return null;
    }

    public void update() throws IOException {
        ServerReply serverReply = new ServerReply(playerIndex);
        output.writeUTF(ClientManager.setGsonTypes().toJson(serverReply));
    }

    public void openGamePage() throws IOException, InterruptedException {
        Thread.sleep(200);
        System.out.println("openGamePane in ClientHandler");
        output.writeInt(1);
    }

    @Override
    public void run() {
        int counter = 0;
        try {
            while (true) {
                ClientRequest request = getRequest();
                if (request != null) {
                    setReady(true);
                    String boardClass = request.getOperation();
                    DropBoard board = null;

                    if (boardClass.equals("BuildWonderDropBoard")) {
                        board = new BuildWonderDropBoard();
                    }

                    else if (boardClass.equals("ConstructCardDropBoard")) {
                        board = new ConstructCardDropBoard();
                    }

                    else if (boardClass.equals("SellCardDropBoard")) {
                        board = new SellCardDropBoard();
                    }
                    Card selectedCard = request.getCard();
                    ModelService.getInstance().setSelectedCard(selectedCard);
                    System.out.println(selectedCard.getName());
                    DropBoard finalBoard = board;
                    Platform.runLater(() -> finalBoard.takeCardAction(ModelService.getInstance().getPlayerList().get(playerIndex)
                    , ModelService.getInstance().getRotatingCardList()[playerIndex]));
                    ModelService.getInstance().removeFromRotatingCardList(playerIndex, selectedCard);
                }
            }
        } catch (IOException e) {

        }
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

}

