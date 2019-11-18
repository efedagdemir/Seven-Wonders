package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModelService {
    private static ModelService modelService = new ModelService();
    Card xyz;
    Age currentAge;
    Player currentPlayer;
    int numberOfPlayers;
    ArrayList<Player> playerList;
    Card[][] rotatingCardList;
    ViewManipulator viewManipulator;
    WonderBoard wonder;
    WonderBoard[] wonderList;
    int directionFactor;

    private ModelService(){}

    public static ModelService getInstance() {
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

    }
    /*
     Will remove the chosen card from the rotating card list.
     The parameter of this method will be the card which is chosen by player.
     */
    void removeRotatingCardList(Card card){

    }

    /*
    Will initiate the game. This method will call the createWonderBoard() method from the WonderBoard class
    which will create the 7 wonder boards, the createDeck() method from the Age class
    which will create the cards, the createPlayer() method from the Player class
    which will create the player objects and the shuffle() method which will shuffle the wonder boards and cards.
     */
    void initializeGame(){

    }

    //Will shift the rotatingCardList when called and will make it turn according to the directionFactor attribute.
    void rotateDecks(){

    }

    /*
    Will calculate the final victory points of the players. It will call the updateVictoryPoints() method from the user
    and then will call the showGameOverPage() method which will then call
    the notifyGameOverPane() from the ViewManipulator.
    */
    void calculateFinalPoints(){

    }

    /*
    Will calculate the victory points of the players after a conflict
    and will call the notifyConflictScreen(Player[]) from the ViewManipulator class.
    */
    void initiateAndShowConflict(){

    }

    /*
     Will call the showNextTurnPage() method which will then
     provide the next player and call the notifyNextTurnScreen(Player) from the ViewManipulator.
    */
    void showNextTurnPage(){

    }

    /*
    Will call the updateItemList() method which will change the items of the player
    according to the taken action. Then will call the updateInfoPane(ItemList : Item) from the ViewManipulator.
     */
    void updateItemList(){

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
        assignGame(names);
    }

    /*
    Will randomly choose a player from the playerList
    and then will randomly choose a wonder board object from the wonderList.
    And then will assign that wonder board object to that player.
    This process will be done for every player object in the playerList.
     */
    void assignWonderBoard(WonderBoard[] wonderList, ArrayList<Player> playerList){
        int length = playerList.size();
        int l_player = playerList.size();
        int l_wonder = wonderList.length;
        Random rand = new Random();
        int int_wonder;
        int int_player;
        for ( int i = 0; i < length; i++){
            int_wonder = rand.nextInt(l_wonder);
            int_player = rand.nextInt(l_player);
            playerList.get(int_player).wonder = wonderList[int_wonder];
            for ( int j = int_player; j < l_player - 1; j++){
                playerList.remove(j);
            }
            for ( int j = int_wonder; j < l_wonder - 1; j++){
                wonderList[j] = wonderList[j + 1];
            }
            l_player--;
            l_wonder--;
        }
    }
    void shuffle(List l){}
    /*
    Will divide the shuffled cardDeck object into 4 equal sub card sets
    and then will put these into a card array which is called RotatingCardList.
    */
    Card[][] createRotatingCardList(){

        if ( numberOfPlayers == 3 ){
            int rotNo = currentAge.cardDeck.size() / 3;
            Card[][] rotatingCardList = new Card[3][rotNo];
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
            Card[][] rotatingCardList = new Card[4][rotNo];
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
    void assignName(String[] names, Player[] playerList){

    }


    /*
    Will call the notifyGameBorderPane(playerList: Player[], rotatingCardList : Card[][]) from the ViewManipulator.
     */
    void showGameScreen(){

    }
    /*
    Creates 7 different WonderBoards according to their unique WonderStage’s and returns an array of these WonderBoards.
     */
    public WonderBoard[] createWonderBoards(){

    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }



}