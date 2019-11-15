package model;
import java.util.ArrayList;

class AgeI extends Age {

    @Override
    void createDeck(int numOfPlayers) {


        CivilianStructure Altar = new CivilianStructure(2, null, "Temple", null, 0);
        CivilianStructure Theater = new CivilianStructure(2, null, "Statue", null, 0);
        CivilianStructure Baths = new CivilianStructure(3, null, "Aqueduct", "Stone", 1 );

        if (numOfPlayers == 4){

            CivilianStructure Pawnshop = new CivilianStructure(3, null, null, null, 0);

        }
    }
}
