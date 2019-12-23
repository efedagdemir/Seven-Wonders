package Server.ServerController;

import Client.ClientController.ClientRequest;
import Client.ClientManager;
import Client.view.BuildWonderDropBoard;
import Client.view.ConstructCardDropBoard;
import Client.view.DropBoard;
import Client.view.SellCardDropBoard;
import Server.model.Card;
import Server.model.ModelService;
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
    public boolean endPane = false;


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
        if (ModelService.getInstance().getPlayerList().get(playerIndex) == null) System.out.println("................UPDATTE NULL");
        ServerReply serverReply = new ServerReply(playerIndex);
        output.writeUTF(ClientManager.setGsonTypes().toJson(serverReply));
    }

    public void openConflictPage() throws IOException, InterruptedException {
        Thread.sleep(200);
        output.writeInt(2);
        //update();
    }

    public void openGamePage() throws IOException, InterruptedException {
        Thread.sleep(200);
        output.writeInt(1);
    }

    public void openEndPane() throws InterruptedException, IOException {
        Thread.sleep(200);
        output.writeInt(3);
    }

    @Override
    public void run() {
        try {
            while (true) {
                ClientRequest request = getRequest();
                if (request != null) {
                    String boardClass = request.getOperation();
                    DropBoard board = null;
                    if (boardClass.equals("nextAge")){
                        setNextAge(true);
                        ready = false;
                        endPane = false;
                    }
                    else if(ModelService.getInstance().endGame){
                        setEnd(true);
                        setNextAge(false);
                        setReady(false);
                    }
                    else{
                        setNextAge(false);
                        setEnd(false);
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


                    ModelService.getInstance().removeFromRotatingCardList(playerIndex, selectedCard);

                    ModelService.getInstance().getPlayerList().get(playerIndex).addCoin( -1 * (request.getSpentToLeft() + request.getSpentToRight()));
                    ModelService.getInstance().getPlayerList().get(playerIndex).getLeftNeighbor().addCoin( request.getSpentToLeft());
                    ModelService.getInstance().getPlayerList().get(playerIndex).getRightNeighbor().addCoin( request.getSpentToRight());
                    //request.getSpentToLeft()
                }
            }
        } }catch (IOException | InterruptedException e) {

        }
    }

    public void setEnd(boolean b) throws IOException, InterruptedException {
        if(b){openEndPane();}
        this.endPane = b;
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

