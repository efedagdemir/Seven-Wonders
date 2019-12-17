package Server.model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coin extends Item {

    public Coin(int coinAmount, String img) {
        noOfItems = coinAmount;
        image = new Image(img);
        iv = new ImageView();
        iv.setImage(image);
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    void setNoOfItems(int coinAmount) {
        noOfItems = noOfItems + coinAmount;
    }
}
