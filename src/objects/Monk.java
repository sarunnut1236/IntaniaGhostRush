package objects;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import rendering.Renderable;

public class Monk extends GameObject implements Renderable, Collidable {
	private int z;
	private static ArrayList<String> monks = new ArrayList<String>();
	private Image image;
	public static final float HEIGHT = 50;
	public static final float WIDTH = 50;
	
	public Monk(float x, float y) {
		super(x, y, WIDTH, HEIGHT);
		z = 0;
		Random r = new Random();
		int i = r.nextInt() % monks.size();
		if (i < 0) i = -i;
		String imgURL = monks.get(i);
		image = new Image(ClassLoader.getSystemResource(imgURL).toString());
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
		return new Rectangle((int)x + 2, (int)y + 2, WIDTH - 4, HEIGHT - 4);
	}

	public static ArrayList<String> getMonks() {
		return monks;
	}

	public static void setMonks(ArrayList<String> monks) {
		Monk.monks = monks;
	}
	
}
