package Client;

import Client.ClientController.ClientRequest;
import Client.ClientController.ViewCommander;
import Client.view.GameView;
import Server.ServerController.ServerReply;
import Server.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientManager {
    private final String KEY;
    private final int PORT = 5346;

    private Player player;
    private Card[] cards;
    private ObjectInputStream inputObject;
    private ObjectOutputStream outputObject;
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private ClientRequest request;
    private List<String> messages; //  :(
    Player leftNeighbor;
    Player rightNeighbor;
    int spentToLeft;
    int spentToRight;

    //private Player leftNeighbor;
    //private Player rightNeighbor;


    public ClientManager(String key) throws IOException {
        KEY = decryptKey(key);
        socket = new Socket(KEY, PORT);
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());

    }

    public static Gson setGsonTypes() {
        RuntimeTypeAdapterFactory<Item> itemAdapterFactory = RuntimeTypeAdapterFactory.of(Item.class, "Item")
                .registerSubtype(Coin.class, "Coin")
                .registerSubtype(MilitaryPower.class, "MilitaryPower")
                .registerSubtype(Resource.class, "Resource")
                .registerSubtype(ConflictPoint.class, "ConflictPoint")
                .registerSubtype(ScientificType.class, "ScientificType")
                .registerSubtype(Structure.class, "Structure")
                .registerSubtype(VictoryPoint.class, "VictoryPoint");

        RuntimeTypeAdapterFactory<Card> cardAdapterFactory = RuntimeTypeAdapterFactory.of(Card.class, "Card")
                .registerSubtype(ManufacturedGood.class, "ManufacturedGood")
                .registerSubtype(RawMaterial.class, "RawMaterial")
                .registerSubtype(CommercialStructure.class, "CommercialStructure")
                .registerSubtype(CivilianStructure.class, "CivilianStructure")
                .registerSubtype(MilitaryStructure.class, "MilitaryStructure")
                .registerSubtype(Guild.class, "Guild")
                .registerSubtype(ScientificStructure.class, "ScientificStructure")
                .registerSubtype(Risk.class, "Risk");

        RuntimeTypeAdapterFactory<Age> ageAdapterFactory = RuntimeTypeAdapterFactory.of(Age.class, "Age")
                .registerSubtype(AgeI.class, "AgeI")
                .registerSubtype(AgeII.class, "AgeII")
                .registerSubtype(AgeIII.class, "AgeIII");


        return new GsonBuilder().registerTypeAdapterFactory(itemAdapterFactory)
                .registerTypeAdapterFactory(cardAdapterFactory)
                .registerTypeAdapterFactory(ageAdapterFactory)
                .create();
    }

    public String decryptKey(String encryptedKey) {
        /*TODO() change*/
        return encryptedKey;
    }


    private void updateInfoPane(Player player, Card[] cards, Player left, Player right) {
        GameView.getInstance().showGamePane(player, cards, left, right);
    }

    public void setPlayer() throws IOException, ClassNotFoundException {
        player = getReply().getPlayer();
        //updateInfoPane(player,);
    }

    public void communicateServer() {
        try {
            int tosend;
            while (true) {
                tosend = input.readInt();
                // If client sends exit,close this connection
                // and then break from the while loop
                if (tosend == 1) {
                    Thread.sleep(100);
//                    System.out.println("ClientThread");
                    ServerReply s = getReply();
                    player = s.getPlayer();
                    leftNeighbor = s.getLeftNeighbor();
                    rightNeighbor = s.getRightNeighbor();
                    // System.out.println("CARDSIN LENGHTI BEFORE     " + cards.length);
                    cards = s.getRotatingCardList();
                    updateInfoPane(player, cards, leftNeighbor, rightNeighbor);
                }
                if (tosend == 2) {
                    Thread.sleep(100);
//                    System.out.println("ClientThread");
                    ServerReply s = getReply();
                    player = s.getPlayer();
                    leftNeighbor = s.getLeftNeighbor();
                    rightNeighbor = s.getRightNeighbor();
                    ViewCommander.getInstance().showConflictScreen(player, leftNeighbor, rightNeighbor);
                }
                if (tosend == 3){
                    Thread.sleep(100);
                    //ServerReply s = getReply();
                    //player = s.getPlayer();
                    //leftNeighbor = s.getLeftNeighbor();
                    //rightNeighbor = s.getRightNeighbor();
                    ViewCommander.getInstance().showGameOverPane(player, leftNeighbor, rightNeighbor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ServerReply getReply() throws IOException {
        Gson gson = setGsonTypes();
        return gson.fromJson(input.readUTF(), ServerReply.class);
    }

    public void sendRequest(ClientRequest request) throws IOException {
        Gson gson = setGsonTypes();
        output.writeUTF(gson.toJson(request));

    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards() {
        return cards;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getRightNeighbor() { return rightNeighbor; }
    public Player getLeftNeighbor() { return leftNeighbor; }

    public int getSpentToLeft() { return spentToLeft; }

    public void setSpentToLeft(int spentToLeft) { this.spentToLeft = spentToLeft; }

    public int getSpentToRight() { return spentToRight; }

    public void setSpentToRight(int spentToRight) { this.spentToRight = spentToRight; }


}



