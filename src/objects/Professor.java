package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import rendering.Renderable;

public class Professor extends GameObject implements Renderable, Collidable {
	private int z;
	private String imgURL = "professor.png";
	private Image image = new Image(ClassLoader.getSystemResource(imgURL).toString());
	public static final float WIDTH = 50;
	public static final float HEIGHT = 50;

	public Professor(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		z = 0;
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

	@Override
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, WIDTH, HEIGHT);
	}
	

}
