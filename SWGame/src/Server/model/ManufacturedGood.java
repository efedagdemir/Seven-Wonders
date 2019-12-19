package Server.model;

public class ManufacturedGood extends Card {

    Resource[] requiredProducts;
    Resource[] givenProducts;

    public ManufacturedGood(String[] gProductType, int[] gProductNo, String[] rProductType, int[] rProductNo, String img, String nameC) {
        name = nameC;
//        image = new Image(img);
//        iv = new javafx.scene.image.ImageView();
//        iv.setImage(image);

        if (gProductType != null) {
            givenProducts = new Resource[gProductType.length];
            for (int i = 0; i < gProductType.length; i++) {
                Resource g = new Resource(gProductType[i], gProductNo[i],
                        gProductType[i].toLowerCase() + ".png");
                givenProducts[i] = g;
            }
        }

        if (rProductType != null) {
            requiredProducts = new Resource[rProductType.length];
            for (int i = 0; i < rProductType.length; i++) {
                Resource r = new Resource(rProductType[i], rProductNo[i],
                        rProductType[i].toLowerCase() + ".png");
                requiredProducts[i] = r;
            }
        }
    }

    @Override
    void constructCard() {
        ModelService modelService = ModelService.getInstance();
        Player currentPlayer = modelService.getCurrentPlayer();
        if (currentPlayer.isFree(this) == true) {
            currentPlayer.updateHand(this);
            currentPlayer.updateResources(givenProducts);
            ModelService.getInstance().removeFromRotatingCardList();
        } else {
            if (currentPlayer.checkRequirements(null, requiredProducts, null) == true) {
                currentPlayer.updateHand(this);
                currentPlayer.updateResources(givenProducts);
                ModelService.getInstance().removeFromRotatingCardList();
            } else {
                System.out.println("Can't afford");
            }

        }

    }


}