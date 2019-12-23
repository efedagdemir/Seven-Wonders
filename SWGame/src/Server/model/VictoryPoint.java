package Server.model;

public class VictoryPoint extends Item {

    public VictoryPoint(int noOfVictoryPoints) {
        name = "victoryPoint.png";
//        image = new Image("victoryPoint.png");
//        iv = new ImageView();
//        iv.setImage(image);
        noOfItems = noOfVictoryPoints;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    void setNoOfItems(int noOfVictoryPoints) {
        noOfItems = noOfItems + noOfVictoryPoints;
    }


}
