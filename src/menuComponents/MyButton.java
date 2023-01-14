package menuComponents;

import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

public abstract class MyButton extends ImageView {
	
	protected String imgURL;
	protected String audioURL = "clickSound.mp3";
	protected AudioClip audio = new AudioClip(ClassLoader.getSystemResource(audioURL).toString());
	
	public MyButton() {
		super();
	}
	
	public abstract void setOnClick();

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getAudiourl() {
		return audioURL;
	}

	public AudioClip getAudio() {
		return audio;
	}
	
	
}
