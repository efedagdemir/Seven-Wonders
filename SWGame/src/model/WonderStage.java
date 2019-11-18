package model;


class WonderStage {
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

    void buildWonderStage() {
        //TODO(need other classes to add wonder attributes to the player)
    }

    public Resource[] getProvidedResources() {
        return providedResources;
    }

    private void setProvidedResources(Resource[] providedResources) {
        this.providedResources = providedResources;
    }

    public Resource[] getRequiredResources() {
        return requiredResources;
    }

    private void setRequiredResources(Resource[] requiredResources) {
        this.requiredResources = requiredResources;
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