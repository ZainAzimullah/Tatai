package tatai;

import javafx.stage.Stage;

public class Game {
    private static Game _game;
    private static Stage _stage;

    private Game(Stage stage) {
        _stage = stage;
    }

    private Game() {
        // Singleton
    }

    public static Game getInitialInstance(Stage stage) {
        if (_game == null) {
            _game = new Game(stage);
        }

        return _game;
    }

    public static Game getInstance() {
        if (_game == null) {
            _game = new Game();
        }

        return _game;
    }

    public void selectLevel() {

    }

    public Stage getStage() {
        return _stage;
    }
}
