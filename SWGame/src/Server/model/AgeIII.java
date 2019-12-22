package Server.model;

import java.util.ArrayList;
import java.util.List;

public class AgeIII extends Age {

    public AgeIII() {
        cardDeck = new ArrayList<>();
        name = "Age 3";
    }


    @Override
    void createDeck(int numOfPlayers) {

        String [] rTemp = { "Timber", "Stone", "Ore"};
        int [] nTemp = {2,1,1};
        CivilianStructure Senate = new CivilianStructure( 6, "Library", null, rTemp, nTemp,"senate.png", "Senate");        //Civilian Structures
        String [] pTemp = { "Timber", "Stone", "Ore","Clay","Glass","Textile","Papyrus"};
        int [] npTemp = {1,1,1,1,1,1,1};
        CivilianStructure Palace = new CivilianStructure( 8, null, null, pTemp, npTemp,"palace.png", "Palace");
        String [] rtTemp = { "Glass", "Stone", "Ore"};
        int [] ntTemp = {1,2,1};
        CivilianStructure TownHall = new CivilianStructure( 6, null, null, rtTemp, ntTemp,"townhall.png", "Townhall");
        String [] gTemp = { "Clay","Timber"};
        int [] ngTemp = {2,1};
        CivilianStructure Gardens = new CivilianStructure( 5, "Statue", null, gTemp, ngTemp,"gardens.png", "Gardens");
        String [] paTemp = {  "Ore","Clay","Glass","Textile","Papyrus"};
        int [] npaTemp = {1,2,1,1,1};
        CivilianStructure Pantheon = new CivilianStructure( 7, "Temple", null, paTemp, npaTemp,"pantheon.png", "Pantheon");
        cardDeck.add(Senate);
        cardDeck.add(Palace);
        cardDeck.add(TownHall);
        cardDeck.add(Gardens);
        cardDeck.add(Pantheon);
        //Guild
        /*String [] tReq = {"Glass", "Textile", "Papyrus"};
        int [] nReq = {1,1,1};
        Guild TradersGuild = new Guild(1, null,tReq,nReq, "tradersguild.png", "TradersGuild");
        String [] twReq = {"Ore", "Clay", "Stone","Timber"};
        int [] nwReq = {2,1,1,1};
        Guild WorkersGuild = new Guild(1, null,twReq,nwReq, "workersguild.png", "WorkersGuild");
        String [] tcReq = {"Ore", "Stone"};
        int [] ncReq = {2,2};
        Guild CraftmensGuild = new Guild(2, null,tcReq,ncReq, "craftmensguild.png", "CraftmensGuild");

        String [] tsgReq = {"Clay","Glass"};
        int [] nsgReq = {3,1};
        Guild SpiesGuild = new Guild(1, null,tsgReq,nsgReq, "spiesguild.png", "SpiesGuild");
        String [] tpReq = {"Clay","Papyrus","Textile"};
        int [] npReq = {3,1,1};
        Guild PhilosophersGuild = new Guild(1, null,tpReq,npReq, "philosophersguild.png", "PhilosophersGuild");
        String [] sgReq = {"Timber","Papyrus","Papyrus"};
        int [] sReq = {3,1,1};
        Guild ShipownersGuild = new Guild(3, null,sgReq,sReq, "shipownersguild.png", "ShipownersGuild");
        String [] mReq = {"Timber","Stone","Textile"};
        int [] nmReq = {3,1,1};
        Guild MagistratesGuild = new Guild(1, null,mReq,nmReq, "magistratesguild.png", "MagistratesGuild");
        cardDeck.add(TradersGuild);
        cardDeck.add(WorkersGuild);
        cardDeck.add(CraftmensGuild);
        cardDeck.add(SpiesGuild);
        cardDeck.add(PhilosophersGuild);
        cardDeck.add(ShipownersGuild);
        cardDeck.add(MagistratesGuild);

         */

        String [] sgReq = {"Timber", "Ore", "Papyrus"};
        int [] snReq = {2,2,1};
        Guild scientistGuild = new Guild(1, null,sgReq,snReq, "scientistguild.png", "ScientistGuild");
        cardDeck.add(scientistGuild);

        String [] tbReq = {"Glass", "Stone", "Clay"};
        int [] nbReq = {1,2,2};
        Guild BuildersGuild = new Guild(1, null,tbReq,nbReq, "buildersguild.png", "BuildersGuild");
        cardDeck.add(BuildersGuild);
        String [] tsReq = {"Ore", "Stone","Textile"};
        int [] nsReq = {2,1,1};
        Guild StrategistsGuild = new Guild(1, null,tsReq,nsReq, "strategistsguild.png", "StrategistsGuild");
        cardDeck.add(StrategistsGuild);

        //Risk
        //Risk SWAP_VP = new Risk("risk.png", Risk.RiskEnum.SWAP_VP);
        //cardDeck.add(SWAP_VP);
       // Risk COIN_DONATION = new Risk("risk.png", Risk.RiskEnum.COIN_DONATION);
        //Risk COIN_VIRUS = new Risk("risk.png", Risk.RiskEnum.COIN_VIRUS);
        //cardDeck.add(COIN_DONATION);
        //cardDeck.add(COIN_VIRUS);
        //Risk SWAP_VP2 = new Risk("risk.png", Risk.RiskEnum.SWAP_VP);
        //cardDeck.add(SWAP_VP2);
        Risk SWAP_VP3 = new Risk("risk.png", Risk.RiskEnum.SWAP_VP);
        cardDeck.add(SWAP_VP3);
        //Risk a = new Risk("risk.png", Risk.RiskEnum.WS_BUILDER);
        Risk b = new Risk("risk.png", Risk.RiskEnum.WS_BUILDER);
        //Risk c = new Risk("risk.png", Risk.RiskEnum.WS_BUILDER);
        // cardDeck.add(a);
        cardDeck.add(b);
        //cardDeck.add(c);

        //Military Structure
        String[] sName2 = {"Clay", "Timber"};
        int[] sNo2 = {3,1};
        MilitaryStructure SiegeWorkshop = new MilitaryStructure(3, "Laboratory", null, sName2, sNo2, "siegeworkshop.png", "Siegeworkshop");
        String[] aName2 = {"Ore", "Timber","Textile"};
        int[] aNo2 = {1,2,1};
        MilitaryStructure Arsenal = new MilitaryStructure(3, null, null, aName2, aNo2, "arsenal.png", "Arsenal");
        String[] fName2 = {"Ore", "Stone"};
        int[] fNo2 = {3,1};
        MilitaryStructure Fortifications = new MilitaryStructure(3, "Walls", null, fName2, fNo2, "fortifications.png", "Fortifications");
        cardDeck.add(SiegeWorkshop);
        cardDeck.add(Arsenal);
        cardDeck.add(Fortifications);
        //ScientificStructure
        String[] oName = {"Ore","Glass", "Textile"};
        int[] oNo = {2,1, 1};
        ScientificStructure Observatory = new ScientificStructure("Cog", null, oName, oNo, null, "observatory.png", "Observatory");
        String[] sName = {"Timber","Papyrus", "Textile"};
        int[] sNo = {1,1, 1};
        ScientificStructure Study = new ScientificStructure("Cog", "School", sName, sNo, null, "study.png", "Study");
        String[] aName = {"Stone","Glass"};
        int[] aNo = {3,1};
        ScientificStructure Academy = new ScientificStructure("Ruler", "School", aName, aNo, null, "academy.png", "Academy");
        String[] uName = {"Timber","Glass", "Papyrus"};
        int[] uNo = {2,1, 1};
        ScientificStructure University = new ScientificStructure("Tomb", "Library", uName, uNo, null, "university.png", "University");
        String[] lName = {"Clay","Papyrus", "Textile"};
        int[] lNo = {2,1, 1};
        ScientificStructure Lodge = new ScientificStructure("Ruler", "Dispensary", lName, lNo, null, "lodge.png", "Lodge");
        cardDeck.add(Observatory);
        cardDeck.add(University);
        cardDeck.add(Academy);
        cardDeck.add(Study);
        cardDeck.add(Lodge);

        //CommercialStructure
        //Required resources
        CommercialStructure Arena = new CommercialStructure(1 , 3, "Dispensary", null, false, false, null, "arena.png", "Arena");
        CommercialStructure LightHouse= new CommercialStructure(1 , 1, "Caravansery", null, false, false, null, "lighthouse.png", "Lighthouse");
        CommercialStructure Haven= new CommercialStructure(1 , 1, "Forum", null, false, false, null, "haven.png", "Haven");
        cardDeck.add(LightHouse);
        cardDeck.add(Arena);
        cardDeck.add(Haven);
    }

    @Override
    public List<Card> getCardDeck() {
        return cardDeck;
    }
}