package menuComponents;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import logic.GameLogic;

public class PlayAgainButton extends MyButton {
	
	public PlayAgainButton() {
		setOnClick();
		imgURL = "playAgainButton.png";
		Image image = new Image(ClassLoader.getSystemResource(imgURL).toString());
		this.setImage(image);
	}
	
	public void setOnClick() {
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				audio.play();
				GameLogic.getInstance().play();
			}
			
		});
	}
}
