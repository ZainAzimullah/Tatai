package tatai;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tatai.view.MainMenuController;
import tatai.view.MainMenuLoader;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws IOException {
		stage.setResizable(false);
		stage.setOnCloseRequest(e -> {
			new File(System.getProperty("user.dir") + "/foo.wav").delete();
			new File(System.getProperty("user.dir") + "/history.txt").delete();
		});
		
		MainMenuLoader loader = new MainMenuLoader(stage);
		loader.loadScene("MainMenu.fxml");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
