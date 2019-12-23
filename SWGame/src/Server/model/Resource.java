package Server.model;

public class Resource extends Item {
    String resourceName;
    boolean leftDiscount;
    boolean rightDiscount;

    public Resource(String resourceName, int resourceAmount, String img) {
        this.resourceName = resourceName;
        noOfItems = resourceAmount;
        leftDiscount = false;
        rightDiscount = false;
        name = img;
    }

    public Resource(String resourceName, int resourceAmount, boolean leftDiscount, boolean rightDiscount, String img) {
        this.resourceName = resourceName;
        noOfItems = resourceAmount;
        this.leftDiscount = leftDiscount;
        this.rightDiscount = rightDiscount;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    void setNoOfItems(int resourceAmount) {
        noOfItems = noOfItems + resourceAmount;
    }

    public String getResourceName() {
        return resourceName;
    }
}