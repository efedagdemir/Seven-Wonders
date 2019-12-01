package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VictoryPoint extends Item {

    public VictoryPoint(int noOfVictoryPoints){
        image = new Image("victoryPoint.png");
        iv = new ImageView();
        iv.setImage(image);
        noOfItems = noOfVictoryPoints;
    }

    void setNoOfItems(int noOfVictoryPoints){
        noOfItems = noOfItems + noOfVictoryPoints;
    }

    public int getNoOfItems(){
        return noOfItems;
    }



}
