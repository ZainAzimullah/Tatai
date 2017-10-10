package tatai;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import tatai.view.MainMenuLoader;

public class Main extends Application {
	
	// Launch application
	@Override
	public void start(Stage stage) throws IOException {
		// Set unresizable
		stage.setResizable(false);
		
		// Cleanup files on close
		stage.setOnCloseRequest(e -> {
			new File(System.getProperty("user.dir") + "/foo.wav").delete();
		});
		
		// Show the main menu
		MainMenuLoader loader = new MainMenuLoader(stage);
		loader.loadScene("MainMenu.fxml");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
