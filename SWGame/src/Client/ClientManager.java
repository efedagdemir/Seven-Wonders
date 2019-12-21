package Client;

import Client.ClientController.ClientRequest;
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
    private List<String> messages;


    public ClientManager(String key) throws IOException {
        KEY = decryptKey(key);
        System.out.println(KEY);
        socket = new Socket(KEY, PORT);
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
        System.out.println("Bu sout client managerda");

    }

    public void communicateServer() {
        try {
            int tosend;
            while (true) {
                tosend = input.readInt();
                System.out.println("in communicateServer before loop");
                // If client sends exit,close this connection
                // and then break from the while loop
                if (tosend == 1) {
                    System.out.println("communicateServer in ClientManager");
                    Thread.sleep(100);
//                    System.out.println("ClientThread");
                    ServerReply s = getReply();
                    if( player == null)
                        this.player = s.getPlayer();
                    Player player = s.getPlayer();
                    Player leftNeighbor = s.getLeftNeighbor();
                    Player rightNeighbor = s.getRightNeighbor();
                    cards = s.getRotatingCardList();
                    updateInfoPane(player, cards, leftNeighbor, rightNeighbor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception in communicateServer in ClientManager");
        }
    }

    public String decryptKey(String encryptedKey) {
        /*TODO() change*/
        return encryptedKey;
    }

    private void updateInfoPane(Player player, Card[] cards, Player left, Player right) {
        System.out.println("updateInfoPane in ClientManager");
        GameView.getInstance().showGamePane(player, cards, left, right);
    }

    public void setPlayer() throws IOException, ClassNotFoundException {
        player = getReply().getPlayer();
        //updateInfoPane(player,);
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
                .registerSubtype(ScientificStructure.class, "ScientificStructure");

        return new GsonBuilder().registerTypeAdapterFactory(itemAdapterFactory)
                .registerTypeAdapterFactory(cardAdapterFactory)
                .create();
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

}


