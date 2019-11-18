package model;

class AgeI extends Age {

    @Override
    void createDeck(int numOfPlayers) {

        /*Civilian Structures */

        CivilianStructure Altar = new CivilianStructure(2, null, "Temple", null, 0, "images/altar.png", "Altar");
        CivilianStructure Theater = new CivilianStructure(2, null, "Statue", null, 0,"images/theater.png", "Theater");
        CivilianStructure Baths = new CivilianStructure(3, null, "Aqueduct", "Stone", 1,"images/altar.png",  "Baths" );
        cardDeck.add(Altar);
        cardDeck.add(Theater);
        cardDeck.add(Baths);
        /*Commercial Structures*/
        String[] mpResNames = {"Glass", "Textile", "Papyrus"}; //resource names present in Marketplace
        CommercialStructure Marketplace = new CommercialStructure( 0, 0, null, "Caravansery", true, true, mpResNames, "images/marketplace.png", "Marketplace");
        String[] tpResNames = {"Clay", "Stone", "Timber", "Ore"}; //resource names present in TradingPost's
        CommercialStructure EastTradingPost = new CommercialStructure( 0, 0, null, "Forum", false, true, tpResNames, "images/easttradingpost.png", "EastTradingPost");
        CommercialStructure WestTradingPost = new CommercialStructure( 0, 0, null, "Forum", true, false, tpResNames, "images/westtradingpost.png", "WestTradingPost");
        cardDeck.add(Marketplace);
        cardDeck.add(EastTradingPost);
        cardDeck.add(WestTradingPost);
        /*Manufactured Goods*/
        String[]  lGivenP = {"Textile"};
        int[] lGivenNo = {1};
        String[] lReqP = {};
        int[] lReqNo = {};
        ManufacturedGood Loom = new ManufacturedGood(lGivenP, lGivenNo, lReqP, lReqNo, "images/loom.png", "Loom");
        cardDeck.add(Loom);

        String[]  prGivenP = {"Papyrus"};
        int[] prGivenNo = {1};
        String[] prReqP = {};
        int[] prReqNo = {};
        ManufacturedGood Press = new ManufacturedGood(prGivenP, prGivenNo, prReqP, prReqNo, "images/press.png", "Press");
        cardDeck.add(Press);

        String[]  gwGivenP = {"Glass"};
        int[] gwwGivenNo = {1};
        String[] gwReqP = {};
        int[] gwReqNo = {};
        ManufacturedGood Glassworks = new ManufacturedGood(gwGivenP, gwwGivenNo, gwReqP, gwReqNo, "images/glassworks.png", "Glassworks");
        cardDeck.add(Glassworks);

        /*Scientific Structures*/
        String[] scName = {"Papyrus"};
        int[] scNo = {1};
        String[] pName = {"Courthouse", "Library"};
        ScientificStructure Scriptorium = new ScientificStructure("Tomb", null, scName, scNo, pName, "images/scriptorium.png", "Scriptorium");
        cardDeck.add(Scriptorium);

        String[] wName = {"Glass"};
        int[] wNo = {1};
        String[] wpName = {"Laboratory", "ArcheryRange"};
        ScientificStructure Workshop = new ScientificStructure("Cog",null, wName, wNo, wpName, "images/workshop.png", "Workshop");
        cardDeck.add(Workshop);

        String[] apName = {"Textile"};
        int[] apNo = {1};
        String[] paName = {"Stables", "Dispensary"};
        ScientificStructure Apothecary = new ScientificStructure("Ruler", null, apName, apNo, paName, "images/apothecary.png", "Apothecary");
        cardDeck.add(Apothecary);

        /*Raw Materials*/
        String[] cpName = {"Clay"};
        int[] cpNo = {1};
        RawMaterial ClayPool = new RawMaterial(0, cpName, cpNo, "images/claypool.png", "ClayPool");
        cardDeck.add(ClayPool);

        String[] ovName = {"Ore"};
        int[] ovNo = {1};
        RawMaterial OreVein = new RawMaterial(0, ovName, ovNo, "images/orevein.png","OreVein");
        cardDeck.add(OreVein);

        String[] tyName = {"Stone, Timber"};
        int[] tyNo = {1,1};
        RawMaterial TimberYard = new RawMaterial(1, tyName, tyNo, "images/timberyard.png", "TimberYard");
        cardDeck.add(TimberYard);

        String[] spName = {"Stone"};
        int[] spNo = {1};
        RawMaterial StonePit = new RawMaterial(0, spName, spNo, "images/stonepit.png", "StonePit");
        cardDeck.add(StonePit);

        String[] lyName = {"Timber"};
        int[] lyNo = {1};
        RawMaterial LumberYard = new RawMaterial(0, lyName, lyNo, "images/lumberyard.png", "LumberYard");
        cardDeck.add(LumberYard);

        String[] cpitName = {"Clay", "Ore"};
        int[] cpitNo = {1,1};
        RawMaterial ClayPit = new RawMaterial(1, cpitName, cpitNo, "images/claypit.png", "ClayPit" );
        cardDeck.add(ClayPit);

        /*Military Structures*/
        String[] barName = {"Ore"};
        int[] barNo = {1};
        MilitaryStructure Barracks = new MilitaryStructure(1, null, null, barName, barNo,"images/barracks.png", "Barracks" );
        cardDeck.add(Barracks);

        String[] stcName = {"Timber"};
        int[] stcNo = {1};
        MilitaryStructure Stockade = new MilitaryStructure(1, null, null, stcName, stcNo, "images/guardtower.png", "Stockade");
        cardDeck.add(Stockade);

        String[] guaName = {"Clay"};
        int[] guaNo = {1};
        MilitaryStructure GuardTower = new MilitaryStructure(1, null, null, guaName, guaNo, "images/guardtower.png", "GuardTower");
        cardDeck.add(GuardTower);


        if (numOfPlayers == 4) {

            CivilianStructure Pawnshop = new CivilianStructure(3, null, null, null, 0, "images/pawnshop.png", "Pawnshop");
            cardDeck.add(Pawnshop);

            String[] tavernS = {};
            CommercialStructure Tavern = new CommercialStructure(0, 5, null, null, false, false, tavernS, "images/tavern.png", "Tavern");
            cardDeck.add(Tavern);

            String[] scName2 = {"Papyrus"};
            int[] scNo2 = {1};
            String[] pName2 = {"Courthouse", "Library"};
            ScientificStructure Scriptorium2 = new ScientificStructure("Tomb", null, scName2, scNo2, pName2, "images/scriptorium.png", "Scriptorium2");
            cardDeck.add(Scriptorium2);

            /*Raw Materials*/
            String[] lyName2 = {"Timber"};
            int[] lyNo2 = {1};
            RawMaterial LumberYard2 = new RawMaterial(0, lyName2, lyNo2, "images/lumberyard.png","LumberYard2");
            cardDeck.add(LumberYard2);

            String[] exName = {"Stone", "Clay"};
            int[] exNo = {1,1};
            RawMaterial Excavation = new RawMaterial(1, exName, exNo, "images/excavation.png","Excavation");
            cardDeck.add(Excavation);

            String[] ovName2 = {"Ore"};
            int[] ovNo2 = {1};
            RawMaterial OreVein2 = new RawMaterial(0, ovName2, ovNo2, "images/orevein.png","OreVein2");
            cardDeck.add(OreVein2);

            String[] guaName2 = {"Clay"};
            int[] guaNo2 = {1};
            MilitaryStructure GuardTower2 = new MilitaryStructure(1, null, null, guaName2, guaNo2, "images/guardtower.png", "GuardTower2");
            cardDeck.add(GuardTower2);

        }

    }
}
