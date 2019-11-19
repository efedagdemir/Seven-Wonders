package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Resource extends Item {
    String resourceName;
    boolean leftDiscount;
    boolean rightDiscount;

    public Resource(String resourceName, int resourceAmount,String img) {
        this.resourceName = resourceName;
        noOfItems = resourceAmount;
        leftDiscount = false;
        rightDiscount = false;
        image = new Image(img);
        iv = new ImageView();
        iv.setImage(image);
    }

    public Resource(String resourceName, int resourceAmount, boolean leftDiscount, boolean rightDiscount, String img) {
        this.resourceName = resourceName;
        noOfItems = resourceAmount;
        this.leftDiscount = leftDiscount;
        this.rightDiscount = rightDiscount;
        image = new Image(img);
        iv = new ImageView();
        iv.setImage(image);
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public String getResourceName() {
        return resourceName;
    }

    void setNoOfItems(int resourceAmount) {
        noOfItems = noOfItems + resourceAmount;
    }
}
