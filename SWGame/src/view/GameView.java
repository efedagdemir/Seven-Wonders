package view;

public class GameView {
    private static GameView gameView = new GameView();
    public GamePane gamePane = new GamePane();
    public MainMenuPane mainMenuPane = new MainMenuPane();

    private GameView() {
    }

    public static GameView getInstance() {
//        if(gameView == null){
//            gameView = new GameView();
//        }
        return gameView;
    }
}
