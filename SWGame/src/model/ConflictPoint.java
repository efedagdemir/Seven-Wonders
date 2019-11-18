package model;

public class ConflictPoint extends Item {

    public ConflictPoint(int warPoint) {
        noOfItems = warPoint;
    }

    void setNoOfItems(int warPoint){
        noOfItems = noOfItems + warPoint;
    }

    int getNoOfItems(){
        return noOfItems;
    }
}