package Server.model;

public class ScientificStructure extends Card {

    Structure requiredS;
    Resource[] requiredP;

    Structure[] providedS;
    ScientificType scType;
    String type;


    public ScientificStructure(String t, String rS, String[] rName, int[] rNo, String[] pS, String img, String nameC) {
        name = nameC;
//        image = new Image(img);
//        iv = new javafx.scene.image.ImageView();
//        iv.setImage(image);
//        iv.setFitHeight(100);
//        iv.setFitWidth(65);
        if (rS != null)
            requiredS = new Structure(rS);
        if (t != null) {
            scType = new ScientificType(t);
            type = t;
        } else {
            type = "";
        }
        if (rName != null) {
            requiredP = new Resource[rName.length];
            for (int i = 0; i < rName.length; i++) {
                Resource a = new Resource(rName[i], rNo[i], rName[i].toLowerCase() + ".png");
                requiredP[i] = a;
            }
        }

        if (pS != null) {
            providedS = new Structure[pS.length];
            for (int i = 0; i < pS.length; i++) {
                Structure b = new Structure(pS[i]);
                providedS[i] = b;
            }
        }


    }

    String getScientificType() {
        return type;
    }

    @Override
    boolean constructCard(Player currentPlayer, Card[] cards, boolean taken) {
        if (currentPlayer.isFree(this)|| taken) {
            currentPlayer.updateHand(this);
            currentPlayer.updateFreeStructures(providedS);
            currentPlayer.updateScientifictType(scType);
            ModelService.getInstance().removeFromRotatingCardList(cards);
            return true;
        } else {
            if (currentPlayer.checkRequirements(requiredS, requiredP, null)) {
                currentPlayer.updateHand(this);
                currentPlayer.updateFreeStructures(providedS);
                currentPlayer.updateScientifictType(scType);
                ModelService.getInstance().removeFromRotatingCardList(cards);
                return true;
            } else {
                System.out.println("Can't afford!");
                return false;
            }
        }
    }
}


