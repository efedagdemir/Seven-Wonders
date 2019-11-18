package model;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class ModelService {
    private static ModelService modelService;
    Card xyz;
    Age currentAge;
    Player currentPlayer;
    int numberOfPlayers;
    ArrayList<Player>  playerList;
    Card[][] rotatingCardList;
    ViewManipulator viewManipulator;
    WonderBoard wonder;
    ArrayList<WonderBoard> wonderList;
    int directionFactor;
    int playerIndex;

    private ModelService(){

        if ( numberOfPlayers == 4 ){
        int rotNo = currentAge.cardDeck.size() / 4;
        rotatingCardList = new Card[numberOfPlayers][rotNo];
        }
        else if (numberOfPlayers == 3 ){
            int rotNo = currentAge.cardDeck.size() / 4;
            rotatingCardList = new Card[numberOfPlayers][rotNo];
        }
        playerIndex = 0;

    }

    public static ModelService getInstance() {
        if(modelService == null){
            modelService = new ModelService();
        }
        return modelService;
    }

    public void updateCurrentAge(){
        if(currentAge instanceof AgeI){
            currentAge = new AgeII();
        }
        if(currentAge instanceof AgeII){
            currentAge = new AgeII();
        }
        if(currentAge instanceof AgeIII){

        }
    }
    //Will update the current player as each turn is played.
    void updateCurrentPlayer(){
        if(playerIndex == numberOfPlayers - 1){
            playerIndex = 0;
        }
        else{
            playerIndex++;
        }

        currentPlayer = playerList.get(playerIndex);
    }
    /*
     Will remove the chosen card from the rotating card list.
     The parameter of this method will be the card which is chosen by player.
     */
    void removeRotatingCardList(Card card){
        for ( int i = 0; i < rotatingCardList[playerIndex].length; i++){
            if ( rotatingCardList[playerIndex][i] == card){
                for ( int j = i; j < rotatingCardList[playerIndex].length - 1; j++){
                    rotatingCardList[playerIndex][j] = rotatingCardList[playerIndex][j + 1];
                }
                Card arr[] = new Card[rotatingCardList[playerIndex].length - 1];
                for ( int j = 0; j < rotatingCardList[playerIndex].length - 1; j++){
                    arr[j] = rotatingCardList[playerIndex][j];
                }
                rotatingCardList[playerIndex] = new Card [rotatingCardList[playerIndex].length - 1];
                for ( int j = 0; j < rotatingCardList[playerIndex].length; j++){
                    rotatingCardList[playerIndex][j] = arr[j];
                }
            }
        }
    }

    /*
    Will initiate the game. This method will call the createWonderBoard() method from the WonderBoard class
    which will create the 7 wonder boards, the createDeck() method from the Age class
    which will create the cards, the createPlayer() method from the Player class
    which will create the player objects and the shuffle() method which will shuffle the wonder boards and cards.
     */
    void initializeGame(){
        createWonderBoards();
        currentAge.createDeck(numberOfPlayers);
        createPlayer();
        shuffle(wonderList);

    }

    void createPlayer(){

        Player player1 = new Player(null, 3, null );
        Player player2 = new Player(null, 3, null );
        Player player3 = new Player(null, 3, null );
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        if (numberOfPlayers == 4){

            Player player4 = new Player(null, 3, null );
            playerList.add(player4);
        }
    }
    //Will shift the rotatingCardList when called and will make it turn according to the directionFactor attribute.
    void rotateDecks(){
        Card temp1[] = rotatingCardList[0];
        Card temp2[] = rotatingCardList[1];
        Card temp3[] = rotatingCardList[2];
        rotatingCardList[1] = temp1;
        rotatingCardList[2] = temp2;
        rotatingCardList[0] = temp3;
        if( numberOfPlayers > 3){
            rotatingCardList[0] = rotatingCardList[4];
            rotatingCardList[3] = temp3;
        }

    }

    /*
    Will calculate the final victory points of the players. It will call the updateVictoryPoints() method from the user
    and then will call the showGameOverPage() method which will then call
    the notifyGameOverPane() from the ViewManipulator.
    */
    void calculateFinalPoints(){
        for ( int i = 0; i < numberOfPlayers; i++){
            playerList.get(i).finalPoint =  playerList.get(i).victoryPoints.getNoOfItems() + playerList.get(i).conflictPoints.getNoOfItems();
        }
    }

    /*
    Will calculate the victory points of the players after a conflict
    and will call the notifyConflictScreen(Player[]) from the ViewManipulator class.
    */
    void initiateAndShowConflict(){
        for(int i = 0; i < playerList.size();i++){
            playerList.get(i).updateConflictPoints(currentAge);
        }
        viewManipulator.notifyConflictScreen(playerList);
    }

    /*
     Will call the showNextTurnPage() method which will then
     provide the next player and call the notifyNextTurnScreen(Player) from the ViewManipulator.
    */
    void showNextTurnPage(){
        updateCurrentPlayer();
        viewManipulator.notifyNextTurnScreen(currentPlayer);
    }

    void updateResource(Resource[] resources,Coin coin,
                        VictoryPoint vc, MilitaryPower mp){
        if(resources != null){
            currentPlayer.updateResources(resources);
        }
    }

    void updateCoin(Coin coin){
        if(coin != null){
            currentPlayer.updateCoin(coin.getNoOfItems());
        }
    }

    void updateVictoryPoint(VictoryPoint vc){
        if(vc != null){
            currentPlayer.updateVictoryPoints(vc);
        }
    }

    void updateMilitaryPower(MilitaryPower mp){
        if(mp != null){
            currentPlayer.updateMilitaryPower(mp.getNoOfItems());
        }
    }

    void showUpdatedPane(){
        viewManipulator.updateInfoPane(currentPlayer.getItemList());
    }

    /*
     Will call the notifyWonderPane() method from the ViewManipulator.
    */
    void buildWonder(){
        viewManipulator.notifyWonderPane(wonderList);
    }

    /*
     Will call the notifyHowToPlay() method from the ViewManipulator.
     */
    void showHowToPlay(){
        viewManipulator.notifyHowToPlay();
    }

    /*
    Will call the notifyGameOverPane() from the ViewManipulator.
     */
    void showGameOverPage(){
        viewManipulator.notifyGameOverPane(playerList);
    }

    /*
    Will call the notifyNameScreen() from the ViewManipulator.
     */
    void showNameScreen(){
        viewManipulator.notifyNameScreen();
    }

    /*
    Will call the notifyCredits() from the ViewManipulator.
    */
    void showCredits(){
        viewManipulator.notifyCredits();
    }

    /*
    Will call the notifyMainMenu() from the ViewManipulator.
    */
    void showMainMenu(){
        viewManipulator.notifyMainMenu();
    }

    /*
    Will call the assignWonderBoard() which will assign wonder board objects to each player randomly,
    the createRotatingCardList(WonderBoard[] wonderlist, Player[] playerList)
    which will create the rotatingCardList, the assignName(String[] names)
    which will assign the names of the players.
    */
    void assignGame(String[] names){
        assignWonderBoard( wonderList, playerList);
        createRotatingCardList();
        assignName(names, playerList);
    }

    /*
    Will randomly choose a player from the playerList
    and then will randomly choose a wonder board object from the wonderList.
    And then will assign that wonder board object to that player.
    This process will be done for every player object in the playerList.
     */
    void assignWonderBoard(ArrayList<WonderBoard> wonderList, ArrayList<Player> playerList){

        int length = playerList.size();
        int l_player = playerList.size();
        int l_wonder = wonderList.size();
        Random rand = new Random();
        int int_wonder;
        int int_player;

        for ( int i = 0; i < length; i++){
            int_wonder = rand.nextInt(l_wonder);
            int_player = rand.nextInt(l_player);
            playerList.get(int_player).wonder = wonderList.get(int_wonder);
            for ( int j = int_player; j < l_player - 1; j++){
                playerList.remove(j);
            }
            for ( int j = int_wonder; j < l_wonder - 1; j++){
                wonderList.remove(j);
            }

        }
        l_player--;
        l_wonder--;
    }

    void shuffle(ArrayList<WonderBoard> w){

        Collections.shuffle(w);
    }

    void shuffle(List<Card> l){

        Collections.shuffle(l);
    }

    /*
    Will divide the shuffled cardDeck object into 4 equal sub card sets
    and then will put these into a card array which is called RotatingCardList.
    */
    Card[][] createRotatingCardList(){

        if ( numberOfPlayers == 3 ){
            int rotNo = currentAge.cardDeck.size() / 3;
            shuffle(currentAge.cardDeck);
            int cardDeckNo = 0;
            for (int j = 0; j < 3; j++){
                for (int i = 0; i < rotNo; i++){
                  rotatingCardList[j][i] = currentAge.cardDeck.get(cardDeckNo);
                  cardDeckNo++;
                }
            }

        } else if ( numberOfPlayers == 4 ){
            int rotNo = currentAge.cardDeck.size() / 4;
            shuffle(currentAge.cardDeck);
            int cardDeckNo = 0;
            for (int j = 0; j < 4; j++){
                for (int i = 0; i < rotNo; i++){
                    rotatingCardList[j][i] = currentAge.cardDeck.get(cardDeckNo);
                    cardDeckNo++;
                }
            }
        }
        return rotatingCardList;
    }

    /*
    Will assign the given names to the names of the player objects.
     */
    void assignName(String[] names, ArrayList<Player> playerList){

        for (int i = 0; i < playerList.size(); i++){
            playerList.get(i).name = names[i];

        }
    }


    /*
    Will call the notifyGameBorderPane(playerList: Player[], rotatingCardList : Card[][]) from the ViewManipulator.
     */
    void showGameScreen(){
        viewManipulator.notifyGameBorderPane( playerList, rotatingCardList);
    }
    /*
    Creates 7 different WonderBoards according to their unique WonderStage’s and returns an array of these WonderBoards.
     */
    public ArrayList<WonderBoard> createWonderBoards(){

        wonderList = new ArrayList<WonderBoard>();
        Resource glass = new Resource("Glass", 1 , "images/glass.png");
        /*Alexandria */
        Resource[] requiredResource = new Resource[1];
        VictoryPoint v3 = new VictoryPoint(3);
        requiredResource[0] = new Resource("Stone", 2, "images/stone.png");
        WonderStage a1 = new WonderStage(null, requiredResource, v3,null );

        Resource[] providedR1 = new Resource[2];
        providedR1[0] = new Resource("Ore", 1, "images/ore.png");
        providedR1[1] = new Resource("Timber", 1, "images/timber.png");
        requiredResource[0] = new Resource("Ore", 2, "images/ore.png");
        WonderStage a2 = new WonderStage(providedR1, requiredResource , null,null);

        requiredResource[0] = new Resource("Glass", 2, "images/glass.png");
        VictoryPoint v7 = new VictoryPoint(7);
        WonderStage a3 = new WonderStage(null, requiredResource, v7, null );

        WonderBoard Alexandria = new WonderBoard("Alexandria", glass,"images/alexandriaA.png", a1, a2, a3);
        wonderList.add(Alexandria);

        /*Babyblon*/
        requiredResource[0] = new Resource("Clay", 2, "images/clay.png");
        WonderStage b1 = new WonderStage(null, requiredResource, v3, null);

        requiredResource[0] = new Resource("Timber", 3, "images/timber.png");
        providedR1[0] = new Resource("Stone", 1, "images/stone.png");
        providedR1[1] = new Resource("Papyrus", 1, "images/papyrus.png");
        WonderStage b2 = new WonderStage( requiredResource, providedR1, null, null);

        requiredResource[0] = new Resource("Clay", 4, "images/clay.png");
        WonderStage b3 = new WonderStage(null, requiredResource, v7, null);

        Resource clay = new Resource("Clay", 1, "images/clay.png" );
        WonderBoard Babylon = new WonderBoard("Babylon",clay, "images/babylonA.png", b1, b2, b3);
        wonderList.add(Babylon);

        /*Ephesos*/
        requiredResource[0] = new Resource("Stone", 2, "images/stone.png");
        WonderStage e1 = new WonderStage(null, requiredResource, v3, null);
        requiredResource[0] = new Resource("Timber", 2, "images/timber.png");
        providedR1[0] = new Resource("Stone", 1, "images/stone.png");
        providedR1[1] = new Resource("Textile", 1, "images/textile.png");
        WonderStage e2 = new WonderStage(providedR1, requiredResource, null, null);
        requiredResource[0] = new Resource("Papyrus", 2, "images/papyrus.png");
        WonderStage e3 = new WonderStage(null, requiredResource, v7, null);

        Resource papyrus = new Resource("Papyrus", 1, "images/papyrus.png" );
        WonderBoard Ephesos = new WonderBoard("Ephesos",papyrus,"images/ephesosA.png", e1, e2, e3);
        wonderList.add(Ephesos);

        /*Gizah*/
        requiredResource[0] = new Resource("Stone", 2, "images/stone.png");

        WonderStage g1 = new WonderStage(null, requiredResource, v3, null );

        providedR1[0] = new Resource("Ore", 4, "images/ore.png");
        providedR1[1] = new Resource("Textile", 1, "images/textile.png");
        WonderStage g2 = new WonderStage(providedR1, requiredResource, null, null);
        requiredResource[0] = new Resource("Papyrus", 2, "images/papyrus.png");
        WonderStage g3 = new WonderStage(null, requiredResource, v7, null );

        Resource stone = new Resource("Stone", 1, "images/stone.png");
        WonderBoard Gizah  = new WonderBoard("Gizah", stone, "images/gizahA.png" , g1, g2, g3);
        wonderList.add(Gizah);

        /*Halikarnassus*/


        WonderStage h1 = new WonderStage(null, requiredResource, v3, null);

        requiredResource[0] = new Resource("Stone", 2, "images/stone.png");
        providedR1[0] = new Resource("Stone", 1, "images/stone.png");
        providedR1[1] = new Resource("Textile", 1, "images/textile.png");
        WonderStage h2 = new WonderStage(providedR1, requiredResource, null,null);

        requiredResource[0] = new Resource("Textile", 2, "images/textile.png");
        WonderStage h3 = new WonderStage(null, requiredResource, v7, null);

        Resource textile = new Resource("Textile", 1, "images/textile.png");
        WonderBoard Halikarnassus = new WonderBoard("Halikarnassus", textile, "halikarnassusA.png", h1, h2, h3);
        wonderList.add(Halikarnassus);

        /*Olympia*/
        WonderStage o1 = new WonderStage(null, requiredResource, v3, null);

        providedR1[0] = new Resource("Ore", 1, "images/ore.png");
        providedR1[1] = new Resource("Clay", 1, "images/clay.png");
        requiredResource[0] = new Resource("Stone", 2, "images/stone.png");
        WonderStage o2 = new WonderStage(providedR1, requiredResource , null, null);

        WonderStage o3 = new WonderStage(null, requiredResource, v7, null);

        Resource timber = new Resource("Timber", 1, "images/timber.png");
        WonderBoard Olympia = new WonderBoard("Olympia", timber, "olympiaA.png", o1, o2,o3);
        wonderList.add(Olympia);

        /*Ore*/

        WonderStage r1 = new WonderStage(null, requiredResource, v3, null);

        requiredResource[0] = new Resource("Papyrus", 2, "images/papyrus.png");
        ConflictPoint c = new ConflictPoint(2);
        WonderStage r2 = new WonderStage(null, requiredResource, null, c);

        requiredResource[0] = new Resource("Papyrus", 2, "images/papyrus.png");
        WonderStage r3 = new WonderStage(null, requiredResource, v7, null);

        Resource ore = new Resource("Ore", 1, "images/ore.png");
        WonderBoard Rhodos = new WonderBoard("Rhodos", ore,"rhodosA.png", r1, r2, r3 );
        wonderList.add(Rhodos);

        return wonderList;

    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }



}