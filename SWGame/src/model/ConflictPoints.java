package model;

public class ConflictPoints extends Item {

    public ConflictPoints(int warPoint) {
        noOfItems = warPoint;
    }

    void setNoOfItems(int warPoint){
        noOfItems = noOfItems + warPoint;
    }

    int getNoOfItems(){
        return noOfItems;
    }
}