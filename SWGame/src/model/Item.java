package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Item {
    Image image;
    ImageView iv;
    int noOfItems;
    abstract int getNoOfItems();
    abstract void setNoOfItems(int itemAmount);
}