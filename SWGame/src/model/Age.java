package model;
import java.util.List;

abstract class Age {

    List<Card> cardDeck;

    abstract void createDeck(int numOfPlayers);
    abstract public List<Card> getCardDeck();
}