package Server.model;

public class Risk extends Card {


    RiskEnum riskEnum;

    public Risk(String image, RiskEnum riskEnum) {
        this.name = name;
        /*this.image = new Image(image);
        iv = new javafx.scene.image.ImageView();
        iv.setImage(this.image);*/
        this.riskEnum = riskEnum;
    }

    @Override
    boolean constructCard(Player chosenPlayer
    ) {
        Player swapped = ModelService.getInstance().getSwappedPlayer();
        switch (riskEnum) {
            case BLOCK:
                riskEnum.constructRisk(chosenPlayer);
                break;
            case COIN_VIRUS:
                riskEnum.constructRisk(chosenPlayer);
                System.out.println("Playerın coini: " + chosenPlayer.getCurrentCoin().noOfItems);
                break;
            case MP_VIRUS:
                riskEnum.constructRisk(chosenPlayer);
                break;
            case WS_VIRUS:
                riskEnum.constructRisk(chosenPlayer);
                break;
            case VP_VIRUS:
                riskEnum.constructRisk(chosenPlayer);
                break;
            case COIN_DONATION:
                riskEnum.constructRisk(chosenPlayer);
                break;
            case SEAL_RESOURCE:
                riskEnum.constructRisk(chosenPlayer);
                break;
            case WS_BUILDER:
                riskEnum.constructRisk(chosenPlayer);
                break;
            case SWAP_MP:
                riskEnum.constructRisk(chosenPlayer);
                break;
            case SWAP_VP:
                riskEnum.constructRisk(swapped, chosenPlayer);
                break;
            default:

                break;
        }
        return true;
    }


   public enum RiskEnum {
        BLOCK{
            @Override
            public void constructRisk(Player p) {

            }
        },
        MP_VIRUS{
            @Override
            public void constructRisk(Player p) {
                if (p.getMilitaryPower().getNoOfItems() >= 4)
                    p.updateMilitaryPower(-4);
                else {
                    int no = p.getMilitaryPower().getNoOfItems() * (-1);
                    p.updateMilitaryPower(no);
                }
                ModelService.getInstance().removeFromRotatingCardList();
            }
        },
        WS_VIRUS{
            @Override
            public void constructRisk(Player p) {

            }
        },
        VP_VIRUS{
            @Override
            public void constructRisk(Player p) {
                if (p.getVictoryPoints().getNoOfItems() >= 3){
                    VictoryPoint vp = new VictoryPoint(-3);
                    p.updateVictoryPoints(vp);
                }
                else {
                    int no = (-1) * p.getVictoryPoints().getNoOfItems();
                    VictoryPoint vp = new VictoryPoint(no);
                    p.updateVictoryPoints(vp);
                }
                ModelService.getInstance().removeFromRotatingCardList();
            }
        },
        COIN_DONATION{
            @Override
            public void constructRisk(Player p) {

                p.coinRisk(5);
                ModelService.getInstance().removeFromRotatingCardList();
            }
        },
        SEAL_RESOURCE{
            @Override
            public void constructRisk(Player p) {
                p.sealResources();
                ModelService.getInstance().removeFromRotatingCardList();
            }
        },
        WS_BUILDER{
            @Override
            public void constructRisk(Player p) {
                System.out.println("WONDER BUILD");
                ModelService.getInstance().riskBuildWonder(p);
                ModelService.getInstance().removeFromRotatingCardList();
            }
        },
        SWAP_MP{
            @Override
            public void constructRisk(Player swapped, Player chosen) {
                int mp = swapped.getMilitaryP().noOfItems;
                swapped.getVictoryPoints().setNoOfItems((-1)* mp);
                swapped.getVictoryPoints().setNoOfItems(chosen.getVictoryPoints().getNoOfItems());
                swapped.updateMilitaryPower(chosen.getVictoryPoints().getNoOfItems());
                chosen.getVictoryPoints().setNoOfItems(chosen.getVictoryPoints().getNoOfItems()*(-1));
                chosen.getVictoryPoints().setNoOfItems(mp);
                chosen.updateMilitaryPower(mp);
                ModelService.getInstance().removeFromRotatingCardList();
            }
        },
        SWAP_VP{
            @Override
            public void constructRisk(Player swapped, Player chosen) {
                int c = swapped.getVictoryPoints().noOfItems;
                swapped.getVictoryPoints().setNoOfItems((-1)* c);
                swapped.getVictoryPoints().setNoOfItems(chosen.getVictoryPoints().getNoOfItems());
                VictoryPoint v1 = new VictoryPoint(chosen.getVictoryPoints().getNoOfItems());
                swapped.updateVictoryPoints(v1);
                chosen.getVictoryPoints().setNoOfItems(chosen.getVictoryPoints().getNoOfItems()*(-1));
                chosen.getVictoryPoints().setNoOfItems(c);
                VictoryPoint v2 = new VictoryPoint(c);
                chosen.updateVictoryPoints(v2);
                ModelService.getInstance().removeFromRotatingCardList();
            }
        },
        COIN_VIRUS{
            @Override
            public void constructRisk(Player p) {
                if (p.getCurrentCoin().getNoOfItems() >= 5)
                   p.coinRisk(-5);
                else{
                    int no = p.getCurrentCoin().getNoOfItems() * (-1);
                    p.coinRisk(no);
                }
                ModelService.getInstance().removeFromRotatingCardList();
            }
        };

        public void constructRisk(Player p){}

       public void constructRisk(Player p1, Player p2){}
   }

}
