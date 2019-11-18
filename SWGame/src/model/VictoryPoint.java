package model;

public class VictoryPoint extends Item {

    public VictoryPoint(int noOfVictoryPoints){
        noOfItems = noOfVictoryPoints;
    }

    void setNoOfItems(int noOfVictoryPoints){
        noOfItems = noOfItems + noOfVictoryPoints;
    }

    int getNoOfItems(){
        return noOfItems;
    }



}
