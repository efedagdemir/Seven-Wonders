package model;

public class ScientificStructure extends Card {

    Structure requiredS;
    Resource[] requiredP;
    Structure[] providedS;
    String type;

        public ScientificStructure(String t, String rS, String[] rName, int[] rNo, String[] pS){
        type = t;
        requiredS = new Structure(rS);

        requiredP = new Resource[rName.length];
        for (int i = 0; i < rName.length; i++ ){
            Resource a = new Resource(rName[i], rNo[i]);
            requiredP[i] = a;
        }

        providedS = new Structure[pS.length];
        for (int i = 0; i < pS.length; i++ ){
            Structure b = new Structure(pS[i]);
            providedS[i] = b;
        }


    }
}
