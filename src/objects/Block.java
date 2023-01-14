package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import rendering.Renderable;

public class Block extends GameObject implements Renderable, Collidable {
	private int z;
	private String imgURL = "floor.png";
	private Image image = new Image(ClassLoader.getSystemResource(imgURL).toString());
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	
	public Block(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		// TODO Auto-generated constructor stub
		z = 0;
	}
	
	public Rectangle getBound() {
		return new Rectangle((int)x, (int)y, WIDTH, HEIGHT);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(image, x, y);
	}

	
}
