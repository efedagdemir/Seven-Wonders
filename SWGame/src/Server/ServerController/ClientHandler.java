package Server.ServerController;

import Client.ClientController.ClientRequest;
import Client.ClientManager;
import Client.view.BuildWonderDropBoard;
import Client.view.ConstructCardDropBoard;
import Client.view.DropBoard;
import Client.view.SellCardDropBoard;
import Server.model.Card;
import Server.model.ModelService;
import Server.model.Resource;
import com.google.gson.Gson;
import javafx.application.Platform;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread {
    Socket socket;
    public int playerIndex;
    private DataInputStream input;
    private DataOutputStream output;
    int numOfPlayers;
    public boolean nextAge = false;
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

    public void openConflictPage() throws IOException, InterruptedException {
        Thread.sleep(200);
        System.out.println("openGamePane in ClientHandler");
        output.writeInt(2);
        //update();
    }

    public void openGamePage() throws IOException, InterruptedException {
        Thread.sleep(200);
        System.out.println("openGamePane in ClientHandler");
        output.writeInt(1);
    }

    @Override
    public void run() {
        try {
            while (true) {
                ClientRequest request = getRequest();
                if (request != null) {
                    System.out.println("-------TAKEN CARD CLIENTHANDLER:  " + request.getCard().getName());

                    String boardClass = request.getOperation();
                    DropBoard board = null;
                    if (boardClass.equals("nextAge")){
                        setNextAge(true);
                        ready = false;
                        System.out.println("ClientHandlerdaki ilk if'e geldi mi??");
                    }
                    else{
                        setReady(true);
                        nextAge = false;
                    Card selectedCard = request.getCard();
                    ModelService.getInstance().setSelectedCard(selectedCard);
                    System.out.println(selectedCard.getName());

                    if (boardClass.equals("BuildWonderDropBoard")) {
                        board = new BuildWonderDropBoard();
                        DropBoard finalBoard = board;
                        Platform.runLater(() -> finalBoard.takeCardAction(ModelService.getInstance().getPlayerList().get(playerIndex)
                                , ModelService.getInstance().getRotatingCardList()[playerIndex], false, selectedCard,true));
                    }

                    else if (boardClass.equals("ConstructCardDropBoard")) {
                        board = new ConstructCardDropBoard();
                        DropBoard finalBoard1 = board;
                        Platform.runLater(() -> finalBoard1.takeCardAction(ModelService.getInstance().getPlayerList().get(playerIndex)
                                , ModelService.getInstance().getRotatingCardList()[playerIndex], false, selectedCard,true));
                    }

                    else if (boardClass.equals("SellCardDropBoard")) {
                        board = new SellCardDropBoard();
                        DropBoard finalBoard2 = board;
                        Platform.runLater(() -> finalBoard2.takeCardAction(ModelService.getInstance().getPlayerList().get(playerIndex)
                                , ModelService.getInstance().getRotatingCardList()[playerIndex], false, selectedCard, true));
                    }


                    System.out.println("***************** Item List **************************    " + playerIndex);
                    ModelService.getInstance().removeFromRotatingCardList(playerIndex, selectedCard);
                    System.out.println("!!!!!!For player" + playerIndex);
                    for (Card c :  ModelService.getInstance().getRotatingCardList()[playerIndex] )
                        System.out.println(c.getName());

                    ModelService.getInstance().getPlayerList().get(playerIndex).addCoin( -1 * (request.getSpentToLeft() + request.getSpentToRight()));
                    ModelService.getInstance().getPlayerList().get(playerIndex).getLeftNeighbor().addCoin( request.getSpentToLeft());
                    System.out.println( "---------------LEFT NEIGHBOR IS: " + ModelService.getInstance().getPlayerList().get(playerIndex).getLeftNeighbor().getName());
                    System.out.println("Spent to left: " + request.getSpentToLeft());
                    ModelService.getInstance().getPlayerList().get(playerIndex).getRightNeighbor().addCoin( request.getSpentToRight());
                    System.out.println( "---------------RIGHT NEIGHBOR IS: " + ModelService.getInstance().getPlayerList().get(playerIndex).getLeftNeighbor().getName());
                    System.out.println("Spent to right: " + request.getSpentToRight());
                    //request.getSpentToLeft()
                }
            }
        } }catch (IOException e) {

        }
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
    public void setNextAge(boolean nextAge) {
        this.nextAge = nextAge;
    }

}

