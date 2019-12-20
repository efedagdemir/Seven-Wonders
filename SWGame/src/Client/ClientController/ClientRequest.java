package Client.ClientController;

import Server.model.Card;
import com.google.gson.Gson;

public class ClientRequest {
    private Card card;
    private String operation;

    public ClientRequest(Card card, String operation) {
        this.card = card;
        this.operation = operation;
    }

    //setter and getter
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getOperation() {
        return operation;
    }

    public void setDropBoard(String operation) {
        this.operation = operation;
    }


}
