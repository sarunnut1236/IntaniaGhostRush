package objects;

import input.InputUtil;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import logic.GameLogic;
import rendering.Renderable;
import rendering.RenderableHolder;

public class Player extends GameObject implements Renderable, Collidable {
	private int z;
	private boolean falling;
	private boolean jumping;
	private int jumpVelocity;
	private String imgURL = "player.png";
	private Image image = new Image(ClassLoader.getSystemResource(imgURL).toString());
	private String audioURL = "jumpSound.wav";
	private AudioClip audio = new AudioClip(ClassLoader.getSystemResource(audioURL).toString());
	public static final float WIDTH = 50;
	public static final float HEIGHT = 67;
	
	public Player(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		falling = true;
		jumping = true;
		jumpVelocity = 15;
	}
	
	public void update() {
			
		if (falling) {
			dy += GameLogic.gravity;
		}
		
		if (InputUtil.getKeyPressed(KeyCode.A)) {
			dx = -7;
		} else if (InputUtil.getKeyPressed(KeyCode.D)) {
			dx = 7;
		} else {
			dx = 0;
		}
		
		if ((InputUtil.getKeyPressed(KeyCode.SPACE) || InputUtil.getKeyPressed(KeyCode.W)) && 
				!jumping) {
			audio.play();
			dy = -jumpVelocity;
			falling = true;
			jumping = true;
		}
		
		x += dx;
		y += dy;
		
		checkCollision();
		
	}
	
	public void checkCollision() {
		boolean standOnGround = false;
		for (Renderable obj : RenderableHolder.getInstance().getObjects()) {
			if (obj instanceof Collidable && !(obj instanceof Player)) {
				Collidable c = (Collidable) obj;
				if (getBound().intersects(c.getBound().getBoundsInParent())) {
					y = ((GameObject)c).getY() - height;
					dy = 0; 
					falling = false;
					jumping = false;
					standOnGround = true;
					if (c instanceof Monk) GameLogic.getInstance().gameOver();
					if (c instanceof Professor) GameLogic.getInstance().win();
				} 
				
				if (getBoundTop().intersects(c.getBound().getBoundsInParent())) {
					y = ((GameObject)c).getY() + ((GameObject)c).getHeight() + (float)GameLogic.gravity + 1;
					dy = (float) GameLogic.gravity;
					if (c instanceof Monk) GameLogic.getInstance().gameOver();
					if (c instanceof Professor) GameLogic.getInstance().win();
				}
				
				if (getBoundLeft().intersects(c.getBound().getBoundsInParent())) {
					x = ((GameObject)c).getX() + ((GameObject)c).getWidth();
					if (c instanceof Monk) GameLogic.getInstance().gameOver();
					if (c instanceof Professor) GameLogic.getInstance().win();
				}
				
				if (getBoundRight().intersects(c.getBound().getBoundsInParent())) {
					x = ((GameObject)c).getX() - getWidth();
					if (c instanceof Monk) GameLogic.getInstance().gameOver();
					if (c instanceof Professor) GameLogic.getInstance().win();
				}
				
			}
		}
		if (!standOnGround) {
			falling = true;
			jumping = true;
		}
	}
	
	public Rectangle getBound() {
		return new Rectangle((int)(x + width / 4), (int)(y + height / 2), (int)width / 2, (int) height / 2);
	}
	public Rectangle getBoundTop() {
		return new Rectangle((int)(x + width / 4), (int)y, (int)width / 2, (int)height / 2);
	}
	public Rectangle getBoundLeft() {
		return new Rectangle((int)x, (int)y + 5, 5, (int)height-10);
	}
	public Rectangle getBoundRight() {
		return new Rectangle((int)(x + width - 5), (int)y + 5, 5, (int)height - 10);
	}
	
	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void render(GraphicsContext gc) {
		gc.drawImage(image, x, y);
	}
	
}
