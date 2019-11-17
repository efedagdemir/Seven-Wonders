package model;

class AgeI extends Age {

    @Override
    void createDeck(int numOfPlayers) {


        CivilianStructure Altar = new CivilianStructure(2, null, "Temple", null, 0);
        CivilianStructure Theater = new CivilianStructure(2, null, "Statue", null, 0);
        CivilianStructure Baths = new CivilianStructure(3, null, "Aqueduct", "Stone", 1 );

        String[] mpResNames = {"Glass", "Textile", "Papyrus"}; //resource names present in Marketplace
        CommercialStructure Marketplace = new CommercialStructure( 0, 0, null, "Caravansery", true, true, mpResNames);
        String[] tpResNames = {"Clay", "Stone", "Timber", "Ore"}; //resource names present in TradingPost's
        CommercialStructure EastTradingPost = new CommercialStructure( 0, 0, null, "Forum", false, true, tpResNames);
        CommercialStructure WestTradingPost = new CommercialStructure( 0, 0, null, "Forum", true, false, tpResNames);

        if (numOfPlayers == 4) {
            CivilianStructure Pawnshop = new CivilianStructure(3, null, null, null, 0);
            CommercialStructure Tavern = new CommercialStructure(0, 5, null, null, false, false, null);
        }

    }
}
