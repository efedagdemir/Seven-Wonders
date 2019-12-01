package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Item {
    ImageView iv;
    int noOfItems;
    public abstract int getNoOfItems();
    abstract void setNoOfItems(int itemAmount);

    public Image getImage() {
        return image;
    }

    Image image;

    public ImageView getIv() {
        return iv;
    }
}