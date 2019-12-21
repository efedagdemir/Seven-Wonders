package Server.model;

public class RawMaterial extends Card {

    Coin price;
    Resource[] products;


    public RawMaterial(int amount, String[] prName, int[] prNo, String img, String nameC) {
        name = nameC;
//        image = new Image(img);
//        iv = new javafx.scene.image.ImageView();
//        iv.setImage(image);
//        iv.setFitHeight(100);
//        iv.setFitWidth(65);

        price = new Coin(amount, "coin.png");

        if (prName != null) {
            products = new Resource[prName.length];
            for (int i = 0; i < prName.length; i++) {

                System.out.println(prName[i].toLowerCase() + ".png");
                Resource r = new Resource(prName[i], prNo[i], prName[i].toLowerCase() + ".png");
                products[i] = r;
            }
        }
    }

    @Override
    boolean constructCard(Player currentPlayer, Card[] cards) {
        if (currentPlayer.isFree(this)) {
            currentPlayer.updateHand(this);
            currentPlayer.updateResources(products);
            ModelService.getInstance().removeFromRotatingCardList(cards);
            return true;
        } else {
            if (currentPlayer.checkRequirements(null, null, price)) {
                currentPlayer.updateHand(this);
                currentPlayer.updateResources(products);
                currentPlayer.addCoin(-1 * price.getNoOfItems());
                ModelService.getInstance().removeFromRotatingCardList(cards);
                return true;
            } else {
                System.out.println("Can't afford!");
                return false;
            }
        }
    }
}


