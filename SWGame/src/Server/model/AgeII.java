package Server.model;

import java.util.List;

class AgeII extends Age {
    @Override
    void createDeck(int numOfPlayers) {
        //Risk TRYYY
        Risk SWAP_VP = new Risk("risk.png", Risk.RiskEnum.SWAP_VP);
        cardDeck.add(SWAP_VP);
        Risk COIN_DONATION = new Risk("risk.png", Risk.RiskEnum.COIN_DONATION);
        Risk COIN_VIRUS = new Risk("risk.png", Risk.RiskEnum.COIN_VIRUS);
        cardDeck.add(COIN_DONATION);
        cardDeck.add(COIN_VIRUS);
        Risk SWAP_VP2 = new Risk("risk.png", Risk.RiskEnum.SWAP_VP);
        cardDeck.add(SWAP_VP2);
        Risk SWAP_VP3 = new Risk("risk.png", Risk.RiskEnum.SWAP_VP);
        cardDeck.add(SWAP_VP3);
        Risk SWAP_VP4 = new Risk("risk.png", Risk.RiskEnum.SWAP_VP);
        cardDeck.add(SWAP_VP4);
        Risk a = new Risk("risk.png", Risk.RiskEnum.WS_BUILDER);
        Risk b = new Risk("risk.png", Risk.RiskEnum.WS_BUILDER);
        Risk c = new Risk("risk.png", Risk.RiskEnum.WS_BUILDER);
        cardDeck.add(a);
        cardDeck.add(b);
        cardDeck.add(c);


    }

    @Override
    public List<Card> getCardDeck() {
        return null;
    }
}
