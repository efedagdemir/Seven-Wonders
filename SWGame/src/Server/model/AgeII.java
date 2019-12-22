package Server.model;

import java.util.ArrayList;
import java.util.List;

public class AgeII extends Age {


    public AgeII() {
        cardDeck = new ArrayList<>();
    }
    @Override
    void createDeck(int numOfPlayers) {
        //Risk TRYYY
       /* Risk SWAP_VP = new Risk("risk.png", Risk.RiskEnum.SWAP_VP);
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
        cardDeck.add(c);*/


        cardDeck.clear();
        //Civilian Structures
        String [] rTemple = { "Timber", "Clay", "Glass"};
        int [] nTemple = {1,1,1};
        CivilianStructure Temple = new CivilianStructure( 3, null, "Pantheon", rTemple, nTemple,"temple.png", "Temple");
        String [] rStatue = { "Ore","Timber"};
        int [] nStatue = {2,1};
        CivilianStructure Statue = new CivilianStructure( 4, "Theatre", "Gardens", rStatue, nStatue,"statue.png", "Statue");
        String [] rAqueduct = { "Stone"};
        int [] nAqueduct = {3};
        CivilianStructure Aqueduct = new CivilianStructure( 5, null, null, rAqueduct, nAqueduct,"aqueduct.png", "Aqueduct");
        String [] chTemple = {  "Clay", "Textile"};
        int [] cTemple = {2,1};
        CivilianStructure CourtHouse = new CivilianStructure( 4, "Scriptorium", null, chTemple, cTemple,"courthouse.png", "CourtHouse");
        cardDeck.add(CourtHouse);
        cardDeck.add(Temple);
        cardDeck.add(Aqueduct);
        cardDeck.add(Statue);
        Risk COIN_VIRUS1 = new Risk("risk.png", Risk.RiskEnum.COIN_VIRUS);
        cardDeck.add(COIN_VIRUS1);
        Risk COIN_VIRUS2 = new Risk("risk.png", Risk.RiskEnum.COIN_VIRUS);   
        cardDeck.add(COIN_VIRUS2); //Commercial Structure
        CommercialStructure Bazar = new CommercialStructure(4 , 0, null, null, true, true, null, "bazar.png", "Bazar");
        cardDeck.add(Bazar);
        CommercialStructure VineYard = new CommercialStructure(1 , 0, null, null, true, true, null, "vineyard.png", "Vineyard");
        cardDeck.add(VineYard);

        //Raw Material
        String[]byName = {"Clay"};
        int[] byNo = {2};
        RawMaterial BrickYard = new RawMaterial(1, byName,byNo, "brickyard.png", "BrickYard");
        String[]fName = {"Ore"};
        int[] fNo = {2};
        RawMaterial Foundry = new RawMaterial(1, fName, fNo, "foundry.png", "Foundry");
        String[]qName = {"Stone"};
        int[] qNo = {2};
        RawMaterial Quarry = new RawMaterial(1, qName, qNo, "quarry.png", "Quarry");
        cardDeck.add(Quarry);
        cardDeck.add(Foundry);
        cardDeck.add(BrickYard);
        Risk COIN_DONATION = new Risk("risk.png", Risk.RiskEnum.COIN_DONATION);
        Risk COIN_VIRUS = new Risk("risk.png", Risk.RiskEnum.COIN_VIRUS);
        cardDeck.add(COIN_DONATION);
        cardDeck.add(COIN_VIRUS);
        //Military Structure
        String[] guaName2 = {"Stone"};
        int[] guaNo2 = {3};
        MilitaryStructure Walls = new MilitaryStructure(2, null, "Fortifications", guaName2, guaNo2, "walls.png", "Walls");
        String[] sName2 = {"Clay", "Timber","Ore"};
        int[] sNo2 = {1,1,1};
        MilitaryStructure Stables = new MilitaryStructure(2, "Apothecary", null, sName2, sNo2, "stables.png", "Stables");
        String[] arName2 = {"Ore", "Timber"};
        int[] arNo2 = {1,2};
        MilitaryStructure ArcheryRange = new MilitaryStructure(2, null, null, arName2, arNo2, "archeryrange.png", "ArcheryRange");

        String[] tgName2 = {"Ore", "Timber"};
        int[] tgNo2 = {2,1};
        MilitaryStructure TrainingGround = new MilitaryStructure(2, null, "Circus", tgName2, tgNo2, "trainingground.png", "TrainingGround");
        cardDeck.add(Walls);
        cardDeck.add(TrainingGround);
        cardDeck.add(ArcheryRange);
        cardDeck.add(Stables);
        //Scientific Structures
        String[] scName = {"Papyrus","Timber"};
        int[] scNo = {1, 1};
        String[] pName = {"Academy", "Study"};
        ScientificStructure School = new ScientificStructure("Tomb", null, scName, scNo, pName, "school.png", "School");
        String[] lbName = {"Papyrus","Clay"};
        int[] lbNo = {1, 2};
        String[] plbName = {"Observatory", "Siege Workshop"};
        ScientificStructure Laboratory = new ScientificStructure("Cog", null, lbName, lbNo, plbName, "laboratory.png", "Laboratory");
        String[] lbrName = {"Textile","Stone"};
        int[] lbrNo = {1, 2};
        String[] plbrName = {"Senate", "University"};
        ScientificStructure Library = new ScientificStructure("Tomb", null, lbrName, lbrNo, plbrName, "library.png", "Library");
        cardDeck.add(Library);
        cardDeck.add(Laboratory);
        cardDeck.add(School);
        //Manufactured Good
        String[]  prGivenP = {"Papyrus"};
        int[] prGivenNo = {1};
        String[] prReqP = {};
        int[] prReqNo = {};
        ManufacturedGood Press = new ManufacturedGood(prGivenP, prGivenNo, prReqP, prReqNo, "press.png", "Press");
        String[]  gwGivenP = {"Glass"};
        int[] gwGivenNo = {1};
        String[] gwReqP = {};
        int[] gwReqNo = {};
        //ManufacturedGood GlassWorks = new ManufacturedGood(gwGivenP, gwGivenNo, gwReqP, gwReqNo, "glassworks.png", "Glassworks");
        String[]  lGivenP = {"Textile"};
        int[] lGivenNo = {1};
        String[] lReqP = {};
        int[] lReqNo = {};
        ManufacturedGood Loom = new ManufacturedGood(lGivenP, lGivenNo, lReqP, lReqNo, "loom.png", "Loom");
        cardDeck.add(Press);
        //cardDeck.add(GlassWorks);
        cardDeck.add(Loom);
    }

    @Override
    public List<Card> getCardDeck() {
        return cardDeck;
    }
}
