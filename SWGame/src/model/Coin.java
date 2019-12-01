package model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coin extends Item {

    public Coin(int coinAmount,String img) {
        noOfItems = coinAmount;
        image = new Image(img);
        iv = new ImageView();
        iv.setImage(image);
    }

    void setNoOfItems(int coinAmount){
        noOfItems = noOfItems + coinAmount;
    }

    public int getNoOfItems(){
        return noOfItems;
    }
}
