package view;

public class GameView {
    private static GameView gameView = new GameView();
    public GamePane gamePane = new GamePane();
    public MainMenuPane mainMenuPane = new MainMenuPane();
    public NextTurnPane nextTurnPane = new NextTurnPane();
    public CreditsPane creditsPane = new CreditsPane();

    private GameView() {
    }

    public static GameView getInstance() {
//        if(gameView == null){
//            gameView = new GameView();
//        }
        return gameView;
    }
}
