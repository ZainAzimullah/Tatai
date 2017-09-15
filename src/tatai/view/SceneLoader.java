package tatai.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tatai.Game;
import tatai.view.controllers.SceneController;

public class SceneLoader {
	protected Stage _stage;
	
	public SceneLoader(Stage stage) {
		_stage = stage;
	}
	
	public SceneLoader() {
		_stage = Game.getInstance().getStage();
	}
	
	// Load the scene
	public void loadScene(String filename) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource(filename));
		
		Parent layout = null;
		
		try {
			layout = loader.load();
			useController(loader.getController());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		Scene scene = new Scene(layout);
		_stage.setScene(scene);
	}
	
	protected void useController(SceneController controller) {}
}
