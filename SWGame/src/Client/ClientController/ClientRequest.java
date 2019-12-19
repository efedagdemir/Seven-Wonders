package Client.ClientController;

import Server.model.Card;

public class ClientRequest {
    private Card card;
    private int operation;

    public ClientRequest(Card card, int operation) {
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

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }


}
