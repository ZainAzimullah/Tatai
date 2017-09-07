package tatai.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tatai.Game;
import tatai.Number;
import tatai.TataiException;

public class SceneLoader {
	private Stage _stage = Game.getInstance().getStage();
	private Number _number;
	
	// Construct a scene loader for a given number
	public SceneLoader(Number number) {
		_number = number;
	}
	
	// Constructor for when scene doesn't need a number
	public SceneLoader() {
		
	}
	
	// Load the scene
	public void loadScene(String filename) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource(filename));
		
		Parent layout;
		
		try {
			layout = loader.load();
		} catch (IOException e) {
			throw new TataiException(e.getMessage());
		}
		
		// Tell the controller what number the user is being tested on.
		// If _number is still null at this point, then it doesn't matter as it
		// is likely that the controller won't use a number.
		SceneController controller = loader.getController();
		controller.setNumber(_number);
		
		Scene scene = new Scene(layout);
		_stage.setScene(scene);
	}
}
