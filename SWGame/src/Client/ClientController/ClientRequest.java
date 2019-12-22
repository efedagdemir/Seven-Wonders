package Client.ClientController;

import Server.model.Card;
import com.google.gson.Gson;

public class ClientRequest {
    private Card card;
    private String operation;
    private int spentToLeft;
    private int spentToRight;

    public ClientRequest(Card card, String operation) {
        this.card = card;
        this.operation = operation;
        this.spentToLeft = ClientControllerFacade.getInstance().getClientManager().getSpentToLeft();
        this.spentToRight = ClientControllerFacade.getInstance().getClientManager().getSpentToRight();
        ClientControllerFacade.getInstance().getClientManager().setSpentToLeft(0);
        ClientControllerFacade.getInstance().getClientManager().setSpentToRight(0);
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

    public int getSpentToLeft()  { return spentToLeft; }
    public int getSpentToRight() { return spentToRight; }

}
