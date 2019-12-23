package Server.model;

import java.util.List;

public abstract class Age {
    public Age(){}
    public String name;
    List<Card> cardDeck;
    abstract void createDeck(int numOfPlayers);
    abstract public List<Card> getCardDeck();
}