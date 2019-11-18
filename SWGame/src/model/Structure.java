package model;

public class Structure extends Item {
    String type;

    public Structure(String type) {
        this.type = type;
        noOfItems++;
    }

    void setNoOfItems(){
        noOfItems++;
    }

    public String getType() {
        return type;
    }

    public int getNoOfItems() {
        return noOfItems;
    }
}