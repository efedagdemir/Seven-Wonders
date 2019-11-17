package model;

public class Coin extends Item {
    public Coin(int coinAmount) {
        noOfItems = coinAmount;
    }

    void setNoOfItems(int coinAmount){
        noOfItems = noOfItems + coinAmount;
    }

    void getNoOfItems(){
        return noOfItems;
    }
}