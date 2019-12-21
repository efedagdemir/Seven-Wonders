package Server.model;


import java.sql.SQLOutput;

public class WonderStage {
    private Resource[] providedResources;
    private Resource[] requiredResources;
    private VictoryPoint providedVictoryPoint;
    private MilitaryPower providedMilitaryPower;
    private boolean built;

    WonderStage(Resource[] providedResources,
                Resource[] requiredResources,
                VictoryPoint victoryPoint,
                MilitaryPower militaryPower
    ) {
        setProvidedResources(providedResources);
        setRequiredResources(requiredResources);
        setProvidedVictoryPoint(victoryPoint);
        setProvidedMilitaryPower(militaryPower);
        built = false;
    }

    WonderStage(WonderStage ws) {
        setProvidedResources(ws.providedResources);
        setRequiredResources(ws.requiredResources);
        setProvidedVictoryPoint(ws.providedVictoryPoint);
        setProvidedMilitaryPower(ws.providedMilitaryPower);
        built = false;
    }

    void buildWonderStage(Player player) {
        System.out.println("GELDİM");
        for (int i = 0; i < player.getCurrentResources().size(); i++){
            System.out.println("Player's resources:" + player.getCurrentResources().get(i).getResourceName());
        }
        for (int i = 0; i < requiredResources.length; i++){
            System.out.println("required resources: " + requiredResources[i].getResourceName());
        }
        if (player.checkRequirements(null, requiredResources, null)) {
            player.updateVictoryPoints(providedVictoryPoint);
            player.updateResources(providedResources);
            player.updateMilitaryPower(providedMilitaryPower == null ? 0 : providedMilitaryPower.getNoOfItems());
            built = true;
        }
        System.out.println("CANT AFFORD");
    }

    void riskBuildWonderStage(){
        ModelService ms = ModelService.getInstance();
        ms.getChosenPlayer().updateVictoryPoints(providedVictoryPoint);
        ms.getChosenPlayer().updateResources(providedResources);
        ms.getChosenPlayer().updateMilitaryPower(providedMilitaryPower == null ? 0 : providedMilitaryPower.getNoOfItems());
        built = true;
    }

    public Resource[] getProvidedResources() {
        return providedResources;
    }

    private void setProvidedResources(Resource[] providedResources) {
        if (providedResources != null) {
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
        if (requiredResources != null) {
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

    public boolean isBuilt() {
        return built;
    }
}