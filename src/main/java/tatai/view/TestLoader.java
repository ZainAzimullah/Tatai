package tatai.view;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tatai.expressionModel.EasyExpressionModel;
import tatai.score.Score;

public class TestLoader extends Application {

    private static final String FILENAME = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainMenuLoader loader = new MainMenuLoader(primaryStage);

        loader.loadScene("StatsScene.fxml");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
