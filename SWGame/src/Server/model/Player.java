package Server.model;

import Client.ClientController.ClientControllerFacade;

import java.util.ArrayList;

public class Player {
    String name;
    Coin currentCoin;
    WonderBoard wonder;
    VictoryPoint victoryPoints;
    //Card[] hand;
    ConflictPoint conflictPoints;
    int finalPoint;
    ArrayList<Item> itemList;
    int leftNeighbor;
    int rightNeighbor;
    MilitaryPower militaryP;



    ArrayList<Card> hand;
    ArrayList<Resource> discountedResources;
    ArrayList<ScientificType> scientificTypes;
    ArrayList<Resource> currentResources;
    ArrayList<Structure> freeStructures;
    public Age currentAge;

    public Player(String name, int coinAmount) {
        this.name = name;
        currentCoin = new Coin(coinAmount, "coin.png");
        victoryPoints = new VictoryPoint(0);
        conflictPoints = new ConflictPoint(0);
        finalPoint = 0;
        militaryP = new MilitaryPower(0);
        currentAge = new AgeI();
        hand = new ArrayList<>();
        discountedResources = new ArrayList<>();
        freeStructures = new ArrayList<>();
        scientificTypes = new ArrayList<>();
        itemList = new ArrayList<>();
        currentResources = new ArrayList<>();
        updateItemList(currentCoin);
        updateItemList(militaryP);
    }

