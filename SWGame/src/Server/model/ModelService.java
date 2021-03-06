package Server.model;

import Client.ClientController.ClientControllerFacade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelService {
    private static ModelService modelService;
    public int playerIndex;
    public Age currentAge;
    Player currentPlayer;
    int numberOfPlayers;
    ArrayList<Player> playerList;
    Card selectedCard;
    Card[][] rotatingCardList;
    ViewManipulator viewManipulator;
    WonderBoard wonder;
    ArrayList<WonderBoard> wonderList;
    int directionFactor;
    int cardLength;
    private Player chosenPlayer;
    private Player swappedPlayer;
    public boolean endGame = false;

    private ModelService() {
        cardLength = 7;
        viewManipulator = ViewManipulator.getInstance();
        numberOfPlayers = 3;
        currentAge = new AgeI();
        currentAge.createDeck(numberOfPlayers);
        playerList = new ArrayList<>();
        int rotNo = 7;
        rotatingCardList = new Card[numberOfPlayers][rotNo];
        playerIndex = 0;

    }

    public static ModelService getInstance() {
        if (modelService == null) {
            modelService = new ModelService();
        }
        return modelService;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public int getCardLength() {
        return rotatingCardList[numberOfPlayers - 1].length;
    }

    public boolean constructCard(Player player, Card[] cards, Card selectedCard, boolean taken) {
        if (selectedCard != null){

            return selectedCard.constructCard(player, cards,taken);
        }
        return false;
    }

    public void updateCurrentAge(Player player, Age age) throws InterruptedException {
        if (age instanceof AgeI) {
            initiateAndShowConflict(player,age);
        }
        if (age instanceof AgeII) {
            initiateAndShowConflict(player, age);
        }
        if (age instanceof AgeIII) {
            initiateAndShowConflict(player, age);
            calculateFinalPoints();
        }
    }


    //Will update the current player as each turn is played.
    public void updateCurrentPlayer() {
        if (playerIndex == numberOfPlayers - 1) {
            playerIndex = 0;
            cardLength--;
            rotateDecks();
        } else {
            playerIndex++;
        }

        currentPlayer = playerList.get(playerIndex);
    }

    /*
     Will remove the chosen card from the rotating card list.
     The parameter of this method will be the card which is chosen by player.
     */
    public void removeFromRotatingCardList( Card[] rotatingCardList) {
        if (selectedCard != null) {
            System.out.println("hi bitches");
            for (int i = 0; i < rotatingCardList.length; i++) {
                if (rotatingCardList[i] == selectedCard) {
                    for (int j = i; j < rotatingCardList.length - 1; j++) {
                        rotatingCardList[j] = rotatingCardList[j + 1];
                    }
                    Card[] arr = new Card[rotatingCardList.length - 1];
                    for (int j = 0; j < rotatingCardList.length - 1; j++) {
                        arr[j] = rotatingCardList[j];
                    }
                    rotatingCardList = new Card[rotatingCardList.length - 1];
                    for (int j = 0; j < rotatingCardList.length; j++) {
                        rotatingCardList[j] = arr[j];
                    }
                }
            }
        }
        ClientControllerFacade.getInstance().getClientManager().setCards(rotatingCardList);
        System.out.println(rotatingCardList.length);
        System.out.println("removed");
        selectedCard = null;
    }

    public void removeFromRotatingCardList( int playerIndex, Card selectedCard) {
        if (selectedCard != null) {
            System.out.println("hi bitches");
            for (int i = 0; i < rotatingCardList[playerIndex].length; i++) {
                if (rotatingCardList[playerIndex][i].getName().equals(selectedCard.getName())) {
                    System.out.println("SELECTED CARD EQUALS GIRDI");
                    for (int j = i; j < rotatingCardList[playerIndex].length - 1; j++) {
                        rotatingCardList[playerIndex][j] = rotatingCardList[playerIndex][j + 1];
                    }
                    Card[] arr = new Card[rotatingCardList[playerIndex].length - 1];
                    for (int j = 0; j < rotatingCardList[playerIndex].length - 1; j++) {
                        arr[j] = rotatingCardList[playerIndex][j];
                    }
                    rotatingCardList[playerIndex] = new Card[rotatingCardList[playerIndex].length - 1];
                    for (int j = 0; j < rotatingCardList[playerIndex].length ; j++) {
                        rotatingCardList[playerIndex][j] = arr[j];
                    }
                }
            }
        }
        this.rotatingCardList[playerIndex] = rotatingCardList[playerIndex];
        System.out.println(rotatingCardList[playerIndex].length);
        System.out.println("removed");
//        ImageView iv = new ImageView();
//        iv.setImage(new Image(selectedCard.getName() + ".png"));
//        iv.setManaged(false);
         selectedCard = null;
    }

    /*
    Will initiate the game. This method will call the createWonderBoard() method from the WonderBoard class
    which will create the 7 wonder boards, the createDeck() method from the Age class
    which will create the cards, the createPlayer() method from the Player class
    which will create the player objects and the shuffle() method which will shuffle the wonder boards and cards.
     */
    public void initializeGame() {
        createWonderBoards();
        createPlayer();
        shuffle(wonderList);

    }

    void createPlayer() {

        playerList.clear();
        Player player1 = new Player("Player1", 3);
        Player player2 = new Player("Player2", 3);
        Player player3 = new Player("Player3", 3);
        playerList.add(player1); //0
        playerList.add(player2); //1
        playerList.add(player3); //2
        player1.setLeftNeighbor(2);
        player1.setRightNeighbor(1);
        player2.setLeftNeighbor(0);
        player2.setRightNeighbor(2);
        player3.setLeftNeighbor(1);
        player3.setRightNeighbor(0);
        currentPlayer = player1;
        playerIndex = 0;
    }

    //Will shift the rotatingCardList when called and will make it turn according to the directionFactor attribute.
    public void rotateDecks() {
        Card[] temp1 = rotatingCardList[0];
        Card[] temp2 = rotatingCardList[1];
        Card[] temp3 = rotatingCardList[2];
        rotatingCardList[1] = temp1;
        rotatingCardList[2] = temp2;
        rotatingCardList[0] = temp3;
    }

    /*
    Will calculate the final victory points of the players. It will call the updateVictoryPoints() method from the user
    and then will call the showGameOverPage() method which will then call
    the notifyGameOverPane() from the ViewManipulator.
    */
    void calculateFinalPoints() {
        for (int i = 0; i < numberOfPlayers; i++) {
            playerList.get(i).finalPoint = playerList.get(i).victoryPoints.getNoOfItems() + playerList.get(i).conflictPoints.getNoOfItems();
        }
    }

    public void changeAge(Player p, Age age){
        if (age instanceof AgeI) {
            System.out.println("ChangeAge başına geldi");
            p.currentAge = new AgeII();
            currentAge = new AgeII();
            currentAge.createDeck(3);
            if (currentAge.cardDeck == null)
                System.out.println("ChangeAge ------ null geldi");
        }
        else if (age instanceof AgeII) {
            System.out.println("BURAYA GİRDİ Mİ CHANGEAGE 2.");
            p.currentAge = new AgeIII();
            currentAge = new AgeIII();
            currentAge.createDeck(3);
            if (currentAge.cardDeck == null)
                System.out.println("ChangeAge ------ for age 3null geldi");
        }
        else{
            endGame = true;
        }
    }
    /*
    Will calculate the victory points of the players after a conflict
    and will call the notifyConflictScreen(Player[]) from the ViewManipulator class.
    */
    public void initiateAndShowConflict(Player player, Age age) {
            player.updateConflictPoints(age);

    }

    /*
     Will call the showNextTurnPage() method which will then
     provide the next player and call the notifyNextTurnScreen(Player) from the ViewManipulator.
    */
    public void showNextTurnPage() {
        updateCurrentPlayer();
        viewManipulator.notifyNextTurnScreen(currentPlayer);
    }

    void updateResource(Resource[] resources, Coin coin,
                        VictoryPoint vc, MilitaryPower mp) {
        if (resources != null) {
            currentPlayer.updateResources(resources);
        }
    }


    void updateCoin(Coin coin) {
        if (coin != null) {
            currentPlayer.addCoin(coin.getNoOfItems());
        }
    }

    void updateVictoryPoint(VictoryPoint vc) {
        if (vc != null) {
            currentPlayer.updateVictoryPoints(vc);
        }
    }

    void updateMilitaryPower(MilitaryPower mp) {
        if (mp != null) {
            currentPlayer.updateMilitaryPower(mp.getNoOfItems());
        }
    }

    public void showUpdatedPane() {
    }

    /*
     Will call the notifyWonderPane() method from the ViewManipulator.
    */

    public void riskBuildWonder(Player player) {
        player.wonder.riskBuildWonderStage();
    }

    public boolean buildWonder(Player player, Card[] cards, Card selectedCard, boolean taken) {
        if(player.wonder.buildWonderStage(player,taken)){
            removeFromRotatingCardList(cards);
            return true;
        }
        return false;
    }

    /*
     Will call the notifyHowToPlay() method from the ViewManipulator.
     */
    public void showHowToPlay() {
        viewManipulator.notifyHowToPlay();
    }

    /*
    Will call the notifyGameOverPane() from the ViewManipulator.
     */
    public void showGameOverPage() {
        viewManipulator.notifyGameOverPane(playerList);
    }

    /*
    Will call the notifyNameScreen() from the ViewManipulator.
     */
    public void showNameScreen() {
        viewManipulator.notifyNameScreen();
    }

    /*
    Will call the notifyCredits() from the ViewManipulator.
    */
    public void showCredits() {
        viewManipulator.notifyCredits();
    }

    /*
    Will call the notifyMainMenu() from the ViewManipulator.
    */
    public void showMainMenu() {
        viewManipulator.notifyMainMenu();
    }

    /*
    Will call the assignWonderBoard() which will assign wonder board objects to each player randomly,
    the createRotatingCardList(WonderBoard[] wonderlist, Player[] playerList)
    which will create the rotatingCardList, the assignName(String[] names)
    which will assign the names of the players.
    */
    public void assignGame() {
        assignWonderBoard(wonderList, playerList);
        createRotatingCardList();

    }

    /*
    Will randomly choose a player from the playerList
    and then will randomly choose a wonder board object from the wonderList.
    And then will assign that wonder board object to that player.
    This process will be done for every player object in the playerList.
     */
    void assignWonderBoard(ArrayList<WonderBoard> wonderList, ArrayList<Player> playerList) {
        Collections.shuffle(wonderList);
        int i = 0;
        for (Player player : playerList) {
            System.out.println(i);
            System.out.println(playerList.size());
            player.wonder = wonderList.get(i);
            Resource[] res = {player.wonder.getProducedResource()};
            player.updateResources(res);
            System.out.println(wonderList.get(i).getWonderStage(0).getRequiredResources()[0].getResourceName());
            i++;
        }
    }

    void shuffle(ArrayList<WonderBoard> w) {

        Collections.shuffle(w);
    }

    void shuffle(List<Card> l) {

        Collections.shuffle(l);
    }

    /*
    Will divide the shuffled cardDeck object into 4 equal sub card sets
    and then will put these into a card array which is called RotatingCardList.
    */
    public Card[][] createRotatingCardList() {
        this.rotatingCardList = new Card[3][7];
        System.out.println(currentAge.name);
        if (numberOfPlayers == 3) {
            System.out.println(currentAge.name);
            int rotNo = 7;
            shuffle(currentAge.getCardDeck());
            int cardDeckNo = 0;
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < rotNo; i++) {
                    rotatingCardList[j][i] = currentAge.getCardDeck().get(cardDeckNo);
                    cardDeckNo++;
                }
            }

        }
        return rotatingCardList;
    }

    /*
    Will assign the given names to the names of the player objects.
     */
    void assignName(String[] names, ArrayList<Player> playerList) {

        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).name = names[i];

        }
    }


    /*
    Will call the notifyGameBorderPane(playerList: Player[], rotatingCardList : Card[][]) from the ViewManipulator.
     */
    public void showGameScreen() {
        viewManipulator.notifyGameBorderPane(currentPlayer);
    }

    /*
    Creates 7 different WonderBoards according to their unique WonderStage’s and returns an array of these WonderBoards.
     */
    public ArrayList<WonderBoard> createWonderBoards() {

        wonderList = new ArrayList<WonderBoard>();
        wonderList.clear();
        Resource glass = new Resource("Glass", 1, "glass.png");
        /*Alexandria */
        Resource[] requiredResource = new Resource[1];
        VictoryPoint v3 = new VictoryPoint(3);
        requiredResource[0] = new Resource("Stone", 2, "stone.png");
        WonderStage a1 = new WonderStage(null, requiredResource, v3, null);

        Resource[] providedR1 = new Resource[2];
        providedR1[0] = new Resource("Ore", 1, "ore.png");
        providedR1[1] = new Resource("Timber", 1, "timber.png");
        requiredResource[0] = new Resource("Ore", 2, "ore.png");
        WonderStage a2 = new WonderStage(providedR1, requiredResource, null, null);

        requiredResource[0] = new Resource("Glass", 2, "glass.png");
        VictoryPoint v7 = new VictoryPoint(7);
        WonderStage a3 = new WonderStage(null, requiredResource, v7, null);

        WonderBoard Alexandria = new WonderBoard("Alexandria", glass, "alexandriaA.png", a1, a2, a3);
        wonderList.add(Alexandria);

        //Babyblon
        requiredResource[0] = new Resource("Clay", 2, "clay.png");
        WonderStage b1 = new WonderStage(null, requiredResource, v3, null);

        requiredResource[0] = new Resource("Timber", 3, "timber.png");
        providedR1[0] = new Resource("Stone", 1, "stone.png");
        providedR1[1] = new Resource("Papyrus", 1, "papyrus.png");
        WonderStage b2 = new WonderStage(requiredResource, providedR1, null, null);

        requiredResource[0] = new Resource("Clay", 4, "clay.png");
        WonderStage b3 = new WonderStage(null, requiredResource, v7, null);

        Resource clay = new Resource("Clay", 1, "clay.png");
        WonderBoard Babylon = new WonderBoard("Babylon", clay, "babylonA.png", b1, b2, b3);
        wonderList.add(Babylon);

        //Ephesos
        requiredResource[0] = new Resource("Stone", 2, "stone.png");
        WonderStage e1 = new WonderStage(null, requiredResource, v3, null);
        requiredResource[0] = new Resource("Timber", 2, "timber.png");
        providedR1[0] = new Resource("Stone", 1, "stone.png");
        providedR1[1] = new Resource("Textile", 1, "textile.png");
        WonderStage e2 = new WonderStage(providedR1, requiredResource, null, null);
        requiredResource[0] = new Resource("Papyrus", 2, "papyrus.png");
        WonderStage e3 = new WonderStage(null, requiredResource, v7, null);

        Resource papyrus = new Resource("Papyrus", 1, "papyrus.png");
        WonderBoard Ephesos = new WonderBoard("Ephesos", papyrus, "ephesosA.png", e1, e2, e3);
        wonderList.add(Ephesos);

        //Gizah
        requiredResource[0] = new Resource("Stone", 2, "stone.png");

        WonderStage g1 = new WonderStage(null, requiredResource, v3, null);

        providedR1[0] = new Resource("Ore", 4, "ore.png");
        providedR1[1] = new Resource("Textile", 1, "textile.png");
        WonderStage g2 = new WonderStage(providedR1, requiredResource, null, null);
        requiredResource[0] = new Resource("Papyrus", 2, "papyrus.png");
        WonderStage g3 = new WonderStage(null, requiredResource, v7, null);

        Resource stone = new Resource("Stone", 1, "stone.png");
        WonderBoard Gizah = new WonderBoard("Gizah", stone, "gizahA.png", g1, g2, g3);
        wonderList.add(Gizah);

        //Halikarnassus


        WonderStage h1 = new WonderStage(null, requiredResource, v3, null);

        requiredResource[0] = new Resource("Stone", 2, "stone.png");
        providedR1[0] = new Resource("Stone", 1, "stone.png");
        providedR1[1] = new Resource("Textile", 1, "textile.png");
        WonderStage h2 = new WonderStage(providedR1, requiredResource, null, null);

        requiredResource[0] = new Resource("Textile", 2, "textile.png");
        WonderStage h3 = new WonderStage(null, requiredResource, v7, null);

        Resource textile = new Resource("Textile", 1, "textile.png");
        WonderBoard Halikarnassus = new WonderBoard("Halikarnassus", textile, "halikarnassusA.png", h1, h2, h3);
        wonderList.add(Halikarnassus);

        //Olympia
        WonderStage o1 = new WonderStage(null, requiredResource, v3, null);

        providedR1[0] = new Resource("Ore", 1, "ore.png");
        providedR1[1] = new Resource("Clay", 1, "clay.png");
        requiredResource[0] = new Resource("Stone", 2, "stone.png");
        WonderStage o2 = new WonderStage(providedR1, requiredResource, null, null);

        WonderStage o3 = new WonderStage(null, requiredResource, v7, null);

        Resource timber = new Resource("Timber", 1, "timber.png");
        WonderBoard Olympia = new WonderBoard("Olympia", timber, "olympiaA.png", o1, o2, o3);
        wonderList.add(Olympia);

        //Rhodos

        WonderStage r1 = new WonderStage(null, requiredResource, v3, null);

        requiredResource[0] = new Resource("Papyrus", 2, "papyrus.png");
        MilitaryPower c = new MilitaryPower(2);
        WonderStage r2 = new WonderStage(null, requiredResource, null, c);

        requiredResource[0] = new Resource("Papyrus", 2, "papyrus.png");
        WonderStage r3 = new WonderStage(null, requiredResource, v7, null);

        Resource ore = new Resource("Ore", 1, "ore.png");
        WonderBoard Rhodos = new WonderBoard("Rhodos", ore, "rhodosA.png", r1, r2, r3);
        wonderList.add(Rhodos);

        for (WonderBoard wonder : wonderList) {
            System.out.println(wonder.getWonderStage(0).getRequiredResources()[0].getResourceName());
        }

        return wonderList;

    }
    public void setChosenPlayer(Player p){ chosenPlayer = p;}

    public void setSwappedPlayer(Player p) {swappedPlayer = p;}

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Card[][] getRotatingCardList() {
        return rotatingCardList;
    }

    public Player getChosenPlayer() {
        return chosenPlayer;
    }

    public Player getSwappedPlayer(){return swappedPlayer;}
}