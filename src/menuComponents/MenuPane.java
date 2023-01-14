package menuComponents;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;

public class MenuPane extends MyPane {
	private PlayButton playButton;
	private HelpButton helpButton;
	private ExitButton exitButton;
	
	public MenuPane() {
		super();
		
		imgURL = "mainMenu.png";
		image = new Image(ClassLoader.getSystemResource(imgURL).toString());
		imgView= new ImageView(image);
		audioURL = "bgm.mp3";
		audio = new AudioClip(ClassLoader.getSystemResource(audioURL).toString());
		
		playButton = new PlayButton();
		helpButton = new HelpButton();
		exitButton = new ExitButton();
		
		this.getChildren().add(imgView);
		
		GridPane gp = new GridPane();
		
		gp.setPrefHeight(600);
		gp.setPrefWidth(800);
		gp.setPadding(new Insets(10));
		gp.setHgap(70);
		
		
		gp.add(helpButton, 0, 1);
		gp.add(playButton, 1, 1);
		gp.add(exitButton, 2, 1);
		gp.setAlignment(Pos.BOTTOM_CENTER);
		
		this.getChildren().add(gp);
		
		audio.setVolume(0.1);
		audio.play();
	}

	public PlayButton getPlayButton() {
		return playButton;
	}

	public void setPlayButton(PlayButton playButton) {
		this.playButton = playButton;
	}

	public HelpButton getHelpButton() {
		return helpButton;
	}

	public void setHelpButton(HelpButton helpButton) {
		this.helpButton = helpButton;
	}

	public ExitButton getExitButton() {
		return exitButton;
	}

	public void setExitButton(ExitButton exitButton) {
		this.exitButton = exitButton;
	}
	

}
