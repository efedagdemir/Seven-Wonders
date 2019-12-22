package Server.model;

public class CommercialStructure extends Card {

    String path;
    private VictoryPoint victoryPoints;
    private Coin givenCoins;
    private Structure requiredStructure;
    private Structure providedStructure;
    private boolean leftDiscount;
    private boolean rightDiscount;
    private Resource[] discountedR;

    public CommercialStructure(int vp, int coins, String rStructure, String pStructure, boolean leftDiscount, boolean rightDiscount, String[] discountedResources, String img, String nameC) {

//        image = new Image(img);
//        iv = new ImageView();
//        iv.setImage(image);
        name = nameC;
        path = img;
        victoryPoints = new VictoryPoint(vp);
        givenCoins = new Coin(coins, "coin.png");
        if (rStructure != null)
            requiredStructure = new Structure(rStructure);
        if (pStructure != null)
            providedStructure = new Structure(pStructure);


        this.leftDiscount = leftDiscount;
        this.rightDiscount = rightDiscount;
        if (discountedResources != null) {
            this.discountedR = new Resource[discountedResources.length];

            for (int i = 0; i < discountedResources.length; i++) {
                Resource r = new Resource(discountedResources[i], 1, leftDiscount, rightDiscount,
                        discountedResources[i].toLowerCase() + ".png");
                discountedR[i] = r;

            }
        }
    }

    @Override
    boolean constructCard(Player currentPlayer, Card[] cards, boolean taken) {
        if (currentPlayer.isFree(this) || taken) {
            currentPlayer.updateHand(this);
            currentPlayer.updateFreeStructures(providedStructure);
            currentPlayer.updateDiscountedResources(discountedR);
            currentPlayer.addCoin(givenCoins.getNoOfItems());
            currentPlayer.updateVictoryPoints(victoryPoints);
            ModelService.getInstance().removeFromRotatingCardList(cards);
            return true;
        } else {
            if (currentPlayer.checkRequirements(requiredStructure, null, givenCoins)) {
                currentPlayer.updateHand(this);
                currentPlayer.updateFreeStructures(providedStructure);
                currentPlayer.updateDiscountedResources(discountedR);
                currentPlayer.addCoin(givenCoins.getNoOfItems());
                currentPlayer.updateVictoryPoints(victoryPoints);
                ModelService.getInstance().removeFromRotatingCardList(cards);
                return true;
            } else {
                System.out.println("Can't afford!!");
                return false;
            }
        }
    }

    public String getPath() {
        return path;
    }
}