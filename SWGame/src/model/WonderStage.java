package model;


public class WonderStage {
    private Resource[] providedResources;
    private Resource[] requiredResources;
    private VictoryPoint providedVictoryPoint;
    private MilitaryPower providedMilitaryPower;

    WonderStage(Resource[] providedResources,
                Resource[] requiredResources,
                VictoryPoint victoryPoint,
                MilitaryPower militaryPower
    ) {
        setProvidedResources(providedResources);
        setRequiredResources(requiredResources);
        setProvidedVictoryPoint(victoryPoint);
        setProvidedMilitaryPower(militaryPower);
    }
    WonderStage(WonderStage ws){
        setProvidedResources(ws.providedResources);
        setRequiredResources(ws.requiredResources);
        setProvidedVictoryPoint(ws.providedVictoryPoint);
        setProvidedMilitaryPower(ws.providedMilitaryPower);
    }

    boolean buildWonderStage() {
        System.out.println("GELDİM");
        ModelService ms = ModelService.getInstance();
       if ( ms.getCurrentPlayer().checkRequirements(null,requiredResources,null))
       {
           ms.getCurrentPlayer().updateVictoryPoints(providedVictoryPoint);
           ms.getCurrentPlayer().updateResources(providedResources);
           ms.getCurrentPlayer().updateMilitaryPower(providedMilitaryPower.getNoOfItems());
           return true;
       }
        System.out.println("CANT AFFORD");
        return false;

    }

    public Resource[] getProvidedResources() {
        return providedResources;
    }

    private void setProvidedResources(Resource[] providedResources) {
        if(providedResources != null) {
            this.providedResources = new Resource[providedResources.length];
            for (int i = 0; i < providedResources.length; i++) {
                this.providedResources[i] = providedResources[i];
            }
        }
    }

    public Resource[] getRequiredResources() {
        return requiredResources;
    }

    private void setRequiredResources(Resource[] requiredResources) {
        if(requiredResources != null) {
            this.requiredResources = new Resource[requiredResources.length];
            for (int i = 0; i < requiredResources.length; i++) {
                this.requiredResources[i] = requiredResources[i];
            }
        }
    }

    public VictoryPoint getProvidedVictoryPoint() {
        return providedVictoryPoint;
    }

    private void setProvidedVictoryPoint(VictoryPoint providedVictoryPoint) {
        this.providedVictoryPoint = providedVictoryPoint;
    }

    public MilitaryPower getProvidedMilitaryPower() {
        return providedMilitaryPower;
    }

    public void setProvidedMilitaryPower(MilitaryPower providedMilitaryPower) {
        this.providedMilitaryPower = providedMilitaryPower;
    }
}