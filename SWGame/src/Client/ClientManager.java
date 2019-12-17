package Client;

import Client.ClientController.ClientRequest;
import Client.view.GameView;
import Server.model.Player;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientManager {
    private final String KEY;
    private final int PORT = 5553;
    private Player player;
    private ObjectInputStream inputObject;
    private ObjectOutputStream outputObject;
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;
    private ClientRequest request;
    private List<String> messages;


    public ClientManager(String key) throws IOException, ClassNotFoundException {
        KEY = decryptKey(key);
        System.out.println("hklhk");
        socket = new Socket(KEY, PORT);

        /*TODO() make it logical, it is just temporary*/
//        inputObject = new ObjectInputStream(socket.getInputStream());
//        outputObject = new ObjectOutputStream(socket.getOutputStream());

        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
//        setPlayer();
        System.out.println("Bu sout client managerda");
        Thread t = new Thread(new ClientThread());
        t.start();
    }

    public String decryptKey(String encryptedKey) {
        /*TODO() change*/
        return encryptedKey;
    }

    private void updateInfoPane(Player player) {
        GameView.getInstance().showGamePane(player);
    }

//    public void setPlayer() throws IOException, ClassNotFoundException {
//        player = getReply().getPlayer();
//        updateInfoPane(player);
//    }

//    public ServerReply getReply() throws ClassNotFoundException, IOException {
//        return (ServerReply)inputObject.readObject();
//    }

//    public void sendRequest(ClientRequest request) throws IOException {
//        outputObject.writeObject(request);
//    }

    class ClientThread extends Thread implements Runnable {
        public void run() {
            try {
                Scanner scn = new Scanner(System.in);
                while (true) {
                    int tosend = input.readInt();

                    // If client sends exit,close this connection
                    // and then break from the while loop
                    if (tosend == 1) {
                        System.out.println("ClientThread");
                        Player p = new Player();
                        GameView.getInstance().showGamePane(p);
                    }
                }
            } catch (Exception e) {

            }
        }
    }
}
