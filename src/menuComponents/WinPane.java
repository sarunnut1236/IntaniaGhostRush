package menuComponents;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;

public class WinPane extends MyPane {
	
	public WinPane() {
		super();
		
		imgURL = "winMenu.png";
		image = new Image(ClassLoader.getSystemResource(imgURL).toString());
		imgView= new ImageView(image);
		audioURL = "winSound.mp3";
		audio = new AudioClip(ClassLoader.getSystemResource(audioURL).toString());
		
		this.setPrefWidth(800);
		this.setPrefHeight(600);
		this.getChildren().add(imgView);
		
		GridPane gp = new GridPane();
		
		gp.setPrefHeight(600);
		gp.setPrefWidth(800);
		gp.setPadding(new Insets(100));
		gp.setHgap(50);
		
		PlayAgainButton playAgain = new PlayAgainButton();
		MainMenuButton mainMenuButton = new MainMenuButton();

		gp.setAlignment(Pos.BOTTOM_CENTER);
		gp.add(playAgain, 0, 1);
		gp.add(mainMenuButton, 1, 1);
		
		this.getChildren().add(gp);
		
		audio.setVolume(0.1);
		audio.play();
	}

}
