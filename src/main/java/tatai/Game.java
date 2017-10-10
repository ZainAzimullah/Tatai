package tatai;

public class Game {
    private static Game _game;


    private Game() {
        // Singleton
    }

    public static Game getInstance() {
        if (_game == null) {
            _game = new Game();
        }

        return _game;
    }


}
