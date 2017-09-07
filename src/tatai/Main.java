package tatai;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage _stage;

	@Override
	public void start(Stage stage) throws IOException {
		_stage = stage;
		_stage.setResizable(false);
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("MainMenu.fxml"));
		
		Parent layout = loader.load();
		((MainMenuController) loader.getController()).setStage(_stage);
		
		Scene scene = new Scene(layout);
		
		_stage.setScene(scene);
		_stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
