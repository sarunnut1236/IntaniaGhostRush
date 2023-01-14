package logic;

import java.util.ArrayList;
import java.util.Random;
import input.InputUtil;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import menuComponents.GameOverPane;
import menuComponents.MainMenuButton;
import menuComponents.MenuPane;
import menuComponents.NextButton;
import menuComponents.WinPane;
import objects.Block;
import objects.Monk;
import objects.Player;
import objects.Professor;
import rendering.GameScreen;
import rendering.Renderable;
import rendering.RenderableHolder;

public class GameLogic {
	private static final GameLogic INSTANCE = new GameLogic();
	private MenuPane menuPane;
	private GameOverPane gameOverPane;
	private WinPane winPane;
	private Stage stage;
	private Scene scene;
	private Player player;
	private GameScreen gameScreen;
	private Status status;
	private AnimationTimer animationTimer;
	private ArrayList<String> maps;
	
	
	public static double gravity = 0.5; 
	
	
	public GameLogic() {
		menuPane = new MenuPane();
		maps = new ArrayList<String>();
		maps.add("map1.png");
		maps.add("map2.png");
		maps.add("map3.png");
		Monk.getMonks().add("monk1.png");
		Monk.getMonks().add("monk2.png");
		Monk.getMonks().add("monk3.png");
	}
	
	public void win() {
		animationTimer.stop();
		winPane = new WinPane();
		scene.setRoot(winPane);
	}
	
	public void help() {
		menuPane.getChildren().clear();
		String imgURL = "howToPlayMenu.png";
		Image image = new Image(ClassLoader.getSystemResource(imgURL).toString());
		ImageView howToPlay = new ImageView(image);
		menuPane.getChildren().add(howToPlay);
		GridPane gp = new GridPane();
		
		gp.setPrefHeight(600);
		gp.setPrefWidth(800);
		gp.setPadding(new Insets(10,10,20,100));
		gp.setHgap(50);
		
		NextButton next = new  NextButton();
		gp.setAlignment(Pos.BOTTOM_CENTER);
		gp.add(next, 5, 0);
		
		menuPane.getChildren().add(gp);
	}
	
	public void nextHelp() {
		menuPane.getChildren().clear();
		String imgURL = "nextHowToPlayMenu.png";
		Image image = new Image(ClassLoader.getSystemResource(imgURL).toString());
		ImageView howToPlay = new ImageView(image);
		menuPane.getChildren().add(howToPlay);
		GridPane gp = new GridPane();
		gp.setPrefHeight(600);
		gp.setPrefWidth(800);
		gp.setPadding(new Insets(10));
		gp.setHgap(50);
		
		MainMenuButton main = new MainMenuButton();
		gp.add(main, 0, 0);
		gp.setAlignment(Pos.BOTTOM_CENTER);
		
		menuPane.getChildren().add(gp);
	}
	
	public void gameOver() {
		animationTimer.stop();
		gameOverPane = new GameOverPane();
		status = Status.GameOver;
		scene.setRoot(gameOverPane);
	}
	
	public void play() {
		menuPane.getAudio().stop();
		status = Status.Playing;
		player = new Player(300,300);
		RenderableHolder.getInstance().getObjects().clear();
		Random r = new Random();
		int select = r.nextInt() % maps.size();
		if (select < 0) select = -select;
		Image image = new Image(ClassLoader.getSystemResource(maps.get(select)).toString());
		RenderableHolder.getInstance().setObjects(generateMap(image));
		RenderableHolder.getInstance().add(player);
		player.setX(300);
		player.setY(300);
		Group g = new Group();
		gameScreen = new GameScreen(800,600);
		g.getChildren().add(gameScreen);
		scene.setRoot(g);
		gameScreen.requestFocus();
		stage.show();
		update();
		InputUtil.clear();
		animationTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				update();
				gameScreen.update();
			}
		};
		animationTimer.start();
	}
	
	public void menu() {
		if (animationTimer != null) animationTimer.stop(); 
		if (menuPane != null && menuPane.getAudio() != null) menuPane.getAudio().stop();
		menuPane = new MenuPane();
		status = Status.Menu;
		scene.setRoot(menuPane);
	}

	public static GameLogic getInstance() {
		return INSTANCE;
	}
	
	public ArrayList<Renderable> generateMap(Image img) {
		ArrayList<Renderable> arr = new ArrayList<Renderable>();
		PixelReader px = img.getPixelReader();
		
		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {
				int pixel = px.getArgb(x, y);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if (red == 0 && green == 0 && blue == 255) {
					arr.add(new Block(x * Block.WIDTH, y * Block.HEIGHT));
				}
				
				if (red == 255 && green == 0 && blue == 0) {
					arr.add(new Monk(x * Block.WIDTH, y * Block.HEIGHT));
				}
				
				if (red == 0 && green == 255 && blue == 0) {
					arr.add(new Professor(x * Block.WIDTH, y * Block.HEIGHT));
				}
				
			}
		}
		
		return arr;
	}
	
	
	
	public void update() {
		player.update();
	}

	public MenuPane getMenuPane() {
		return menuPane;
	}
	
	public void setMenuPane(MenuPane menuPane) {
		this.menuPane = menuPane;
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public GameOverPane getGameOverPane() {
		return gameOverPane;
	}

	public void setGameOverPane(GameOverPane gameOverPane) {
		this.gameOverPane = gameOverPane;
	}

	public WinPane getWinPane() {
		return winPane;
	}

	public void setWinPane(WinPane winPane) {
		this.winPane = winPane;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}

	public AnimationTimer getAnimationTimer() {
		return animationTimer;
	}

	public void setAnimationTimer(AnimationTimer animationTimer) {
		this.animationTimer = animationTimer;
	}

	public ArrayList<String> getMaps() {
		return maps;
	}

	public void setMaps(ArrayList<String> maps) {
		this.maps = maps;
	}

	public static void setGravity(double gravity) {
		GameLogic.gravity = gravity;
	}
	
}
