package model;

public class Resource extends Item {
    String resourceName;

    public Resource(String resourceName, int resourceAmount) {
        this.resourceName = resourceName;
        noOfItems = resourceAmount;
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
