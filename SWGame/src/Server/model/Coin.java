package Server.model;


public class Coin extends Item {

    public Coin(int coinAmount, String img) {
        noOfItems = coinAmount;
        name = img;
    }

    @Override
    public String getName() {
        return name;
    }




    public int getNoOfItems() {
        return noOfItems;
    }

    void setNoOfItems(int coinAmount) {
        noOfItems = noOfItems + coinAmount;
    }
}
