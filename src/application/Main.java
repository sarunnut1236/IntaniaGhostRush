package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import logic.GameLogic;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(GameLogic.getInstance().getMenuPane());
		stage.setScene(scene);
		GameLogic.getInstance().setScene(scene);
		GameLogic.getInstance().setStage(stage);
		GameLogic.getInstance().menu();
		stage.getIcons().add(new Image(ClassLoader.getSystemResource("icon.png").toString()));
		stage.setTitle("IntaniaGhostRush");
		stage.show();
		stage.setResizable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
