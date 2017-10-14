package tatai;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import tatai.view.MainMenuLoader;

public class Main extends Application {
	public static final String SCORES_FOLDER = System.getProperty("user.dir") + "/.scores";
	public static final String QUESTIONS_FOLDER = System.getProperty("user.dir") + "/.questionLists";
	
	// Launch application
	@Override
	public void start(Stage stage) throws IOException {
		File scores = new File(SCORES_FOLDER);
		File lists = new File(QUESTIONS_FOLDER);

		scores.mkdir();
		lists.mkdir();

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
