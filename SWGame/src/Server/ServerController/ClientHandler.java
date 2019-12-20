package Server.ServerController;

import Server.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

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
        RuntimeTypeAdapterFactory<Item> itemAdapterFactory = RuntimeTypeAdapterFactory.of(Item.class, "type1")
                .registerSubtype(Coin.class, "Coin")
                .registerSubtype(MilitaryPower.class, "MilitaryPower")
                .registerSubtype(Resource.class, "Resource")
                .registerSubtype(ConflictPoint.class, "ConflictPoint")
                .registerSubtype(ScientificType.class, "ScientificType")
                .registerSubtype(Structure.class, "Structure")
                .registerSubtype(VictoryPoint.class, "VictoryPoint");

        RuntimeTypeAdapterFactory<Card> cardAdapterFactory = RuntimeTypeAdapterFactory.of(Card.class, "type2")
                .registerSubtype(ManufacturedGood.class, "ManufacturedGood")
                .registerSubtype(RawMaterial.class, "RawMaterial")
                .registerSubtype(CommercialStructure.class, "CommercialStructure")
                .registerSubtype(CivilianStructure.class, "CivilianStructure")
                .registerSubtype(MilitaryStructure.class, "MilitaryStructure")
                .registerSubtype(Guild.class, "Guild")
                .registerSubtype(ScientificStructure.class, "ScientificStructure");

        Gson gson = new GsonBuilder().registerTypeAdapterFactory(itemAdapterFactory)
                .registerTypeAdapterFactory(cardAdapterFactory)
                .create();
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
