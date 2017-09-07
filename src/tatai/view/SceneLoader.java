package tatai.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tatai.Game;

public class SceneLoader {
	private Stage _stage = Game.getInstance().getStage();
	
	// Constructor for when scene doesn't need a number
	public SceneLoader() {
		
	}
	
	// Load the scene
	public void loadScene(String filename) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource(filename));
		
		Parent layout = null;
		
		try {
			layout = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		Scene scene = new Scene(layout);
		_stage.setScene(scene);
	}
}
