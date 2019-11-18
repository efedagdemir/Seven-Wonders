package model;

public class MilitaryPower extends Item {

    public MilitaryPower(int military){
        noOfItems = military;
    }

    void setNoOfItems(int military){
        noOfItems = noOfItems + military;
    }

    int getNoOfItems(){
        return noOfItems;
    }

}
