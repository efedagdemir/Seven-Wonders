package model;

//
//import java.util.ArrayList;
//
class Player {
//    String name = " as";
//    Resource[] currentResources;
//    Item currentCoin;
//    WonderBoard wonder;
//    Item victoryPoints;
//    //Card[] hand;
//    Item conflictPoints;
//
//
//    Player leftNeighbor;
//    Player rightNeighbor;
//    //Resource[] discountedResourcesLeft;
//    //Resource[] discountedResourcesRight;
//    //Card[] freeStructures;
//    int militaryPower;
//    ScientificStructure[] scienceStructures;
//    //Item[] itemList:
//
//    public Player(String name, int coinAmount, WonderBoard wonder) {
//        this.name = name;
//        this.militaryPower = 0;
//        this.wonder = wonder;
//        currentCoin = new Coin(coinAmount);
//        victoryPoints = new VictoryPoint(0);
//        conflictPoints = new ConflictPoints(0);
//
//
//        ArrayList<Card> hand = new ArrayList<Card>();
//        ArrayList<Resource> discountedResourcesLeft = new ArrayList<Resource>();
//        ArrayList<Resource> discountedResourcesRight = new ArrayList<Resource>();
//        ArrayList<Card> freeStructures = new ArrayList<Card>();
//        ArrayList<Structure> scientificStructures = new ArrayList<Structure>();
//        ArrayList<Item> itemList = new ArrayList<Item>();
//        ArrayList<Resource> currentResources = new ArrayList<Resource>();
//
//
//        currentResources.add(wonder.getProducedResource);
//        updateItemList();
//        itemList.add(wonder.getProducedResource());
//
//    }
//
//    //Increments the resources of the player according to the cards the player takes.
//    void updateResources(Card card){
//
//    }
//
//    //Updates the current coin of the player according to the actions taken.
//    void updateCoin(int coinAmount){
//        currentCoin.setCoinAmount(coinAmount);
//    }
//
//    //Updates the current victory points of the player according to the cards taken
//    // and according to the wonders built
//    void updateVictoryPoints(Card card){
//
//    }
//
//    void updateVictoryPoints(WonderStage wonder){
//
//    }
//
//
//
//    //Updates the current scientific structures of the player according to the cards taken.
//    void updateScientificStructures(Card card){
//
//    }
//
//    //Updates the current free structures of the player according to the cards taken.
//    void updateFreeStructures(Card card){
//
//    }
//
//    //Looks if the given card is free for the player.
//    boolean isFree(Card card){
//
//    }
//
//    //Looks if the player can afford to build the given card.
//    boolean checkRequirements(Card card){
//
//    }
//
//    //Adds the built card to the hand of the player.
//    void updateHand(Card card){
//
//    }
//
//    // Looks at the conflict points of both of the neighbors
//    // and then compares them with the player’s conflict point.
//    // Then according to the comparisons made, updates the conflict points of the player.
//    void updateConflictPoints(Age age){
//        Player player1 = this.getLeftNeighbor();
//        int player1W = player1.getMilitaryPower();
//
//        Player player2 = this.getRightNeighbor();
//        int playe2W = player2.getMilitaryPower();
//
//        int agePoint = 1;
//        int lost = -1;
//        if(age instanceof AgeII)){
//            agePoint = 3;
//        }
//        else if(age instanceof AgeIII){
//            agePoint = 5;
//        }
//
//        //compare with left neighbor
//        if(player1W > this.getMilitaryPower()){
//            this.conflictPoints.setNoOfItems(lost);
//        }
//
//        if(player1W < this.getMilitaryPower()){
//            this.conflictPoints.setNoOfItems(agePoint);
//        }
//
//        if(player2W > this.getMilitaryPower()){
//            this.conflictPoints.setNoOfItems(lost);
//        }
//
//        if(player2W < this.getMilitaryPower()){
//            this.conflictPoints.setNoOfItems(agePoint);
//        }
//
//    }
//
//    //Creates the player object.
//    Player createPlayer(String name, int coinAmount, WonderBoard wonder){
//        Player player = new Player()String name, int coinAmount, WonderBoard wonder);
//        return player;
//    }
//
//    //Updates the military power of the player according to the cards taken.
//    void updateMilitaryPower(Card card){
//
//    }
//
//    void updateItemList(Resource resource){
//        bool exists = false;
//        for(int i = 0; i < itemList.size(); i++){
//            if(itemList[i] instanceof Resource){
//                if(itemList[i].getResourceName().equals(resource.getResourceName())) {
//                    itemList[i].setNoOfItems(resource.getNoOfItems());
//                    exists = true;
//                }
//            }
//        }
//        if(!exists){
//            itemList.add(resource);
//        }
//
//    }
//
//
//    void updateItemList(Item item){
//
//
//    }
//
//
//
//    public void setLeftNeighbor(model.Player leftNeighbor) {
//        this.leftNeighbor = leftNeighbor;
//    }
//
//
//    public void setRightNeighbor(model.Player rightNeighbor) {
//        this.rightNeighbor = rightNeighbor;
//    }
//
//    public model.Player getRightNeighbor() {
//        return rightNeighbor;
//    }
//
//    public model.Player getLeftNeighbor() {
//        return leftNeighbor;
//    }
//
//    public Resource[] getCurrentResources() {
//        return currentResources;
//    }
//
//    public Item getCurrentCoin() {
//        return currentCoin;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public WonderBoard getWonder() {
//        return wonder;
//    }
//
//    public Item getVictoryPoints() {
//        return victoryPoints;
//    }
//
//    public Item getConflictPoints() {
//        return conflictPoints;
//    }
//
//    public int getMilitaryPower() {
//        return militaryPower;
//    }
//
//    public ScientificStructure[] getScienceStructures() {
//        return scienceStructures;
//    }
}