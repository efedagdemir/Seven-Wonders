package Server.model;

public class CivilianStructure extends Card {

    VictoryPoint victoryPoints;
    Structure requiredStructure;
    Structure providedStructure;

    Resource[] requiredProduct;

    //Constructor for Civilian Cards which require more than one resources
    public CivilianStructure(int vPoints, String rStructure, String pStructure, String[] rProductType, int[] rProductNo, String img, String nameC) {
        name = nameC;
//        image = new Image(img);
//        iv = new ImageView();
//        iv.setImage(image);

        victoryPoints = new VictoryPoint(vPoints);
        if (rStructure != null)
            requiredStructure = new Structure(rStructure);
        if (pStructure != null)
            providedStructure = new Structure(pStructure);
        if (rProductType != null) {
            requiredProduct = new Resource[rProductType.length];
            for (int i = 0; i < rProductType.length; i++) {
                Resource r = new Resource(rProductType[i], rProductNo[i], rProductType[i].toLowerCase() + ".png");
                requiredProduct[i] = r;
            }
        }

    }

    /*Constructor for Civilian Cards which require only one resource */
    public CivilianStructure(int vPoints, String rStructure, String pStructure, String resName, int resNo, String img, String nameC) {
        name = nameC;
//        image = new Image(img);
//        iv = new ImageView();
//        iv.setImage(image);
//        iv.setFitHeight(100);
//        iv.setFitWidth(65);

        victoryPoints = new VictoryPoint(vPoints);
        if (rStructure != null)
            requiredStructure = new Structure(rStructure);
        if (pStructure != null)
            providedStructure = new Structure(pStructure);
        if (resName != null) {
            requiredProduct = new Resource[1];
            requiredProduct[0] = new Resource(resName, resNo, resName.toLowerCase() + ".png");
        }

    }

    @Override
    void constructCard(Player currentPlayer, Card[] cards) {
        if (currentPlayer.isFree(this)) {
            currentPlayer.updateHand(this);
            currentPlayer.updateVictoryPoints(victoryPoints);
            currentPlayer.updateFreeStructures(providedStructure);
            ModelService.getInstance().removeFromRotatingCardList(cards);
        } else {
            if (currentPlayer.checkRequirements(requiredStructure, requiredProduct, null)) {
                currentPlayer.updateHand(this);
                currentPlayer.updateVictoryPoints(victoryPoints);
                currentPlayer.updateFreeStructures(providedStructure);
                ModelService.getInstance().removeFromRotatingCardList(cards);
            } else {
                System.out.println("Can't afford!!");
            }
        }

    }
}