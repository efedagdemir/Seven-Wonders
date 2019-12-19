package Client.view;

import controller.ControllerFacade;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class HowToPlayPane extends ScrollPane {
    //private static CreditsPane creditsPane = new CreditsPane();

    public VBox htpBox = new VBox();
    public Label htpLabel = new Label("How to Play");
    public Label rules = new Label("COMPONENTS\n-------------\nWonder boards\n" +
            "7 Wonder cards\n" +
            "49 Age I cards, 49 Age II cards, 50 Age III cards\n" +
            "46 Conflict tokens\n" +
            "24 value 3 coins, 46 value 1 coins\n" +
            "1 score booklet\n" +
            "1 rulebook\n" +
            "2 \"2 player\" cards\nObject of the Game\n" +
            "A game of 7 Wonders takes place over 3 Ages, each using one of the 3 card decks (first the Age I cards, then Age II, and finally Age III). These Ages are each played similarly, with each player having the opportunity to play 6 cards per Age to develop his or her city and build their Wonder.\n" +
            "\n" +
            "At the end of each Age, each player compares their military might with their two neighboring cities (belonging to the players to their right and left).\n" +
            "\n" +
            "At the end of the third Age, the players count their victory points; the player with the most points wins the game.\n" +
            "Setup\n" +
            "One Deck Of Cards Per Age\n" +
            "For each of the 3 decks, return to the box all cards which are not used based on the number of players.\n" +
            "\n" +
            "Example: in a 6 player game, the 3+, 4+, 5+ and 6+ cards are used. The 7+ cards are returned to the box.>/\n" +
            "\n" +
            "Moreover, for the Age III deck:\n" +
            "\n" +
            "Remove the 10 Guilds (purple cards) and randomly (and secretly) keep only the number required based on the number of players.\n" +
            "Then, shuffle the kept Guilds cards kept with the other cards to make up the Age III deck.\n" +
            "Wonders\n" +
            "\n" +
            "Shuffle the 7 Wonder cards, face down, and hand one to each player. The card and its facing determine the Wonders board given to each player as well as the side to be used during the game.\n" +
            "\n" +
            "Notes: For your first few games, you should use side A of the boards, as they are simpler to use. If all the players agree, the Wonders boards can be chosen instead of randomly given.\n" +
            "\n" +
            "Coins\n" +
            "Each player begins the game with 3 value \"1\" coins which they place on their board.\n" +
            "\n" +
            "The remaining coins form the bank (players may \"make change\" between the value \"3\" and \"1\" coins as needed).\n" +
            "\n" +
            "Conflict Tokens\n" +
            "The Conflict tokens form a reserve, next to the coins.\n" +
            "\n");
    public Label morerules = new Label("Game Elements\n" +
            "Wonder Boards\n" +
            "Each board represents the Wonder the player can build and the resource it produces from the start of the game (shown on the upper left of the board). These boards are double-sided and offer two different versions of the Wonder. Each Wonder is composed of two, three or four stages, represented on the board. Each stage has a construction cost and gives a bonus when finished.\n" +
            "Coins\n" +
            "The coins come into play in commercial transactions tying a city to its two neighboring cities. There is no limit to the number of coins a player can accumulate during a game. Accumulated coins are worth victory points at the end of the game.\n" +
            "\n" +
            "Conflict Tokens\n" +
            "The Conflict tokens are used to represent the military victories and defeats between neighboring cities. Four types of tokens are used:\n" +
            "\n" +
            "the Defeat tokens with a value of -1 are used at the end of each of the 3 ages.\n" +
            "the Victory tokens with a value of +1 are used at the end of Age I.\n" +
            "the Victory tokens with a value of +3 are used at the end of Age II.\n" +
            "the Victory tokens with a value of +5 are used at the end of Age III.\n" +
            "Cards\n" +
            "In 7 Wonders, all the Age cards represent structures. There are 7 different types of structures, easily recognizable by the border color of their card.\n" +
            "\n" +
            "Brown cards (Raw Materials): these structures produce resources. \n" +
            "Gray cards (Manufactured Goods): these structures produce resources. \n" +
            "Blue cards (Civilian Structures): these structures score victory points.\n" +
            "Green cards (Scientific Structures): these structures score victory points depending on your progress in the three scientific fields: \n" +
            "Yellow cards (Commercial Structures: these buildings earn coins, produce resources, change commerce rules and sometimes earn victory points.\n" +
            "Red cards (Military Structures): these buildings increase your military might. This comes into play during Conflict resolution.\n" +
            "Purple cards (Guilds): these buildings allow players to score points according to specific criteria.\n" +
            "Note: the Age III deck contains no Raw Materials (brown cards) or Manufactured Goods (gray cards), but it does contain the Guilds (purple cards).\n" +
            "\n" +
            "Cards Cost\n" +
            "The area in the upper left indicates the construction cost. If that area is empty, the structure is free and requires no resources for its construction.\n" +
            "\n" +
            "\n" +
            "\n" +
            "Starting in Age II, some structures can be built either by paying the requisite resource(s) or, alternatively, they can be built for free if the player has built during the previous age the structure indicated on the card.\n" +
            "\n" +
            "The lower right area indicates which structures (if any) may be built for free in the following age due to this card. The lower center area indicates in which configuration - number of players - the card is used.\n" +
            "\n" +
            "\n" +
            "\n" +
            "Construction In 7 Wonders\n" +
            "Throughout all 3 ages in a game, the players will get to build structures (cards) and Wonders (board).\n" +
            "\n" +
            "Most structures have a resource cost. Some are free and some have a coin cost. Some also have a resource cost and a free construction condition.\n" +
            "\n" +
            "The Wonders all have a resource cost.\n" +
            "\n" +
            "@coincost.jpg\" class=\"floatr top10\">\n" +
            "\n" +
            "Coin Cost\n" +
            "Some brown cards cost a coin which must be paid to the bank on the turn in which they are constructed.\n" +
            "Example: the construction of the Timber yard costs 1 coin.\n" +
            "\n" +
            "\n" +
            "Free Construction\n" +
            "Some cards have no cost and can be put into play for free.\n" +
            "\n" +
            "Example: the construction of the Eastern Trading Post is free.\n" +
            "\n" +
            "Free Construction (chains)\n" +
            "\n" +
            "Some structures in Age II and Age III have, to the right of their resource cost, the name of a structure of a previous age. If the player has built the structure named there during a previous Age, that player can build the structure for free, meaning without having to fulfill the resource cost.\n" +
            "\n" +
            "Resource Cost\n" +
            "Some cards have a resource cost. To construct them, the player must produce the corresponding resources AND/OR buy them from one of his or her two neighboring cities.\n" +
            "\n" +
            "\n" +
            "Production\n" +
            "The resources of a city are produced by its Wonder board, its brown cards, its gray cards, and some yellow cards.\n" +
            "\n" +
            "To build a structure, a player's city must produce the resources indicated on its card.\n" +
            "\n" +
            "\n" +
            "Commerce\n" +
            "Often, a player will want to build a structure requiring resources he or she does not produce.\n" +
            "\n" +
            "If these resources are produced by a neighboring city - players sitting directly to the left or right of that player - the player will be able to purchase the missing resource(s) through commerce.\n" +
            "\n" +
            "The resources a player can buy from their neighboring cities are:\n" +
            "\n" +
            "the resources initially produced by the city (as indicated on the board)\n" +
            "the resources from its brown cards (raw materials)\n" +
            "the resources from its gray cards (manufactured goods)\n" +
            "However, it is impossible to buy the resources produced by some commercial structures (yellow cards) or by some Wonders: these resources are reserved to their owner.\n" +
            "\n" +
            "For each resource bought, the player must give 2 coins to the owner of the resource.\n" +
            "\n" +
            "Clarifications\n" +
            "Selling a resource to a neighboring city DOES NOT prevent a player from using it, during the same turn, for his own construction purposes.\n" +
            "\n" +
            "It is possible, during the same turn, to buy one or more resources from both neighboring cities. The resources bought can only be used on the turn in which they are bought.\n" +
            "\n" +
            "Players can never refuse to sell resources. Some commercial structures (yellow cards) reduce the monetary costs of buying resources from 2 to 1 coin.\n" +
            "\n" +
            "When both cities neighboring a player produce a coveted resource, that player is free to purchase from either player.\n" +
            "\n" +
            "To buy resources, the player must have the coins at the beginning of the turn. The coins earned through commerce during a turn cannot be used on that turn, only during the next one.\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "Overview of an Age\n" +
            "At the beginning of each Age, each player receives a hand of 7 cards, dealt randomly, from the corresponding deck. Each Age is made up of 6 game turns. During each turn the players put into play a single card, simultaneously.\n");
    public Label morerules2 = new Label("I. Choose A Card\n" +
            "Each player looks at their hand without showing it to other players and selects a card before placing it face down before them. The remaining cards are placed between their left-hand neighbor and themselves (see end of an Age).\n" +
            "\n" +
            "\n" +
            "II. Action\n" +
            "Once every player has selected his or her card, they perform their action simultaneously.\n" +
            "\n" +
            "Three actions are possible with the chosen card:\n" +
            "\n" +
            "Build the structure\n" +
            "Build a stage of their Wonder\n" +
            "Discard the card to gain 3 coins\n" +
            "Note: during your first game, you can follow the action of each player, one after the other, to become more familiar with the game...\n" +
            "\n" +
            "\n" +
            "A. Build the Structure\n" +
            "Most often, the player will build the structure represented by the selected card.\n" +
            "\n" +
            "The brown and gray cards are placed beneath one another starting from the upper left corner of the Wonders board. This allows players to quickly see all resources produced by each player. The other cards are placed face up, in the area in front of the player's Wonders board.\n" +
            "\n" +
            "All of this area corresponds to a player's city. In order to save space, stack your cards by color while leaving the name of each structure visible.\n" +
            "\n" +
            "\n" +
            "\n" +
            "B. Build a stage of a Wonder\n" +
            "To build each stage of his or her Wonder, the player will use a card of their choice as a construction marker:\n" +
            "\n" +
            "To do that, the player must pay the price shown on the Wonder board and not the one shown on the structure's card. The player then plays the card, face down, half hidden under the Wonder board to show that this stage of their Wonder is now built. The card then has no other effect, and is not considered to be a structure.\n" +
            "\n" +
            "\n" +
            "\n" +
            "Clarification\n" +
            "The stages of a Wonder must be built in order, meaning from left to right. The construction of the Wonder is not mandatory. A player can win the game without having finished (or even started) the construction of his or her Wonder.\n" +
            "\n" +
            "The card used to mark the construction of a Wonder stage remains hidden. Players would be advised to use a card they do not want to give their neighbor.\n" +
            "\n" +
            "Most Wonders have 3 stages but these are not associated with Ages. It is therefore possible to build multiple Wonder stages in a single Age or to begin construction during age III.\n" +
            "\n" +
            "Each stage can only built once per game.\n" +
            "\n" +
            "C. Discard the Card to Gain 3 Coins\n" +
            "A player can choose to discard his or her card to take 3 coins from the bank and add them to his or her treasury.\n" +
            "\n" +
            "The cards discarded this way remain face down and form a discard pile in the center of the table. It can be useful to discard a card you cannot build but which would be of interest to your neighbor.\n" +
            "\n" +
            "Note: if a player has chosen a card but is unable to build either the structure or the Wonder stage, that player is then forced to discard the card and takes 3 coins from the bank.\n" +
            "\n" +
            "\n" +
            "III. Move On To The Next Hand\n" +
            "Each player takes the hand of cards handed from his or her neighbor. Be careful: the direction of the hands rotation changes with each Age:\n" +
            "\n" +
            "During Age I, the hand of cards is passed to the player sitting to the left (clockwise).\n" +
            "\n" +
            "During Age II, the hand of cards is passed to the player sitting to the right (counter-clockwise).\n" +
            "\n" +
            "During Age III, the hand of cards is passed to the player sitting to the left (clockwise).\n" +
            "\n" +
            "Special Case : Sixth Turn\n" +
            "At the beginning of the sixth and final turn of each Age, the players will receive a two-card hand from their neighboring player. Each player then chooses one (like in previous turns) and the second is then discarded, face down.\n" +
            "\n" +
            "The selected card is then played normally. Then the Age ends.\n" +
            "\n" +
            "Clarification\n" +
            "The unselected and discarded card is discarded without the players getting 3 coins for it. Example : Sophie gets a hand of 7 cards at the beginning of the first Age.\n" +
            "\n" +
            "End of an Age\n" +
            "Each Age ends after its sixth game turn.\n" +
            "\n" +
            "The players must then proceed to the resolution of military conflicts. Each player compares the total number of shields present on their military structures (red cards) with the total of each of the two neighboring cities:\n" +
            "\n" +
            "If a player has a higher total than a neighboring city, that player takes a Victory token corresponding to the Age just played (Age I : +1, Age II : +3 or Age III : +5)\n" +
            "If a player has a lower total than that of a neighboring city, that player takes a Defeat token (-1 victory point)\n" +
            "If a player has an equal total to that of a neighboring city, no token is taken.\n" +
            "Each player therefore gets, depending on the situation, 0, 1 or 2 tokens which are placed on his or her Wonder board.\n" +
            "\n" +
            "\n" +
            "End of the Game\n" +
            "\n" +
            "The game ends at the end of the third Age, after the Conflict tokens have been handed out.\n" +
            "\n" +
            "Each player totals their civilization points and the player with the highest total is declared the winner.\n" +
            "\n" +
            "In case of a tie, the player with the most coins in his or her treasury is the winner. A tie on coins is not broken further.\n" +
            "\n" +
            "Note: a booklet of scorecards is in the box to help you count the points for your first few games... or keep track of your more memorable games.\n");
    //public Button okayButton = new Button( "Okay");

    //public Image menuBackground = new Image("7Wbg.jpg");
    //public BackgroundImage backgroundImage = new BackgroundImage( menuBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
    ControllerFacade controllerFacade = ControllerFacade.getInstance();

    public HowToPlayPane() {
        setHbarPolicy(ScrollBarPolicy.ALWAYS);
        setVbarPolicy(ScrollBarPolicy.ALWAYS);
        setContent(htpBox);
        //setFitToHeight(true);
        //setFitToWidth(true);
        setPrefSize(500, 500);
        //okayButton.setStyle("-fx-font-size: 20px");
        htpBox.getChildren().addAll(htpLabel, rules, morerules, morerules2);
        //setCenter(htpBox);
        htpLabel.setFont(new Font(18));
        //htpLabel.setStyle("-fx-text-fill: #dfabdd;");
        htpBox.setSpacing(10);
        //htpBox.setAlignment(Pos.CENTER);
        htpLabel.setTextAlignment(TextAlignment.CENTER);
        //okayButton.setOnAction(e -> controllerFacade.commandModel(e));
        htpLabel.setFont(new Font(50));
        htpLabel.setStyle("-fx-text-fill: #e0bf16;");
        //htpBox.setBackground( new Background(backgroundImage));
        Glow glow = new Glow();
        glow.setLevel(1.0);
        htpLabel.setEffect(glow);
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setRadius(5.0);
        dropShadow2.setOffsetX(3.0);
        dropShadow2.setOffsetY(3.0);
        htpLabel.setEffect(dropShadow2);
        rules.setStyle("-fx-font-weight: bold");
        morerules.setStyle("-fx-font-weight: bold");
        morerules2.setStyle("-fx-font-weight: bold");
    }

    /*public static CreditsPane getInstance(){
        return creditsPane;
    }*/

}