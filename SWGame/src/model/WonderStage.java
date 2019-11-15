package model;


class WonderStage {
    private Resource[] providedResources;
    private Resource[] requiredResources;
    private VictoryPoints providedVictoryPoints;
    private ConflictPoints providedConflictPoints;

    WonderStage(Resource[] providedResources,
                Resource[] requiredResources,
                VictoryPoints victoryPoints,
                ConflictPoints conflictPoints
    ) {
        setProvidedResources(providedResources);
        setRequiredResources(requiredResources);
        setProvidedVictoryPoints(victoryPoints);
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

    public VictoryPoints getProvidedVictoryPoints() {
        return providedVictoryPoints;
    }

    private void setProvidedVictoryPoints(VictoryPoints providedVictoryPoints) {
        this.providedVictoryPoints = providedVictoryPoints;
    }

    public ConflictPoints getProvidedConflictPoints() {
        return providedConflictPoints;
    }

    public void setProvidedConflictPoints(ConflictPoints providedConflictPoints) {
        this.providedConflictPoints = providedConflictPoints;
    }
}