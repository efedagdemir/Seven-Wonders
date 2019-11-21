package model;


public class WonderStage {
    private Resource[] providedResources;
    private Resource[] requiredResources;
    private VictoryPoint providedVictoryPoint;
    private ConflictPoint providedConflictPoints;

    WonderStage(Resource[] providedResources,
                Resource[] requiredResources,
                VictoryPoint victoryPoint,
                ConflictPoint conflictPoints
    ) {
        setProvidedResources(providedResources);
        setRequiredResources(requiredResources);
        setProvidedVictoryPoint(victoryPoint);
        setProvidedConflictPoints(conflictPoints);
    }
    WonderStage(WonderStage ws){
        setProvidedResources(ws.providedResources);
        setRequiredResources(ws.requiredResources);
        setProvidedVictoryPoint(ws.providedVictoryPoint);
        setProvidedConflictPoints(ws.providedConflictPoints);
    }

    void buildWonderStage() {
        //TODO(need other classes to add wonder attributes to the player)
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

    public ConflictPoint getProvidedConflictPoints() {
        return providedConflictPoints;
    }

    public void setProvidedConflictPoints(ConflictPoint providedConflictPoints) {
        this.providedConflictPoints = providedConflictPoints;
    }
}