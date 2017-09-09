package tatai;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tatai.view.MainMenuController;

public class Main extends Application {
	
	private Stage _stage;
	
	@Override
	public void start(Stage stage) throws IOException {
		_stage = stage;
		_stage.setResizable(false);
		
		// Load main menu
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("view/MainMenu.fxml"));
		Parent layout = loader.load();
		
		// Give stage to MainMenuController
		((MainMenuController) loader.getController()).setStage(_stage);
		
		Scene scene = new Scene(layout);
		_stage.setScene(scene);
		_stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
