package Server.model;

public abstract class Card {

    String name;
    abstract boolean constructCard(Player player, Card[] cards, boolean taken);

    public String getName() {
        return name;
    }

//    public ImageView getIV() {
//        return iv;
//    }
}