package model;

public class MilitaryStructure extends Card {

    Resource[] requiredProducts;
    Structure requiredStructure;
    Structure providedStructure;
    ConflictPoints conflictPoints;

    public MilitaryStructure(int mf, String rSt, String pSt, String[] gPName, int[] gPNo){

        conflictPoints = new ConflictPoints(mf);
        requiredStructure = new Structure(rSt);
        providedStructure = new Structure(pSt);

        requiredProducts = new Resource[gPName.length];
        for(int i = 0; i < gPName.length; i++){

            Resource r = new Resource(gPName[i], gPNo[i]);
            requiredProducts[i] = r;
        }



    }
}
