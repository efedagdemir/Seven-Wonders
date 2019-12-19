package Server.model;

public class ConflictPoint extends Item {

    public ConflictPoint(int warPoint) {
//        image = new Image("militaryPower.png");
//        iv = new ImageView();
//        iv.setImage(image);
        name = "militaryPower.png";
        noOfItems = warPoint;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    void setNoOfItems(int warPoint) {
        noOfItems = noOfItems + warPoint;
    }
}