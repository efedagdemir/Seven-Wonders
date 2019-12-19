package Client;

import Client.ClientController.ClientRequest;
import Client.view.GameView;
import Server.ServerController.ServerReply;
import Server.model.Card;
import Server.model.Player;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientManager {
    private final String KEY;
    private final int PORT = 5346;
    private Player player;
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

        /*TODO() make it logical, it is just temporary*/
//        inputObject = new ObjectInputStream(socket.getInputStream());
//        outputObject = new ObjectOutputStream(socket.getOutputStream());

        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
//        setPlayer();
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
                    Player player = s.getPlayer();
                    Player leftNeighbor = s.getLeftNeighbor();
                    Player rightNeighbor = s.getRightNeighbor();
                    Card[] cards = s.getRotatingCardList();
                    updateInfoPane(player, cards, leftNeighbor, rightNeighbor);
                    tosend = -1;
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

    public ServerReply getReply() throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(input.readUTF(), ServerReply.class);
    }

    public void sendRequest(ClientRequest request) throws IOException {
        Gson gson = new Gson();
        output.writeUTF(gson.toJson(request));

    }

}
