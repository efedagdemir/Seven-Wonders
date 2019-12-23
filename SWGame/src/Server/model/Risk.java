package Server.model;

public class Risk extends Card {


    RiskEnum riskEnum;

    public Risk(String image, RiskEnum riskEnum) {
        this.name = "risk";
        this.riskEnum = riskEnum;
    }

    @Override
    boolean constructCard(Player chosenPlayer, Card[] cards, boolean taken) {
        Player swapped = ModelService.getInstance().getSwappedPlayer();
        switch (riskEnum) {
            case BLOCK:
            case MP_VIRUS:
            case WS_VIRUS:
            case VP_VIRUS:
            case COIN_DONATION:
            case SEAL_RESOURCE:
            case WS_BUILDER:
            case SWAP_MP:
                riskEnum.constructRisk(chosenPlayer, cards);
                break;
            case COIN_VIRUS:
                riskEnum.constructRisk(chosenPlayer, cards);
                System.out.println("Playerın coini: " + chosenPlayer.getCurrentCoin().noOfItems);
                break;
            case SWAP_VP:
                riskEnum.constructRisk(swapped, chosenPlayer, cards);
                break;
            default:

                break;
        }
        return true;
    }


   public enum RiskEnum {
        BLOCK{
            @Override
            public void constructRisk(Player p, Card[] cards) {
                ModelService.getInstance().removeFromRotatingCardList(cards);
            }
        },
        MP_VIRUS{
            @Override
            public void constructRisk(Player p, Card[] cards) {
                if (p.getMilitaryPower().getNoOfItems() >= 4)
                    p.updateMilitaryPower(-4);
                else {
                    int no = p.getMilitaryPower().getNoOfItems() * (-1);
                    p.updateMilitaryPower(no);
                }
                ModelService.getInstance().removeFromRotatingCardList(cards);
            }
        },
        WS_VIRUS{
            @Override
            public void constructRisk(Player p, Card[] cards) {
                ModelService.getInstance().removeFromRotatingCardList(cards);
            }
        },
        VP_VIRUS{
            @Override
            public void constructRisk(Player p, Card[] cards) {
                if (p.getVictoryPoints().getNoOfItems() >= 3){
                    VictoryPoint vp = new VictoryPoint(-3);
                    p.updateVictoryPoints(vp);
                    ModelService.getInstance().removeFromRotatingCardList(cards);
                }
                else {
                    int no = (-1) * p.getVictoryPoints().getNoOfItems();
                    VictoryPoint vp = new VictoryPoint(no);
                    p.updateVictoryPoints(vp);
                }
                ModelService.getInstance().removeFromRotatingCardList(cards);
            }
        },
        COIN_DONATION{
            @Override
            public void constructRisk(Player p, Card[] cards) {

                p.coinRisk(5);
                ModelService.getInstance().removeFromRotatingCardList(cards);
            }
        },
        SEAL_RESOURCE{
            @Override
            public void constructRisk(Player p, Card[] cards) {
                p.sealResources();
                ModelService.getInstance().removeFromRotatingCardList(cards);
            }
        },
        WS_BUILDER{
            @Override
            public void constructRisk(Player p, Card[] cards) {
                System.out.println("WONDER BUILD");
                ModelService.getInstance().riskBuildWonder(p);
                ModelService.getInstance().removeFromRotatingCardList(cards);
            }
        },
        SWAP_MP{
            @Override
            public void constructRisk(Player swapped, Player chosen, Card[] cards) {
                int mp = swapped.getMilitaryP().noOfItems;
                swapped.getVictoryPoints().setNoOfItems((-1)* mp);
                swapped.getVictoryPoints().setNoOfItems(chosen.getVictoryPoints().getNoOfItems());
                swapped.updateMilitaryPower(chosen.getVictoryPoints().getNoOfItems());
                chosen.getVictoryPoints().setNoOfItems(chosen.getVictoryPoints().getNoOfItems()*(-1));
                chosen.getVictoryPoints().setNoOfItems(mp);
                chosen.updateMilitaryPower(mp);
                ModelService.getInstance().removeFromRotatingCardList(cards);
            }
        },
        SWAP_VP{
            @Override
            public void constructRisk(Player swapped, Player chosen, Card[] cards) {
                int c = swapped.getVictoryPoints().noOfItems;
                swapped.getVictoryPoints().setNoOfItems((-1)* c);
                swapped.getVictoryPoints().setNoOfItems(chosen.getVictoryPoints().getNoOfItems());
                VictoryPoint v1 = new VictoryPoint(chosen.getVictoryPoints().getNoOfItems());
                swapped.updateVictoryPoints(v1);
                chosen.getVictoryPoints().setNoOfItems(chosen.getVictoryPoints().getNoOfItems()*(-1));
                chosen.getVictoryPoints().setNoOfItems(c);
                VictoryPoint v2 = new VictoryPoint(c);
                chosen.updateVictoryPoints(v2);
                ModelService.getInstance().removeFromRotatingCardList(cards);
            }
        },
        COIN_VIRUS{
            @Override
            public void constructRisk(Player p, Card[] cards) {
                if (p.getCurrentCoin().getNoOfItems() >= 5)
                   p.coinRisk(-5);
                else{
                    int no = p.getCurrentCoin().getNoOfItems() * (-1);
                    p.coinRisk(no);
                }
                ModelService.getInstance().removeFromRotatingCardList(cards);
            }
        };

        public void constructRisk(Player p, Card[] cards){}

       public void constructRisk(Player p1, Player p2, Card[] cards){}
   }

}
