package Server.ServerController;

import com.google.gson.Gson;

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

    public ClientHandler(DataInputStream input,
                         DataOutputStream output,
//                         ObjectInputStream inputObject,
//                         ObjectOutputStream outputObject,
                         Socket socket,
                         int playerIndex) {
        this.input = input;
        this.output = output;
//        this.inputObject = inputObject;
//        this.outputObject = outputObject;
        this.socket = socket;
        this.playerIndex = playerIndex;
    }

    public void update() throws IOException {
        ServerReply serverReply = new ServerReply(playerIndex);
        Gson gson = new Gson();
        output.writeUTF(gson.toJson(serverReply));
    }

    public void openGamePage() throws IOException, InterruptedException {
        Thread.sleep(200);
        System.out.println("openGamePane in ClientHandler");
        output.writeInt(1);
    }

    @Override
    public void run() {
//        try {
//            ClientRequest request = (ClientRequest) inputObject.readObject();
//            int operation = request.getOperation();
//            switch (operation){
//                case 0:
//                    break;
//                case 1:
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    break;
//                default:
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
