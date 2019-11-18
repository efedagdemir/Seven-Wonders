package model;

abstract class Age {
    Card[] cardDeck;

    abstract void createDeck(int numOfPlayers);
}