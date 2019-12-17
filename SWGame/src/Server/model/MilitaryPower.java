package Server.model;

public class MilitaryPower extends Item {

    public MilitaryPower(int military) {
        noOfItems = military;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    void setNoOfItems(int military) {
        noOfItems = noOfItems + military;
    }

}
