package model;

class AgeI extends Age {

    @Override
    void createDeck(int numOfPlayers) {

        /*Civilian Structures */

        CivilianStructure Altar = new CivilianStructure(2, null, "Temple", null, 0, "images/altar.png.url");
        CivilianStructure Theater = new CivilianStructure(2, null, "Statue", null, 0,"images/theater.png.url");
        CivilianStructure Baths = new CivilianStructure(3, null, "Aqueduct", "Stone", 1,"images/altar.png.url" );

        /*Commercial Structures*/
        String[] mpResNames = {"Glass", "Textile", "Papyrus"}; //resource names present in Marketplace
        CommercialStructure Marketplace = new CommercialStructure( 0, 0, null, "Caravansery", true, true, mpResNames, "images/marketplace.png.url");
        String[] tpResNames = {"Clay", "Stone", "Timber", "Ore"}; //resource names present in TradingPost's
        CommercialStructure EastTradingPost = new CommercialStructure( 0, 0, null, "Forum", false, true, tpResNames, "images/easttradingpost.png.url");
        CommercialStructure WestTradingPost = new CommercialStructure( 0, 0, null, "Forum", true, false, tpResNames, "images/westtradingpost.png.url");

        /*Manufactured Goods*/
        String[]  lGivenP = {"Textile"};
        int[] lGivenNo = {1};
        String[] lReqP = {};
        int[] lReqNo = {};
        ManufacturedGood Loom = new ManufacturedGood(lGivenP, lGivenNo, lReqP, lReqNo, "images/loom.png.url");

        String[]  prGivenP = {"Papyrus"};
        int[] prGivenNo = {1};
        String[] prReqP = {};
        int[] prReqNo = {};
        ManufacturedGood Press = new ManufacturedGood(prGivenP, prGivenNo, prReqP, prReqNo, "images/press.png.url");

        String[]  gwGivenP = {"Glass"};
        int[] gwGivenNo = {1};
        String[] gwReqP = {};
        int[] gwReqNo = {};
        ManufacturedGood Glassworks = new ManufacturedGood(gwGivenP, gwGivenNo, gwReqP, gwReqNo, "images/glassworks.png.url");

        /*Scientific Structures*/
        String[] scName = {"Papyrus"};
        int[] scNo = {1};
        String[] pName = {"Courthouse", "Library"};
        ScientificStructure Scriptorium = new ScientificStructure("Tomb", null, scName, scNo, pName, "images/scriptorium.png.url");

        String[] wName = {"Glass"};
        int[] wNo = {1};
        String[] wpName = {"Laboratory", "ArcheryRange"};
        ScientificStructure Workshop = new ScientificStructure("Cog",null, wName, wNo, wpName, "images/workshop.png.url");

        String[] apName = {"Textile"};
        int[] apNo = {1};
        String[] paName = {"Stables", "Dispensary"};
        ScientificStructure Apothecary = new ScientificStructure("Ruler", null, apName, apNo, paName, "images/apothecary.png.url");

        /*Raw Materials*/
        String[] cpName = {"Clay"};
        int[] cpNo = {1};
        RawMaterial ClayPool = new RawMaterial(0, cpName, cpNo, "images/claypool.png.url");

        String[] ovName = {"Ore"};
        int[] ovNo = {1};
        RawMaterial OreVein = new RawMaterial(0, ovName, ovNo, "images/orevein.png.url");

        String[] tyName = {"Stone, Timber"};
        int[] tyNo = {1,1};
        RawMaterial TimberYard = new RawMaterial(1, tyName, tyNo, "images/timberyard.png.url");

        String[] spName = {"Stone"};
        int[] spNo = {1};
        RawMaterial StonePit = new RawMaterial(0, spName, spNo, "images/stonepit.png.url");

        String[] lyName = {"Timber"};
        int[] lyNo = {1};
        RawMaterial LumberYard = new RawMaterial(0, lyName, lyNo, "images/lumberyard.png.url");

        String[] cpitName = {"Clay", "Ore"};
        int[] cpitNo = {1,1};
        RawMaterial ClayPit = new RawMaterial(1, cpitName, cpitNo, "images/claypit.png.url" );

        /*Military Structures*/




        if (numOfPlayers == 4) {

            CivilianStructure Pawnshop = new CivilianStructure(3, null, null, null, 0, "images/pawnshop.png.url");
            String[] tavernS = {""};
            CommercialStructure Tavern = new CommercialStructure(0, 5, null, null, false, false, tavernS, "images/tavern.png.url");

            String[] scName2 = {"Papyrus"};
            int[] scNo2 = {1};
            String[] pName2 = {"Courthouse", "Library"};
            ScientificStructure Scriptorium2 = new ScientificStructure("Tomb", null, scName2, scNo2, pName2, "images/scriptorium.png.url");

            /*Raw Materials*/
            String[] lyName2 = {"Timber"};
            int[] lyNo2 = {1};
            RawMaterial LumberYard2 = new RawMaterial(0, lyName2, lyNo2, "images/lumberyard.png.url");

            String[] exName = {"Stone", "Clay"};
            int[] exNo = {1,1};
            RawMaterial Excavation = new RawMaterial(1, exName, exNo, "images/excavation.png.url");

            String[] ovName2 = {"Ore"};
            int[] ovNo2 = {1};
            RawMaterial OreVein2 = new RawMaterial(0, ovName2, ovNo2, "images/orevein.png.url");


        }

    }
}
