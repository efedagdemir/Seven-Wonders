package Server.model;

public class MilitaryPower extends Item {

    public MilitaryPower(int military) {
        name = "militaryPower";
        noOfItems = military;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    void setNoOfItems(int military) {
        noOfItems = noOfItems + military;
    }

}
