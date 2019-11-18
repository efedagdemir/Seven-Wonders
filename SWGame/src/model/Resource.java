package model;

public class Resource extends Item {
    String resourceName;

    public Resource(String resourceName, int resourceAmount) {
        this.resourceName = resourceName;
        noOfItems = resourceAmount;
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
