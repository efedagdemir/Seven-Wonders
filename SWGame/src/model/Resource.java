package model;

public class Resource extends Item {
    String resourceName;

    public Resource(String resourceName, int resourceAmount) {
        this.resourceName = resourceName;
        noOfItems = resourceAmount;
    }

    void setNoOfItems(int resourceAmount){
        noOfItems = numOfItems + resourceAmount;
    }

    public String getResourceName() {
        return resourceName;
    }

    void getNoOfItems(){
        return noOfItems;
    }
}
