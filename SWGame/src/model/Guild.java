package model;

public class Guild extends Card {

    VictoryPoints victoryPoints;
    Structure requiredStructure;
    Resource[] requiredProduct;

    /*Constructor for Guilds which require more than one resources*/
    public Guild(int vp, String rStructure, String[] rProductType,  int[] rProductNo){
        victoryPoints = new VictoryPoints(vp);
        requiredStructure = new Structure(rStructure);
        requiredProduct = new Resource[rProductType.length];

        for (int i = 0; i < rProductType.length; i++ ){
            Resource r = new Resource(rProductType[i], rProductNo[i]);
            requiredProduct[i] = r;
        }
    }
    /*Constructor for Guilds which require only one resource */
    public Guild(int vp, String rStructure, String resName, int resNo){
        victoryPoints = new VictoryPoints(vp);
        requiredStructure = new Structure(rStructure);
        requiredProduct = new Resource[1];
        requiredProduct[0] =new Resource(resName,  resNo);
    }

    @Override
    void constructCard() {
        super.constructCard();
    }
}
