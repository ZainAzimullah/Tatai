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

public class TestLoader extends Application {

    private static final String FILENAME = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("RewardScreen.fxml"));
        if (loader == null) {
            System.out.println("loader is null");
        }

        Parent layout = loader.load();

        FactController controller = loader.getController();
        controller.setStage(primaryStage);

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