    void updateItemList(Resource resource) {
        boolean exists = false;
        Resource type;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i) instanceof Resource) {
                type = (Resource) itemList.get(i);
                if (type.getResourceName().equals(resource.getResourceName())) {
//                    itemList.get(i).setNoOfItems(resource.getNoOfItems());
                    exists = true;
                }
            }
        }
        if (!exists) {
            itemList.add(resource);
        }

    }

    void updateItemList(VictoryPoint vc) {
        boolean exists = false;

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i) instanceof VictoryPoint) {
                itemList.set(i, vc);
                exists = true;
            }
        }
        if (!exists) {
            itemList.add(vc);
        }

    }

    void sealResources(){
        if (currentResources.size() != 0){
            currentResources.remove(0);
            return;
        }
        return;
    }

    void updateItemList(MilitaryPower milit) {
        boolean exists = false;

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i) instanceof MilitaryPower) {
                itemList.set(i, milit);
                exists = true;
            }
        }
        if (!exists) {
            itemList.add(milit);
        }

    }

    void updateItemList(ConflictPoint cp) {
        boolean exists = false;

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i) instanceof ConflictPoint) {
                itemList.set(i, cp);
                exists = true;

            }
        }
        if (!exists) {
            itemList.add(cp);
        }
    }

    void updateItemList(ScientificType scType) {
        boolean exists = false;
        ScientificType type;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i) instanceof ScientificType) {
                type = (ScientificType) itemList.get(i);
                if (type.getScientificType().equals(scType.getScientificType())) {
                    itemList.get(i).setNoOfItems(i);
                    exists = true;
                }
            }
        }
        if (!exists) {
            itemList.add(scType);
        }
    }

    void updateItemList(Coin coin) {
        boolean exists = false;

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i) instanceof Coin) {
                itemList.set(i, coin);
                exists = true;

            }
        }
        if (!exists) {
            itemList.add(coin);
        }

    }

    //Increments the resources of the player according to the cards the player takes.
    void updateResources(Resource[] resourceArr) {
        if (resourceArr == null)
            return;
        for (int i = 0; i < resourceArr.length; i++) {
            boolean exists = false;
            for (int j = 0; j < currentResources.size(); j++) {
                if (resourceArr[i].getResourceName().equals(currentResources.get(j).getResourceName())) {
                    exists = true;
                    currentResources.get(j).setNoOfItems(resourceArr[i].getNoOfItems());
                }
            }
            if (!exists) {
                currentResources.add(resourceArr[i]);
            }
        }
        for (int i = 0; i < resourceArr.length; i++) {
            updateItemList(resourceArr[i]);
        }
    }

    //Updates the current coin of the player according to the actions taken.
    public boolean addCoin(int coinAmount) {
        if (currentCoin.getNoOfItems() + coinAmount < 0)
            return false;

        currentCoin.setNoOfItems(coinAmount);
        updateItemList(currentCoin);
        return true;
    }

    public void setCurrentCoin(Coin currentCoin) {
        this.currentCoin = currentCoin;
    }

    public void setVictoryPoints(VictoryPoint victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    public void setMilitaryP(MilitaryPower militaryP) {
        this.militaryP = militaryP;
    }

    public boolean coinRisk(int coinAmount){
        currentCoin.setNoOfItems(coinAmount);
        updateItemList(currentCoin);
        return true;
    }

    //Updates the current victory points of the player according to the cards taken
    // and according to the wonders built
    void updateVictoryPoints(VictoryPoint vc) {
        if (vc != null){
        victoryPoints.setNoOfItems(vc.getNoOfItems());
        updateItemList(victoryPoints);}
    }

    void updateVictoryPoints(WonderStage wonder) {
    }


    //Updates the current scientific structures of the player according to the cards taken.
    void updateScientifictType(ScientificType scType) {
        if (scType == null)
            return;
        boolean exists = false;
        int k = 0;
        for (int i = 0; i < scientificTypes.size(); i++) {
            if (scType.getScientificType().equals(scientificTypes.get(i).getScientificType())) {
                scientificTypes.get(i).setNoOfItems(k);
                exists = true;
            }
        }
        if (!exists) {
            scientificTypes.add(scType);
        }
        updateItemList(scType);
    }

    void updateMilitaryPower(int military) {
        if (military == 0)
            return;
        militaryP.setNoOfItems(military);
        updateItemList(militaryP);
    }

    //Updates the current free structures of the player according to the cards taken.
    void updateFreeStructures(Structure s) {
        if (s == null)
            return;
        freeStructures.add(s);
        itemList.add(s);
    }

    void updateFreeStructures(Structure[] s) {
        if (s == null)
            return;
        for (int i = 0; i < s.length; i++) {
            freeStructures.add(s[i]);
            itemList.add(s[i]);
        }
    }

    //Looks if the given card is free for the player.
    boolean isFree(Card card) {
        Structure s;
        boolean free = false;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i) instanceof Structure) {
                s = (Structure) itemList.get(i);
                if (s.getType().equals(card.getName())) {
                    free = true;
                    return free;
                }
            }
        }
        return free;
    }

    //Looks if the player can afford to build the given card.
    boolean checkRequirements(Structure requiredStructure, Resource[] requiredResource, Coin requiredCoin) {
        boolean affordS = true;
        boolean affordR = true;
        boolean affordC = true;
        if (requiredStructure != null) {
            affordS = false;
            for (int i = 0; i < freeStructures.size(); i++) {
                if (freeStructures.get(i).getType().equals(requiredStructure.getType())) {
                    affordS = true;
                }
            }
        }
        int count = 0;
        if (requiredResource != null) {
            affordR = false;

            for (int i = 0; i < requiredResource.length; i++) {
                for (int j = 0; j < currentResources.size(); j++) {
                    if (requiredResource[i].getResourceName().equals(currentResources.get(j).getResourceName())) {
                        count++;
                    }
                }
            }
            if (count == requiredResource.length) {
                affordR = true;
            }
        }

        if (requiredCoin != null) {
            affordC = requiredCoin.getNoOfItems() <= currentCoin.getNoOfItems();
        }

        return (affordC && affordR ) || affordS;
    }

    /*This method updates the current player's coin amount by three. */
    public void sellCard( Player player,Card[] cards) {
        player.currentCoin.setNoOfItems(3);
        ModelService.getInstance().removeFromRotatingCardList(cards);

    }

    //Adds the built card to the hand of the player.
    void updateHand(Card card) {
        hand.add(card);
    }

    // Looks at the conflict points of both of the neighbors
    // and then compares them with the player’s conflict point.
    // Then according to the comparisons made, updates the conflict points of the player.
    void updateConflictPoints(Age currentAge) {
        Player player1 = this.getLeftNeighbor();
        int player1W = player1.getMilitaryPower().getNoOfItems();

        Player player2 = this.getRightNeighbor();
        int player2W = player2.getMilitaryPower().getNoOfItems();

        int agePoint = 1;
        int lost = -1;
        if ( currentAge instanceof AgeII) {
            agePoint = 3;
            currentAge = new AgeIII();
        }
        else if (currentAge instanceof AgeIII) {
            agePoint = 5;
        }

        //compare with left neighbor
        if (player1W > this.getMilitaryPower().getNoOfItems()) {
            this.conflictPoints.setNoOfItems(lost);
        }

        if (player1W < this.getMilitaryPower().getNoOfItems()) {
            this.conflictPoints.setNoOfItems(agePoint);
        }

        if (player2W > this.getMilitaryPower().getNoOfItems()) {
            this.conflictPoints.setNoOfItems(lost);
        }

        if (player2W < this.getMilitaryPower().getNoOfItems()) {
            this.conflictPoints.setNoOfItems(agePoint);
        }
        ConflictPoint cp = conflictPoints;
        updateItemList(cp);

    }


    public void buyResource(Resource resource, int neighbor) {
        System.out.println("CurrentCoin in Player's buyResource: " + currentCoin);
        if( currentCoin.noOfItems >= 2){
            int money = -2;
            for (int i = 0; i < discountedResources.size(); i++) {
                if (resource.getResourceName().equals(discountedResources.get(i).getResourceName())) {
                    money = -1;
                }
            }
            //neighbor.addCoin(-1 * money);
            if( neighbor == 0)
                ClientControllerFacade.getInstance().getClientManager().setSpentToLeft( -1 * money);
            else
                ClientControllerFacade.getInstance().getClientManager().setSpentToRight( -1 * money);

            addCoin(money);
            Resource[] r = new Resource[1];
            r[0] = resource;
            updateResources(r);
        }
    }

    public Coin getCurrentCoin() {
        return currentCoin;
    }

    public MilitaryPower getMilitaryP() {
        return militaryP;
    }

    public ArrayList<ScientificType> getScientificTypes() {
        return scientificTypes;
    }

    public ArrayList<Resource> getCurrentResources() {
        return currentResources;
    }

    public ArrayList<Structure> getFreeStructures() {
        return freeStructures;
    }


    public void updateDiscountedResources(Resource[] resourcesArr) {
        for (int i = 0; i < resourcesArr.length; i++) {
            discountedResources.add(resourcesArr[i]);
        }
    }

    public Player getRightNeighbor() {
        return ModelService.getInstance().playerList.get(rightNeighbor);
    }

    public void setRightNeighbor(int rightNeighbor) {
        this.rightNeighbor = rightNeighbor;
    }

    public Player getLeftNeighbor() {
        return ModelService.getInstance().playerList.get(leftNeighbor);
    }

    public void setLeftNeighbor(int leftNeighbor) {
        this.leftNeighbor = leftNeighbor;
    }

    public String getName() {
        return name;
    }

    public WonderBoard getWonder() {
        return wonder;
    }

    public Item getVictoryPoints() {
        return victoryPoints;
    }
    public ConflictPoint getConflictPoints() { return conflictPoints; }
    public MilitaryPower getMilitaryPower() {
        return militaryP;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getFinalPoint() { return finalPoint; }

}