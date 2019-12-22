package Server.model;

public class Guild extends Card {

    VictoryPoint victoryPoints;
    Structure requiredStructure;
    Resource[] requiredProduct;
//    Image image;
//    ImageView iv;

    //Constructor for Guilds which require more than one resources
    public Guild(int vp, String rStructure, String[] rProductType, int[] rProductNo, String img, String nameC) {
        name = nameC;
//        image = new Image(img);
//        iv = new ImageView();
//        iv.setImage(image);
//        iv.setFitHeight(100);
//        iv.setFitWidth(65);

        victoryPoints = new VictoryPoint(vp);
        if (rStructure != null)
            requiredStructure = new Structure(rStructure);
        if (rProductType != null) {
            requiredProduct = new Resource[rProductType.length];

            for (int i = 0; i < rProductType.length; i++) {
                Resource r = new Resource(rProductType[i], rProductNo[i], rProductType[i].toLowerCase() + ".png");
                requiredProduct[i] = r;
            }
        }
    }

    /*Constructor for Guilds which require only one resource */
    public Guild(int vp, String rStructure, String resName, int resNo, String img) {

//        image = new Image(img);
//        iv = new ImageView();
//        iv.setImage(image);
//        iv.setFitHeight(100);
//        iv.setFitWidth(65);

        victoryPoints = new VictoryPoint(vp);
        if (rStructure != null)
            requiredStructure = new Structure(rStructure);
        if (resName != null) {
            requiredProduct = new Resource[1];
            requiredProduct[0] = new Resource(resName, resNo, resName.toLowerCase() + ".png");
        }
    }

    @Override
    boolean constructCard(Player currentPlayer, Card[] cards, boolean taken) {
        if (currentPlayer.isFree(this)|| taken) {
            currentPlayer.updateHand(this);
            currentPlayer.updateVictoryPoints(victoryPoints);
            ModelService.getInstance().removeFromRotatingCardList(cards);
            return true;
        } else {
            if (currentPlayer.checkRequirements(requiredStructure, requiredProduct, null)) {
                currentPlayer.updateHand(this);
                currentPlayer.updateVictoryPoints(victoryPoints);
                ModelService.getInstance().removeFromRotatingCardList(cards);
                return true;
            } else {
                System.out.println("Can't afford");
                return false;
            }

        }
    }

    void chooseAction(Player currentPlayer, Card[] cards){
        if(this.name.equals("StrategistsGuild")){
            int vp = 0;
            for(Card card : currentPlayer.getHand()){
                if(card instanceof RawMaterial || card instanceof Guild || card instanceof ManufacturedGood){
                    vp++;
                }
            }
            currentPlayer.updateVictoryPoints(new VictoryPoint(currentPlayer.getVictoryPoints().noOfItems + vp));
        }
        else if("ScientistGuild".equals(this.name)){
            ScientificType cog = new ScientificType("Cog");
            ScientificType ruler = new ScientificType("Ruler");
            ScientificType tomb = new ScientificType("Tomb");
            currentPlayer.updateScientifictType(cog);
            currentPlayer.updateScientifictType(ruler);
            currentPlayer.updateScientifictType(tomb);
        }
        else if (this.name.equals("BuildersGuild")){
            int totalVp = currentPlayer.wonder.getWonderLevel() + currentPlayer.getLeftNeighbor().wonder.getWonderLevel() +
                    currentPlayer.getRightNeighbor().wonder.getWonderLevel();
            currentPlayer.updateVictoryPoints(new VictoryPoint(totalVp));
        }
    }
}


