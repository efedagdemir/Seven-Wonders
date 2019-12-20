package Server.model;

public abstract class Card {

    String name;
//    Image image;
//    ImageView iv;

    abstract void constructCard();

    public String getName() {
        return name;
    }

//    public ImageView getIV() {
//        return iv;
//    }
}