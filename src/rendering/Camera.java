package rendering;

import logic.GameLogic;
import objects.Player;

public class Camera {
	private float x;
	private float y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		Player p = GameLogic.getInstance().getPlayer();
		x = GameScreen.width/4 - p.getX();
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	
}
