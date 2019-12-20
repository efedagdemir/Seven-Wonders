package Server.model;

public class MilitaryStructure extends Card {

    Resource[] requiredProducts;
    Structure requiredStructure;
    Structure providedStructure;
    MilitaryPower militaryItem;


    public MilitaryStructure(int mf, String rSt, String pSt, String[] gPName, int[] gPNo, String img, String nameC) {
        name = nameC;
//        image = new Image(img);
//        iv = new javafx.scene.image.ImageView();
//        iv.setImage(image);

        militaryItem = new MilitaryPower(mf);

        if (rSt != null)
            requiredStructure = new Structure(rSt);
        if (pSt != null)
            providedStructure = new Structure(pSt);
        if (gPName != null) {
            requiredProducts = new Resource[gPName.length];
            for (int i = 0; i < gPName.length; i++) {

                Resource r = new Resource(gPName[i], gPNo[i], gPName[i].toLowerCase() + ".png");
                requiredProducts[i] = r;
            }
        }
    }

    @Override
    void constructCard(Player currentPlayer) {
        if (currentPlayer.isFree(this) == true) {
            currentPlayer.updateHand(this);
            currentPlayer.updateMilitaryPower(militaryItem.getNoOfItems());
            currentPlayer.updateFreeStructures(providedStructure);

        } else {
            if (currentPlayer.checkRequirements(requiredStructure, requiredProducts, null) == true) {
                currentPlayer.updateHand(this);
                currentPlayer.updateMilitaryPower(militaryItem.getNoOfItems());
                currentPlayer.updateFreeStructures(providedStructure);
                ModelService.getInstance().removeFromRotatingCardList();
            } else {
                System.out.println("Can't afford");
            }
        }
    }
}