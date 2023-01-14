package menuComponents;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;

public class MyPane extends StackPane {
	protected String imgURL;
	protected Image image;
	protected ImageView imgView;
	protected String audioURL;
	protected AudioClip audio;
	
	
	public MyPane() {
		super();
	}
	
	public String getImgURL() {
		return imgURL;
	}


	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public ImageView getImgView() {
		return imgView;
	}


	public void setImgView(ImageView imgView) {
		this.imgView = imgView;
	}


	public String getAudioURL() {
		return audioURL;
	}


	public void setAudioURL(String audioURL) {
		this.audioURL = audioURL;
	}


	public AudioClip getAudio() {
		return audio;
	}


	public void setAudio(AudioClip audio) {
		this.audio = audio;
	}
	
}
