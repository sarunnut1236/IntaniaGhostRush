package rendering;

import input.InputUtil;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import logic.GameLogic;

public class GameScreen extends Canvas {
	private Camera camera;
	private String imgURL = "backGround.png";
	private Image img = new Image(ClassLoader.getSystemResource(imgURL).toString());
	
	public static int width;
	public static int height;
	
	public GameScreen(double width, double height) {
		super(width, height);
		GameScreen.width = (int)width;
		GameScreen.height = (int)height;
		this.setVisible(true);
		GraphicsContext gc = this.getGraphicsContext2D();
		camera = new Camera(0,0);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
		addListener();
	}
	
	public void addListener() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtil.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtil.setKeyPressed(event.getCode(), false);
		});
	}
	
	public void update() {
		GraphicsContext gc = this.getGraphicsContext2D();
		camera.update();
		gc.translate(camera.getX(), camera.getY()); //begin of camera
		
		gc.drawImage(img, GameLogic.getInstance().getPlayer().getX() - 200, camera.getY());
		for (Renderable object : RenderableHolder.getInstance().getObjects()) {
			object.render(gc);
		}
		gc.translate(-camera.getX(), -camera.getY()); //end of camera
	}
	
}
