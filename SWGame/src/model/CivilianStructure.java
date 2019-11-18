package model;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class CivilianStructure extends Card {

    VictoryPoint victoryPoints;
    Structure requiredStructure;
    Structure providedStructure;
    Resource[] requiredProduct;
    Image image;
    ImageView iv;

    /*Constructor for Civilian Cards which require more than one resources*/
    public CivilianStructure( int vPoints, String rStructure, String pStructure, String[] rProductType,  int[] rProductNo, String img, String nameC){
        name = nameC;
        image = new Image(img);
        iv = new ImageView();
        iv.setImage(image);

        victoryPoints = new VictoryPoint(vPoints);
        requiredStructure = new Structure(rStructure);
        providedStructure = new Structure(pStructure);
        requiredProduct = new Resource[rProductType.length];

        for (int i = 0; i < rProductType.length; i++ ){
                Resource r = new Resource(rProductType[i], rProductNo[i]);
                requiredProduct[i] = r;
        }

    }

    /*Constructor for Civilian Cards which require only one resource */
    public CivilianStructure( int vPoints, String rStructure, String pStructure, String resName,  int resNo, String img){

        image = new Image(img);
        iv = new ImageView();
        iv.setImage(image);
        iv.setFitHeight(100);
        iv.setFitWidth(65);
        victoryPoints = new VictoryPoint(vPoints);
        requiredStructure = new Structure(rStructure);
        providedStructure = new Structure(pStructure);
        requiredProduct = new Resource[1];
        requiredProduct[0] =new Resource(resName,  resNo);

    }

    @Override
    void constructCard() {
        ModelService modelService = ModelService.getInstance();
        Player currentPlayer = modelService.getCurrentPlayer();
        if ( currentPlayer.isFree(this) == true){
            currentPlayer.updateHand(this);
            currentPlayer.updateVictoryPoints(victoryPoints);
            currentPlayer.updateFreeStructures(providedStructure);
        }
        else{
            if (currentPlayer.checkRequirements(requiredStructure, requiredProduct, null) == true){
                currentPlayer.updateHand(this);
                currentPlayer.updateVictoryPoints(victoryPoints);
                currentPlayer.updateFreeStructures(providedStructure);
            }
            else {
                System.out.println("Can't afford!!");
            }
        }

    }
}
