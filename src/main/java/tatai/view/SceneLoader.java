package tatai.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tatai.Practice;
import tatai.view.controllers.SceneController;

/*
 * This class is responsible for loading any game scene.
 * It handles the FXML loading code automatically such that
 * only the filename of the FXML needs to be given.
 * The FXML file must be in the same package as this class.
 */
public class SceneLoader {
	protected Stage _stage;
	
	public SceneLoader(Stage stage) {
		_stage = stage;
	}
	
	// Assume that the Practice is being played if no stage
	// was given.
	public SceneLoader() {
		_stage = Practice.getInstance().getStage();
	}
	
	// Load the scene.  This is a template method.
	public final void loadScene(String filename) {
		
		// Build loader
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource(filename));
		
		Parent layout = null;
		
		// Load scene
		try {
			layout = loader.load();
			
			// Pass to hook method
			useController(loader.getController());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		// Set scene to stage
		Scene scene = new Scene(layout);
		_stage.setScene(scene);
	}
	
	// Optional hook method
	protected void useController(SceneController controller) {}
}
