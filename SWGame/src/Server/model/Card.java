package Server.model;

public abstract class Card {

    String name;
    abstract boolean constructCard(Player player);

    public String getName() {
        return name;
    }

//    public ImageView getIV() {
//        return iv;
//    }
}