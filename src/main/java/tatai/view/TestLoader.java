package tatai.view;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tatai.expressionModel.EasyExpressionModel;
import tatai.score.Score;
import tatai.view.controllers.gameControllers.FactController;

/**
 * Test class to test the loading of scenes
 */
public class TestLoader extends Application {

    private static final String FILENAME = "Reward.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        FactLoader loader = new FactLoader(primaryStage);
        loader.loadScene(FILENAME);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
