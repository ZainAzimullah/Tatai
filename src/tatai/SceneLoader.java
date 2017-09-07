package tatai;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneLoader {
	private Stage _stage = Game.getInstance().getStage();
	private Number _number;
	
	public SceneLoader(Number number) {
		_number = number;
	}
	
	public SceneLoader() {
		
	}
	
	public void loadScene(String filename) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource(filename));
		
		Parent layout;
		
		try {
			layout = loader.load();
		} catch (IOException e) {
			throw new TataiException(e.getMessage());
		}
		
		SceneController controller = loader.getController();
		controller.setNumber(_number);
		
		Scene scene = new Scene(layout);
		_stage.setScene(scene);
	}
}
