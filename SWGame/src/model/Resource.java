package model;

public class Resource extends Item {
    String resourceName;
    boolean leftDiscount;
    boolean rightDiscount;

    public Resource(String resourceName, int resourceAmount) {
        this.resourceName = resourceName;
        noOfItems = resourceAmount;
        leftDiscount = false;
        rightDiscount = false;
    }

    public Resource(String resourceName, int resourceAmount, boolean leftDiscount, boolean rightDiscount) {
        this.resourceName = resourceName;
        noOfItems = resourceAmount;
        this.leftDiscount = leftDiscount;
        this.rightDiscount = rightDiscount;
    }

    void setNoOfItems(int resourceAmount){
        noOfItems = noOfItems + resourceAmount;
    }

    public String getResourceName() {
        return resourceName;
    }

    int getNoOfItems(){
        return noOfItems;
    }
}
